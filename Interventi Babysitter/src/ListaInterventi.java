import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;

public class ListaInterventi implements Serializable
{

		private Nodo head;
		private int elementi;
		
		/**
		 * Metodo costruttore. Consente di creare una lista vuota
		 */
		public ListaInterventi()
		{
			head=null;
			elementi=0;
		}

		/**
		 * Metodo di tipo getter che restituisce il numero di elementi di cui è composto la lista
		 * @return elementi, rappresenta il numero di interventi
		 */
		public int getElementi()
		{
			return elementi;
		}
		
		/**
		 * Metodo privato che permette di creare un oggetto di nodo
		 * @param info rappresenta la componente informativa 
		 * @param link rappresenta il reference al nodo successivo
		 * @return nodo, che rappreenta il nodo creato
		 */
		private Nodo creaNodo(Intervento i, Nodo link)
		{
			Nodo nodo=new Nodo(i);
			nodo.setLink(link);
			return nodo;
		}
		
		/**
		 * Metodo privato che restituisce un oggetto di tipo nodo in una detrminata posizione
		 * @param posizione rappresenta la posizine di cui si vuole ricavare il nodo
		 * @return p che rappresenta il nodo che i ottiene nella posizione desiderata
		 * @throws ListaInterventiException eccezione che si verifica quando la posizione non è valida o la lista è vuota
		 */
		private Nodo getLinkPosizione(int posizione) throws ListaInterventiException 
		{
			
			Nodo p;
			int n;
			p=head;
			n=1;
			
			if (posizione<1 || posizione>getElementi())
				throw new ListaInterventiException("Posizione non valida");
			if (elementi==0)
				throw new ListaInterventiException("Lista vuota");
				
			while(p.getLink()!=null && n<posizione)
			{
				p=p.getLink();	
				n++;
			}
			return p;
		}

		
		/**
		 * Metodo che permette di inserire un Intervento in testa
		 * @param info rappresenta un intervento
		 */
		public void inserisciInterventoInTesta(Intervento i)
		{
			Nodo p=creaNodo(i, head);
			head=p;
			elementi++;
		}
		
		/**
		 * Metodo che permette di inserire un intervento in coda
		 * @param info rappresenta la componente informativa, ossia un accesso
		 * @throws ListaInterventiException si verifica quando la lista è vuota
		 */
		public void inserisciInterventoInCoda(Intervento i) throws ListaInterventiException 
		{
			if(elementi==0)
			{
				inserisciInterventoInTesta(i);
				return;
			}
			
			Nodo pn=creaNodo(i, null);
			Nodo p=getLinkPosizione(elementi);
			p.setLink(pn);
			elementi++;	
		}
		
		/**
		 * Metodo che restituisce una stringa formata da tutti gli interventi con i relativi dati
		 */
		public String toString()
		{
			String risultato="Head \n";
			if (elementi==0)
				return risultato+="--> ";
			Nodo p=head;
			while (p!=null)
			{
				risultato+="-->"+p.getInfo().toString()+"\n";
				p=p.getLink();
			}
			return risultato;
		}

		/**
		 * Metodo che permette di inserire un intervento in una posizione della lista
		 * @param info rappresenta un intervento da inserire 
		 * @param posizione rappresenta la posizione 
		 * @throws LaboratorioException  si verifica se la posizione non è valida
		 */
		public void inserisciInPosizione(Intervento i , int posizione) throws ListaInterventiException 
		{
			if(posizione==1 )
			{
				inserisciInterventoInTesta(i);
				return;
			}
			
			if(posizione<0 || posizione>elementi+1)
				throw new ListaInterventiException("Posizione non valida");
			
			Nodo pn=creaNodo(i, getLinkPosizione(posizione));
			Nodo precedente=getLinkPosizione(posizione-1);
			
			precedente.setLink(pn);
			elementi++;
		}
		
		/**
		 * Metodo per eliminare l'elemento in testa 
		 * @throws ListaInterventiException si verifica quando la lista è vuota
		 */
		public void eliminaInTesta() throws ListaInterventiException 
		{
			if(elementi==0)
				throw new ListaInterventiException("Lista vuota");
			
			head=head.getLink();
			elementi--;
		}
		
