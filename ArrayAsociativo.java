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
		
		if(primero == null){
			Nodo nodo = new Nodo(c, v, primero);
			primero = nodo;
			numnodos++;
		}else{
			Nodo nodoact = primero;
			Nodo nodoant = null;
		
			while(nodoact != null){
				if(nodoact.clave.equals(c)){
					nodoact.valor = v;
					break;
				}
				nodoant = nodoact;
				nodoact = nodoact.sig;
			}
		
			if(nodoact == null){
				Nodo nodo = new Nodo(c, v, null);
				nodoant.sig = nodo;
				numnodos++;
			}
		
		}
	}
	
}
