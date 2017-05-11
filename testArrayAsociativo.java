

import static org.junit.Assert.*;

import java.util.*;

import org.junit.*;
public class testArrayAsociativo {

	ArrayAsociativo arrayvacio;
	ArrayAsociativo arraynovacio;
	String[] claves = new String[]{"nombre", "apellido", "dni", "pais"};
	String[] valores = new String[]{"luis", "martin", "123456P", "Espa�a"};
	
	@Before
	public void Iniciar(){
		arrayvacio = new ArrayAsociativo();
		arraynovacio = new ArrayAsociativo(claves, valores);
	}
	
	@After
	public void Acabar(){
		arrayvacio = null;
		arraynovacio = null;
	}
	
	@Test
	public void Tama�oEnArrayVacio() {
		assertEquals(new Integer(0), new Integer(arrayvacio.size()));
	}
	
	@Test
	public void Tama�oEnArrayNoVacio() {
		assertEquals(new Integer(4), new Integer(arraynovacio.size()));
	}
	
	@Test(expected= NoSuchElementException.class)
	public void BuscarClaveArrayVacio(){
		assertEquals("Epa�a", arrayvacio.get("pais"));
	}
	@Test
	public void BuscarClaveArrayConClave(){
		assertEquals("Espa�a", arraynovacio.get("pais"));
	}
	
	@Test(expected= NoSuchElementException.class)
	public void BuscarClaveArraySinClave(){
		assertEquals("20", arraynovacio.get("edad"));
	}
	
	@Test
	public void InsertarEnArrayVacio(){
		ArrayAsociativo ar = new ArrayAsociativo();
		ar.put("edad", "20");
		assertEquals("20", ar.get("edad"));
		assertEquals(new Integer(1), new Integer(ar.size()));
		ar = null;
	}
	
	@Test
	public void InsertarEnArrayNoVacio(){
		ArrayAsociativo ar = new ArrayAsociativo(claves, valores);
		ar.put("edad", "20");
		assertEquals("20", ar.get("edad"));
		assertEquals(new Integer(5), new Integer(ar.size()));
		ar = null;
	}
	

}
