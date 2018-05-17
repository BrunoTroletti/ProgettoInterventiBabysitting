import java.io.Serializable;

public class Nodo implements Serializable
{
	private Intervento info;
	private Nodo link;
	
	public Nodo(Intervento p)
	{
		setInfo(p);
		link=null;
	}

	public Intervento getInfo() 
	{
		return info;
	}

	public void setInfo(Intervento info) 
	{
		this.info = info;
	}

	public Nodo getLink() 
	{
		return link;
	}

	public void setLink(Nodo link) 
	{
		this.link = link;
	}
	
	
}
