import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.Test;

public class InterventoTest {

	@Test
	public void testCostruttoreIntervento() 
	{
		LocalDateTime inizioIntervento=LocalDateTime.now();
		Intervento i=new Intervento("Laura","Maria",inizioIntervento);
		assertTrue("Costruttore Intervento",i.getId()==1 && i.getNomecliente().compareTo("Laura")==0 && i.getNomebabysitter().compareTo("Maria")==0 && i.getInizioIntervento()==inizioIntervento);
	}
	
	@Test
	public void testCostruttoreInterventoVuoto() 
	{
		Intervento i=new Intervento();
		assertTrue("Costruttore di default Intervento",i.getId()==0 && i.getNomecliente()==null && i.getNomebabysitter()==null && i.getInizioIntervento()==null);
	}

	@Test
	public void testSetId() 
	{
		Intervento i=new Intervento();
		i.setId(1);
		assertTrue("setId",i.getId()==1);
	}

	
	@Test
	public void testSetInizioIntervento() 
	{
		Intervento i=new Intervento();
		LocalDateTime inizioIntervento=LocalDateTime.now();
		i.setInizioIntervento(inizioIntervento);
		assertTrue("setInizioIntervento",i.getInizioIntervento()==inizioIntervento);
	}
	
	@Test
	public void testSetFineIntervento() 
	{
		Intervento i=new Intervento();
		LocalDateTime fineIntervento=LocalDateTime.now();
		i.setFineIntervento(fineIntervento);
		assertTrue("setFineIntervento",i.getFineIntervento()==fineIntervento);
	}
	
	@Test
	public void testSetNomeCliente() 
	{
		Intervento i=new Intervento();
		
		i.setNomecliente("Laura");
		assertTrue("setNomeCliente",i.getNomecliente().compareTo("Laura")==0);
	}
	
	@Test
	public void testSetNomeBabysitter() 
	{
		Intervento i=new Intervento();
		
		i.setNomebabysitter("Laura");
		assertTrue("setNomeBabysitter",i.getNomebabysitter().compareTo("Laura")==0);
	}


}
