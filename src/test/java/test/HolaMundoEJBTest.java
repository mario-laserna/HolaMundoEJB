package test;

import static org.junit.Assert.assertEquals;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;

import org.junit.Before;
import org.junit.Test;

import beans.HolaMundoEJB;

public class HolaMundoEJBTest {
	private static EJBContainer contenedor;
	private static Context contexto;
	private static HolaMundoEJB ejb;
	
	@Before
	public void iniciarContendor() throws Exception{
		System.out.println("Iniciando EJB container");
		contenedor = EJBContainer.createEJBContainer();
		contexto = contenedor.getContext();
		ejb = (HolaMundoEJB)contexto.lookup("java:global/classes/HolaMundoEJB!beans.HolaMundoEJB");
	}
	
	@Test
	public void testAddNumbers() throws Exception{
		int dato1 = 3;
		int dato2 = 6;
		
		int resultado = ejb.sumar(dato1, dato2);
		assertEquals((dato1+dato2),resultado);
		//assertEquals(7,resultado);
		System.out.println("Operación terminada, resultado: " + resultado);
	}
	
	

}
