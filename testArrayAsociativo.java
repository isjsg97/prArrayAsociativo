

import static org.junit.Assert.*;

import org.junit.*;
public class testArrayAsociativo {

	ArrayAsociativo array;
	
	@Before
	public void Iniciar(){
		array = new ArrayAsociativo();
	}
	
	@After
	public void Acabar(){
		array = null;
	}
	
	@Test
	public void TamañoEnArrayVacio() {
		assertEquals(new Integer(0), new Integer(array.size()));
	}

}
