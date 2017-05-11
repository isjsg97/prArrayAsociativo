import java.util.*;

public class ArrayAsociativo {
	//Clases internas
	private class Nodo{
		private String clave;
		private String valor;
		private Nodo sig; //siguiente nodo
		
		public Nodo(String c, String v, Nodo s){
			clave = c;
			valor = v;
			sig = s;
		}
	}
	
	//Variables de instancia
	private Nodo primero;
	
	private int numnodos;
	
	//Constructores
	public ArrayAsociativo(){
		primero = null;
	}
	
	public ArrayAsociativo(String[] claves, String[] valores){
		this();
		if (claves.length > 0){
			primero = new Nodo(claves[0], valores[0],null);
			numnodos++;
			for (int i = 1; i< claves.length; i++){
				Nodo nuevo = new Nodo(claves[i], valores[i],primero);
				primero = nuevo;
				numnodos++;
			}
		}
	}
	
	//Métodos de instancia

	public int size(){
		return numnodos;
	}
	
	public String get(String c){
		String res = "";
		if(numnodos == 0){
			throw new NoSuchElementException();
		}else{
			Nodo nodo = primero;
			while(nodo != null){
				if(nodo.clave.equals(c)){
					res = nodo.valor;
					break;
				}
				nodo = nodo.sig;
			}
			
			if(nodo == null){
				throw new NoSuchElementException();
			}
			
		}
		
		return res;
	}
	
	
	public void put(String c, String v){
		
	}
	
}
