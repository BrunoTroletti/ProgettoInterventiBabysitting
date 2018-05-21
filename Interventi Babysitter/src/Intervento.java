import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
/**
 * La classe rappresenta un intervento
 * Per ogni intervento si memorizzano: il codice identificativo, il nome del cliente, 
 * il nome della babysitter,ora inizio intervento , fine inizio intervento.
 * La classe espone diversi metodi per impostare i parametri o restituirli e toString per 
 * esportare l'intervento come stringa nel formato 'codice Identificativo; nome cliente; nome babysitter; ora inizio intervento; ora fine intervento'.
 * 
 * @author Bruno Troletti
 * @version 1.0
 */
public class Intervento implements Serializable
{
	private int id;
	private static int contaInterventi=0;
	private double totPagare;
	private String nomecliente;
	private String nomebabysitter;
	private LocalDateTime inizioIntervento;
	private LocalDateTime fineIntervento;
	private static final int COSTO_ORARIO=13;
	
	/**
	 * Costruttore che permette di istanziare un nuovo oggetto di tipo intervento. 
	 * @param containterventi -> contatore che conta  il numero di interventi
	 * @param nomeCliente -> Rappresenta il nome del cliente che ha richiesto l'intervento.
	 * @param nomeBabysitter -> Rappresenta il nome della babysitter che svolgerà l'intervento.
	 * @param iniziointervento -> Rappresenta l'orario e la data di inizio intervento.
	 * @param fineintervento -> Rappresenta l'orario di fineintervento.
	 */
	
	public Intervento(String nomecliente, String nomebabysitter,LocalDateTime inizioIntevento)
	{
		contaInterventi++;
		setId(contaInterventi);;
		setNomecliente(nomecliente);
		setNomebabysitter(nomebabysitter);
		setInizioIntervento(inizioIntevento);
		setFineIntervento(null);
		totPagare=0;
	}
	
	/**
	 * Costruttore di copia. 
	 * Permette di istanziare un nuovo Intervento con parametri uguali al cliente Passato in input.
	 * @param i -> Rappresenta l'intervento da copiare.
	 */

	public Intervento(Intervento i)
	{
		setId(i.getId());
		setNomecliente(i.getNomecliente());
		setNomebabysitter(i.getNomebabysitter());
	}
	
	/**
	 * Costruttore vuoto. Consente di istanziare un oggetto vuoto.
	 */
	
	public Intervento()
	{
		setId(0);;
		setNomecliente(null);
		setNomebabysitter(null);
		setInizioIntervento(null);
		setFineIntervento(null);
		totPagare=0;
	}
	
	/**
	 * Metodo getter che restituisce il totale da pagare di intervento.
	 * @return totPagare
	 */
	
	public double getTotPagare() {
		return totPagare;
	}
	
	/**
	 * Motodo setter che consente di impostare il totale da pagare.
	 * @param totPagare
	 */

	public void setTotPagare(double totPagare) {
		this.totPagare = totPagare;
	}
	
	/**
	 * Metodo getter che restituisce orario e data di intervento.
	 * @return inizioIntervento
	 */
	
	public LocalDateTime getInizioIntervento() 
	{
		return inizioIntervento;
	}
	
	/**
	 * Motodo setter che consente di impostare l'ora e data di un intervento.
	 * @param dataInizioServizio
	 */

	public void setInizioIntervento(LocalDateTime dataInizioServizio) 
	{
		this.inizioIntervento = dataInizioServizio;
	}
	
	/**
	 * Metodo getter che restituisce ora di fine di intervento.
	 * @return fineintervento
	 */

	public LocalDateTime getFineIntervento() 
	{
		return fineIntervento;
	}
	
	/**
	 * Motodo setter che consente di impostare l'ora di fine di un intervento.
	 * @param fineIntervento
	 */

	public void setFineIntervento(LocalDateTime fineIntervento) 
	{
		this.fineIntervento = fineIntervento;
	}
	
	/**
	 * Metodo getter che restituisce il codiceidentificativo di intervento.
	 * @return id
	 */

	public int getId()
	{
		return id;
	}
	
	/**
	 * Motodo setter che consente di impostare il codice identificativo di un intervento.
	 * @param id
	 */

	public void setId(int id) 
	{
		this.id = id;
	}
	
	/**
	 * Metodo getter che restituisce il nomecliente di intervento.
	 * @return nomecliente
	 */

	public String getNomecliente() 
	{
		return nomecliente;
	}
	
	/**
	 * Motodo setter che consente di impostare il nome del cliente  di un intervento.
	 * @param nomecliente
	 */

	public void setNomecliente(String nomecliente) 
	{
		this.nomecliente = nomecliente;
	}
	
	/**
	 * Metodo getter che restituisce il nomebabysitter di intervento.
	 * @return nomebabysitter
	 */

	public String getNomebabysitter() 
	{
		return nomebabysitter;
	}
	
	/**
	 * Motodo setter che consente di impostare il nome della babysitter di un intervento.
	 * @param nomebabysitter
	 */

	public void setNomebabysitter(String nomebabysitter) 
	{
		this.nomebabysitter = nomebabysitter;
	}
	
	/**
	 * Metodo getter che restituisce il costo di un'ora di intervento.
	 * @return COSTO_ORARIO
	 */
	
	public static int getCostoOrario()
	{
		return COSTO_ORARIO;
	}
	
	/**
	 * Metodo  che restituisce il numero di ore di intervento svolte.
	 * @return oreIntervento
	 */
	
	public void calcoloFineIntervento(int oreIntervento)
	{
		setFineIntervento(getInizioIntervento().plusHours(oreIntervento));
	}
	
	/**
	 * Metodo  che restituisce il totale da pagare per l'intervento.
	 * @return totaledaapagre
	 */
	
	public void calcoloPagamento(int oreIntervento)
	{
		double totale;
		totale=oreIntervento*COSTO_ORARIO;
		setTotPagare(totale);
	}
	
	/**
	 * Metodo  che confronta se gli id sono uguali.
	 * @return valore boolean
	 */
	
	public boolean equals(Intervento i)
	{
		if (getId()==i.getId())
			return true;
		else
			return false;
	}
	
	/**
	 * Metodo che consente di esportare l'intervento come stringa 
	 * nel formato 'nomecliente; nomebabysitter; data ora inizio; codice Identificativo.
	 * @return risultato -> Rappresenta la stringa in cui sono riportati i parametri.
	 */
	public String toString()
	{
		return "Nome cliente: "+getNomecliente()+". Nome babysitter: "+getNomebabysitter()+". Data ora inizio: "+getInizioIntervento()+". ID intervento: "+getId();
		//return("Nome cliente: "+getNomecliente()+". Nome babysitter: "+getNomebabysitter()+". Data inizio: "+getInizioIntervento()+". ID intervento: "+getId());
	}

	
}
