import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Mainclass 
{

	public static void main(String[] args) throws NumberFormatException, IOException, ListaInterventiException
	{

		String[] vociMenu= {"1--> Prenota nuovo intervento", 
				"2-->Inserire terminazione servizio",
				"3-->Elimina intervento non ancora svolto dalla lista",
				"4-->Visualizzazione interventi in ordine di data e ora di inizio servizio",
				"5-->Visualizzazione servizi di una determinata bebysiter",
				"5-->Visualizzazione servizi di una determinata di una certa data",
				"0-->ESCI"};
		
		ConsoleInput tastiera=new ConsoleInput();
		Menu menu=new Menu("MENU PRINCIPALE", vociMenu);
		ListaInterventi listaInterventi = new ListaInterventi();
		
	
		int continuare=1;
			
		
		do
		{
			
			switch (menu.scelta())
			{
			
			case 1:
				
				Intervento intervento = new Intervento();
				LocalDateTime dataInizioServizio = LocalDateTime.of(1, 1, 1, 1, 1, 1);
				
				System.out.println("INSERIRE LA DATA DI CUI SI VUOLE PRENOTARE UN INTERVENTO");
					
				System.out.println("Inserisci l'anno (numero): ");
				dataInizioServizio = dataInizioServizio.plusYears(tastiera.readInt()-1);
	
				System.out.println("Inserisci il mese (numero): ");
				dataInizioServizio =dataInizioServizio.plusMonths(tastiera.readInt()-1);
	
				System.out.println("Inserisci il giorno (numero): ");
				dataInizioServizio=dataInizioServizio.plusDays(tastiera.readInt()-1);
				intervento.setInizioIntervento(dataInizioServizio);
					
					try {
						System.out.println("Inserire il nome della babysiter");
						intervento.setNomebabysitter(tastiera.readString());
						System.out.println("Inserire il nome del cliente");
						intervento.setNomecliente(tastiera.readString());
					} catch (NumberFormatException e) {
						System.out.println("Formato dato inserito errato");
					} catch (IOException e) {
						System.out.println("Impossibile leggere da tastiera");
					}
					
					listaInterventi.inserisciInterventoInTesta(intervento);

					try {
						listaInterventi.salvaLista("LItaInterventi.bin");
						System.out.println("Scrittura su file avvenuta con successo");
					} catch (IOException e) {
						System.out.println("Impossibile completare l'operazione");
					}
				break;
		
			case 2:
				 String cliente = "";
				 
				 System.out.println("Inserire il cliente di cui terminare l'attività: ");
				 cliente = tastiera.readString();
				 
				 try
				 {
					 for (int i = 1; i < listaInterventi.getElementi(); i++) 
					 {
						 if(listaInterventi.getIntervento(i).getNomecliente().compareTo(listaInterventi.getIntervento(i+1).getNomecliente())== 0)
						 {
							 listaInterventi.getIntervento(i).setFineIntervento(LocalDateTime.now());
							 
						 }
					 }
				 } catch (ListaInterventiException e)
				 {System.out.println("Errore");}
				
				break;
		
			case 3:
				
				
				break;
				
			
			case 4:
				
				
				break;
			
			case 5:
			
				break;
				
			default:
				break;
			}
		}while(continuare == 1);
		
		
	
		}

}
