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
			for (int i = 0; i< claves.length; i++){	
				put(claves[i], valores[i]);
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
	
	public String getOrElse(String c, String vpd){
		String res = vpd;
		
		try{
			res = get(c);
		}catch(NoSuchElementException e){
			
		}
		
		return res;
	}
	
	public boolean containsKey(String c){
		boolean res = true;
		
		try{
			get(c);
		}catch(NoSuchElementException e){
			res = false;
		}
		return res;
	}
	
	public boolean remove(String c){
		boolean res = true;
		if(primero != null){
			Nodo act = primero;
			Nodo ant = null;
			
			while(act != null){
			
				if(act.clave.equals(c)){
					if(ant == null){
						primero = null;
					}else{
						ant.sig = act.sig;
					}
					numnodos--;
					break;
					
				}
				
				ant = act;
				act = act.sig;
			}
			
			
		}
		return res;
	}
	
}
