import java.io.Serializable;
import java.time.LocalDate;

public class Interventi implements Serializable
{
	private int codiceidentificativointervento;
	private String nomecliente;
	private String nomebabysitter;
	private LocalDate iniziointervento;
	private LocalDate fineintervento;
	
	public Interventi(int codiceidentificativointervento, String nomecliente, String nomebabysitter)
	{
		setCodiceidentificativointervento(codiceidentificativointervento);
		setNomecliente(nomecliente);
		setNomebabysitter(nomebabysitter);
	}
	
	public Interventi(Interventi i)
	{
		setCodiceidentificativointervento(i.getCodiceidentificativointervento());
		setNomecliente(i.getNomecliente());
		setNomebabysitter(i.getNomebabysitter());
	}
	
	public int getCodiceidentificativointervento() {
		return codiceidentificativointervento;
	}

	public void setCodiceidentificativointervento(int codiceidentificativointervento) {
		this.codiceidentificativointervento = codiceidentificativointervento;
	}

	public String getNomecliente() {
		return nomecliente;
	}

	public void setNomecliente(String nomecliente) {
		this.nomecliente = nomecliente;
	}

	public String getNomebabysitter() {
		return nomebabysitter;
	}

	public void setNomebabysitter(String nomebabysitter) {
		this.nomebabysitter = nomebabysitter;
	}
	
	public String toString()
	{
		return(getCodiceidentificativointervento()+" "+getNomecliente()+" "+getNomebabysitter());
	}
}
