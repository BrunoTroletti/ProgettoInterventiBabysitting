import java.io.*;
import java.time.LocalDateTime;


public class ConsoleInput 
{
	//ATTRIBUTI
	private InputStreamReader input;
	private BufferedReader reader;
	
	
	public ConsoleInput()
	{
		reader=new BufferedReader(new InputStreamReader(System.in));
	}
	
	
	public int readInt() throws NumberFormatException, IOException
	{
		return (Integer.parseInt(reader.readLine()));
	}
	
	public LocalDateTime readLocaldateTime()  throws NumberFormatException, IOException
	{
		return(LocalDateTime.of(null, null));
	}
	
	
	
	public double readDouble() throws NumberFormatException, IOException
	{
		return (Double.parseDouble(reader.readLine()));
	}
	
	
	public long readLong() throws NumberFormatException, IOException
	{
		return Long.parseLong(reader.readLine());
	}

	
	public boolean readBoolean() throws IOException,NumberFormatException
	{
		return Boolean.parseBoolean(reader.readLine());
	}
	
	
	public String readString() throws IOException, NumberFormatException
	{
		String s=reader.readLine();
		if (s.compareTo("")==0)
			throw new NumberFormatException();
		return (s);
	}

}