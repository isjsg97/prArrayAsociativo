

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
		assertEquals(valores[3], arrayvacio.get(claves[3]));
	}
	@Test
	public void BuscarClaveArrayConClave(){
		assertEquals(valores[3], arraynovacio.get(claves[3]));
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
	
	@Test
	public void InsertarEnArrayClave(){
		ArrayAsociativo ar = new ArrayAsociativo(claves, valores);
		ar.put("nombre", "juan");
		assertEquals("juan", ar.get("nombre"));
		assertEquals(new Integer(4), new Integer(ar.size()));
		ar = null;
	}
	
	@Test
	public void BuscarEnArrayVacio(){
		assertEquals("20", arrayvacio.getOrElse("nombre", "20"));
	}
	
	@Test
	public void BuscarEnArrayConClave(){
		assertEquals(valores[0], arraynovacio.getOrElse(claves[0], "alex"));
	}
	@Test
	public void BuscarEnArrayNoClave(){
		ArrayAsociativo ar = new ArrayAsociativo();
		ar.put("nombre", "juan");
		assertEquals("20", ar.getOrElse("edad", "20"));
		ar = null;
	}
	
	@Test
	public void ExisteClaveArrayVacio(){
		assertTrue(false == arrayvacio.containsKey("edad"));
	}
	
	@Test
	public void ExisteClaveArrayConClave(){
		assertTrue(true == arraynovacio.containsKey(claves[0]));
	}
	@Test
	public void ExisteClaveArraySinClave(){
		assertTrue(false == arraynovacio.containsKey("edad"));
	}
	
	@Test
	public void BorrarClaveArrayVacio(){
		assertTrue(false == arrayvacio.remove("edad"));//Antes estaba arraynovacioporerror
	}
	
	@Test
	public void BorrarClaveArrayConClave(){
		ArrayAsociativo ar = new ArrayAsociativo();
		ar.put("nombre", "juan");
		assertTrue(true == ar.remove("nombre"));
		assertTrue(false == ar.containsKey("nombre"));
		assertEquals(new Integer(0), new Integer(ar.size()));
		ar = null;
	}
	
	@Test
	public void BorrarClaveArraySinClave(){
		assertTrue(false == arraynovacio.remove("edad"));
		assertTrue(true == arraynovacio.containsKey("nombre"));
		assertEquals(new Integer(4), new Integer(arraynovacio.size()));
	}
	
}
