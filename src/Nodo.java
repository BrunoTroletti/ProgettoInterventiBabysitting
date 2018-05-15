import java.io.Serializable;

public class Nodo implements Serializable
{
	private Interventi info;
	private Nodo link;
	
	public Nodo(Invitato persona)
	{
		setInfo(persona);
		link=null;
	}

	public Invitato getInfo() 
	{
		return info;
	}

	public void setInfo(Invitato info) 
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