		/**
		 * Metodo per eliminare l'elemento in coda alla lista
		 * @throws ListaInterventiException si verifica quando la posizione è vuota
		 */
		public void eliminaInCoda() throws ListaInterventiException
		{
			if(elementi==0)
				throw new ListaInterventiException("Lista vuota");
			if(elementi==1)
			{
				eliminaInTesta();
				return;
			}
			Nodo penultimo=getLinkPosizione(elementi-1);
			penultimo.setLink(null);
			elementi--;
			
		}
		
		/**
		 * Metodo che consente di eliminare un elemento in una posizione
		 * @param posizione rappresenta la posizione 
		 * @throws ListaInterventiException si verifica quando la lista è vuota o la posizione non è valida
		 */
		public void eliminaInPosizione(int posizione) throws ListaInterventiException 
		{
			if(elementi==0)
				throw new ListaInterventiException("Lista vuota");
			if(posizione<0 || posizione>elementi)
				throw new ListaInterventiException("Posizione non valida");
			if(elementi==1)
			{
				eliminaInTesta();
				return;
			}
			if(posizione==elementi)
			{
				eliminaInCoda();
				return;
			}
			Nodo p=getLinkPosizione(posizione);
			Nodo precedente=getLinkPosizione(posizione-1);
			precedente.setLink(p.getLink());
		}
		
		/**
		 * Metodo che permette di recuperare i dati di un intervento in posizione
		 * @param posizione rappresenta la posizione 
		 * @return i dati dell'accesso nella posizione 
		 * @throws ListaInterventiException si verifica quando la lista è vuota o la posizione non è valida
		 */
		public Intervento getIntervento(int posizione) throws ListaInterventiException
		{
			if(elementi==0)
				throw new ListaInterventiException("Lista vuota");
			if(posizione<0 || posizione>elementi)
				throw new ListaInterventiException("Posizione non valida");
			Nodo p=getLinkPosizione(posizione);
			return p.getInfo();
		}

		/**
		 * Metodo che consente di salvare la lista degli interventi in un file binario
		 * @param nomeFile rappresenta il nome del file sul quale si vuole salvare l'oggetto
		 * @throws ListaInterventiException 
		 * @throws IOException eccezione che si verifica per errori nella scrittura del file
		 */
		
		public boolean verificaIntervento(int ID) throws ListaInterventiException 
		{
			
			for (int i = 1; i < getElementi()+1; i++) 
			{
				if(ID==getIntervento(i).getId())
					return true;
			}
			return false;
		
		}
		public void salvaLista(String nomeFile) throws IOException
		{
			FileOutputStream file=new FileOutputStream(nomeFile);
			ObjectOutputStream writer=new ObjectOutputStream(file);
			writer.writeObject(this);
			writer.flush();
			writer.close();
		}
		
		/**
		 * Metodo che consente di caricare un oggetto ti tipo LitaInterventi
		 * @param nomeFile rappresenta il file da cui si effettua la deserializzazione
		 * @return la lista degli interventi
		 * @throws IOException si verifica per errori durante il caricamento del laboratorio
		 * @throws ClassNotFoundException  quando non è possibile deserializzare oggetti di tipo ListaInterventi
		 */
		public ListaInterventi CaricaLista(String nomeFile) throws IOException, ClassNotFoundException
		{
			FileInputStream file=new FileInputStream(nomeFile);
			ObjectInputStream reader=new ObjectInputStream(file);
			
			ListaInterventi l;
			l=(ListaInterventi)reader.readObject();
			file.close();
			return l;
		}

		/**
		 * Metodo che permette di salvare i dati del Laboratorio su un file di testo in formato CSV
		 * @param nomeFile è il file dove si salva la lista
		 * @throws IOException  si verifica per errori input/output
		 * @throws ListaInterventiException se la lista è vuota
		 * @throws FileException eccezione che si verifica se si prova a leggere
		 */
		public void esportaListaCSV(String nomeFile) throws  IOException, ListaInterventiException, FileException
		{
			TextFile file=new TextFile(nomeFile,'W');
			String interventoCSV;
			Intervento intervento;
			if(getElementi()==0)
				throw new ListaInterventiException("Lista vuota");
				
			for (int i = 1; i <=getElementi(); i++) 
			{
				intervento=getIntervento(i);
				interventoCSV=intervento.getNomebabysitter()+";"+intervento.getNomecliente()+";"+intervento.getInizioIntervento()+";"+intervento.getId()+";";
				file.toFile(interventoCSV);
			}
			file.closeFile();
		}

}
