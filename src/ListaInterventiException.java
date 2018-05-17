
public class ListaInterventiException
{
private String messaggio;
	
	public ListaInterventiException (String messaggio)
	{
		this.messaggio=messaggio;
	}
	public String toString()
	{
		return messaggio;
	}
}
