import java.io.Serializable;
import java.time.LocalDate;
import java.io.IOException;

public class Mainclass implements Serializable
{
	static ConsoleInput tastiera = new ConsoleInput();

	public static void main(String[] args) 
	{
		String[] elencoFunzioni = new String[7];
		
		elencoFunzioni[0] = "0 --> Esci";
		elencoFunzioni[1] = "1 --> Prenota un nuovo Intervento";
		elencoFunzioni[2] = "2 --> Visualizza tutti gli Intervemti in ordine di data e ora";
		elencoFunzioni[3] = "3 --> Visualizza tutti gli interventi prenotati per una specifica Babysitter";
		elencoFunzioni[4] = "4 --> Visualizza tutti gli interventi prenotati per una specifica data";
		elencoFunzioni[5] = "5 --> Elimina un Intervento inserendo il codice identificativo";
		elencoFunzioni[6] = "6 --> Terminazione di un Intervento";
		
		Menu m = new Menu(elencoFunzioni);
		
		try 
		{
			Intervento=Intervento.caricaIntervento("Interventi.bin");
			System.out.println("file caricati");
		} catch (ClassNotFoundException e1) 
		{
			System.out.println("Impossibile caricare oggetti di tipo Atterraggio");
		}
		catch (IOException e1) 
		{
			System.out.println("Errore caricamento file");
		}
		
		int scelta = 0;
		do 
		{
			scelta = m.sceltaMenu();
			switch (scelta) 
			{
			case 0:
			{
				break;
			}
			case 1:
			{
				Interventi nuovoIntervento = new Interventi();
				int giorno = 0;
				int mese = 0;
				int anno = 0;
				try 
				{
					System.out.println("Inserisci il codice identificativo dell'azienda cliente");
					nuovoCliente.setCodiceIdentificativo(tastiera.readString());
					System.out.println("Inserisci il nome dell'azienda cliente");
					nuovoCliente.setNomeAzienda(tastiera.readString());
					System.out.println("Inserisci la città in cui risiede l'azienda cliente");
					nuovoCliente.setCittaSede(tastiera.readString());
					System.out.println("Inserisci la data in cui l'azienda è diventata cliente");
					System.out.println("Inserisci il giorno");
					giorno = tastiera.readInt();
					System.out.println("Inserisci il mese");
					mese = tastiera.readInt();
					System.out.println("Inserisci l'anno");
					anno = tastiera.readInt();
					LocalDate data = LocalDate.of(anno, mese, giorno);
					nuovoCliente.setData(data);
					listaClienti.inserisciInCoda(nuovoCliente);
					
				} 
				catch (NumberFormatException e) 
				{
					System.out.println("Formato dati errato.");
				} catch (IOException e) 
				{
					System.out.println("Impossibile leggera da tastiera");
				} catch (ListaException e) 
				{
					System.out.println(e.toString());
				}	
				break;
			}
			case 2:
			{
				System.out.println(listaClienti.toString());
				break;
			}
			case 3:
			{
				System.out.println(listaClienti.getOrdineAlfabetico());
				break;
			}
			case 4:
			{
				String cittaSede = null;
				System.out.println("Inserisci la città in cui risiede l'azienda cliente");
				try 
				{
					cittaSede = tastiera.readString();
				} 
				catch (NumberFormatException e) 
				{
					System.out.println("Formato dati errato.");
				} 
				catch (IOException e) 
				{
					System.out.println("Impossibile leggera da tastiera");;
				}
				listaClienti.getClienteCitta(cittaSede);
				for (int i = 0; i < listaClienti.getElementi(); i++) 
				{
					try 
					{
						System.out.println(listaClienti.visita(i));
					} catch (ListaException e) 
					{
						e.toString();
					}
				}
				
				break;
			}
			case 5:
			{
				
				try 
				{
					String codiceDaEliminare = null;
					System.out.println(listaClienti.toString());
					System.out.println("Inserisci il codice identificativo dell'azienda clienti che intendi eliminare (il programma li salva in un file chiamato 'clientiEliminati.txt')");
					codiceDaEliminare = tastiera.readString();
					listaClienti.eliminaCliente(codiceDaEliminare, "clientiEliminati.txt");
				} 
				catch (NumberFormatException e) 
				{
					System.out.println("Formato dati errato.");
				} 
				catch (IOException e) 
				{
					System.out.println("Impossibile leggera da tastiera");;
				} 
				catch (ListaException e) 
				{
					System.out.println(e.toString());
				} 
				catch (NuovaException e) 
				{
					System.out.println(e.toString());
				} 
				catch (FileException e) 
				{
					System.out.println(e.toString());
				}
				break;
			}
			case 6:
			{
				try 
				{
					listaClienti.salvaLista("stampaClienti.bin");
				} 
				catch (IOException e) 
				{
					System.out.println("Impossibile salvare sul file");
				}
				break;
			}
			default:
				System.out.println("Scelta non consentita");
				break;
			}
		} while (scelta != 0);
		
		
		
		
		
		
		
		
		
	}
	
}

		
	


