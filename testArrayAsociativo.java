

import static org.junit.Assert.*;

import java.util.*;

import org.junit.*;
public class testArrayAsociativo {

	ArrayAsociativo arrayvacio;
	ArrayAsociativo arraynovacio;
	String[] claves = new String[]{"nombre", "apellido", "dni", "pais"};
	String[] valores = new String[]{"luis", "martin", "123456P", "España"};
	
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
	public void TamañoEnArrayVacio() {
		assertEquals(new Integer(0), new Integer(arrayvacio.size()));
	}
	
	@Test
	public void TamañoEnArrayNoVacio() {
		assertEquals(new Integer(4), new Integer(arraynovacio.size()));
	}
	
	@Test(expected= NoSuchElementException.class)
	public void BuscarClaveArrayVacio(){
		assertEquals("Epaña", arrayvacio.get("pais"));
	}
	@Test
	public void BuscarClaveArrayConClave(){
		assertEquals("España", arraynovacio.get("pais"));
	}
	
	@Test(expected= NoSuchElementException.class)
	public void BuscarClaveArraySinClave(){
		assertEquals("20", arraynovacio.get("edad"));
	}
	

}
