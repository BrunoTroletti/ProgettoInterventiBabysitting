import static org.junit.Assert.*;

import org.junit.Test;

public class NodoTest 
{

	@Test
	public void testCostruttoreNodo() 
	{
		Intervento i=new Intervento();
		Nodo n=new Nodo(i);
		assertTrue("Costruttore nodo", n.getInfo().equals(i) && n.getLink()==null);
	}

	@Test
	public void testSetInfo() 
	{
		Intervento i=new Intervento();
		Intervento i1=new Intervento();
		Nodo n=new Nodo(i);
		n.setInfo(i1);
		assertTrue("setInfo",n.getInfo().equals(i1) && n.getLink()==null);
	}
	
	@Test
	public void testSetLink() 
	{
		Intervento i=new Intervento();
		Intervento i1=new Intervento();
		Nodo nodo1=new Nodo(i);
		Nodo nodo2=new Nodo(i1);
		nodo1.setLink(nodo2);
		assertTrue("setLink",nodo1.getInfo().equals(i1)&&nodo1.getLink()==nodo2);
	}

}
