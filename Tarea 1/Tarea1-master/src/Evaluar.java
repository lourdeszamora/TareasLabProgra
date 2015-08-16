import static org.junit.Assert.*;

import org.junit.Test;


public class Evaluar {

	@Test
	public void sumar()
	{
		assertEquals("Rrror calculando sumar(5,4)", 9, Ejercicios.sumar(5,4));
		assertEquals("Rrror calculando sumar(2,1)", 3, Ejercicios.sumar(2,1));
	}
	
	@Test
	public void restar()
	{
		assertEquals("Rrror calculando restar(2,1)", 1, Ejercicios.restar(2,1));
		assertEquals("Rrror calculando restar(6,3)", 3, Ejercicios.restar(6,3));
	}
	
	@Test
	public void multiplicar()
	{
		assertEquals("Rrror calculando multiplicar(2,2)", 4, Ejercicios.multiplicar(2,2));
		assertEquals("Rrror calculando multiplicar(5,3)", 15, Ejercicios.multiplicar(5,3));
	}
	
	@Test
	public void residuo()
	{
		assertEquals("Rrror calculando residuo(4,3)", 1, Ejercicios.residuo(4,3));
		assertEquals("Rrror calculando residuo(17,5)", 2, Ejercicios.residuo(17,5));
	}
	
	@Test
	public void esPar()
	{
		assertEquals("Rrror calculando esPar(4)", true, Ejercicios.esPar(4));
		assertEquals("Rrror calculando esPar(9)", false, Ejercicios.esPar(9));
	}
	
	@Test
	public void esMultiploDe3()
	{
		assertEquals("Rrror calculando esMultiploDe3(4)", false, Ejercicios.esMultiploDe3(4));
		assertEquals("Rrror calculando esMultiploDe3(9)", true, Ejercicios.esMultiploDe3(9));
	}
	
	@Test
	public void getMayor()
	{
		assertEquals("Rrror calculando getMayor(4,2)", 4, Ejercicios.getMayor(4,2));
		assertEquals("Rrror calculando getMayor(1,9)", 9, Ejercicios.getMayor(1,9));
	}
	
	@Test
	public void esMayorDeEdad()
	{
		assertEquals("Rrror calculando esMayorDeEdad(12)", false, Ejercicios.esMayorDeEdad(12));
		assertEquals("Rrror calculando esMayorDeEdad(19)", true, Ejercicios.esMayorDeEdad(19));
		assertEquals("Rrror calculando esMayorDeEdad(18)", true, Ejercicios.esMayorDeEdad(18));
	}
	
	@Test
	public void sonPares()
	{
		assertEquals("Rrror calculando sonPares(1,3,4)", false, Ejercicios.sonPares(1,3,4));
		assertEquals("Rrror calculando sonPares(2,6,8)", true, Ejercicios.sonPares(2,6,8));
		assertEquals("Rrror calculando sonPares(11,6,8)", false, Ejercicios.sonPares(11,6,8));
		assertEquals("Rrror calculando sonPares(2,10,100)", true, Ejercicios.sonPares(2,10,100));
	}
	
	@Test
	public void getMayorDe3()
	{
		assertEquals("Rrror calculando getMayorDe3(12,5,2)", 12, Ejercicios.getMayorDe3(12,5,2));
		assertEquals("Rrror calculando getMayorDe3(5,19,1)", 19, Ejercicios.getMayorDe3(5,19,1));
		assertEquals("Rrror calculando getMayorDe3(1,4,18)", 18, Ejercicios.getMayorDe3(1,4,18));
	}

}
