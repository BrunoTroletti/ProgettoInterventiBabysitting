import java.io.Serializable;

/**
 * La classe Nodo rappresenta un nodo. Il nodo è costituito dai seguenti attributi:
 * un info e un link. Info è la componente informativa, contiene informazioni sugli elementi della lista,
 * mentre link è un puntatore che punta all'elemento successivo della lista. 
 * 
 * @author Bruno Troletti
 * @version 1.0
 */
public class Nodo implements Serializable
{
	private Intervento info;//contiene reference a oggettto
	private Nodo link;
	
	/**
	 * Costruttore della classe nodo. Consente di istanziare un oggetto di tipo nodo.
	 * richiede un invitato, che rappresenta l'attributo info della classe nodo.
	 * 
	 * @param persona è un oggetto di tipo persona
	 */
	public Nodo(Intervento i)
	{
		setInfo(i);
		link = null;
	}
	
	/**
	 * Metodo di tipo getter che restituisce la componente informativa del nodo, ossia un Accesso
	 * @return info che rappresenta un oggetto Intervento
	 */
	public Intervento getInfo() 
	{
		return info;
	}
	
	/**
	 * Metodo di tipo setter che permette di settare la componente informativa del nodo
	 * @param info rappresenta l'Intervento che rappresenterà la componente in formativa del nodo
	 */
	public void setInfo(Intervento info) 
	{
		this.info = new Intervento(info);
		
	}
	
	/**
	 * Metodo di tipo getter che ritorna il link del nodo
	 * @return link rappresenta il reference al nodo successivo
	 */
	public Nodo getLink()
	{
		return link;
	}

	/**
	 * Metodo setter che permette di settare il link di un nodo
	 * @param link rappresenza il reference al nodo successivo che si vuole far assumere  al nodo
	 */
	public void setLink(Nodo link)
	{
		this.link = link;
	}
}
