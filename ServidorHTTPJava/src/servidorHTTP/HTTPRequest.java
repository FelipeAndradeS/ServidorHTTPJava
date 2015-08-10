package servidorHTTP;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;

public class HTTPRequest {

	private String cabecalho;
	
	public HTTPRequest()
	{
		cabecalho = "";
	}
	
	public void httpHandler(BufferedReader input, DataOutputStream output) throws IOException
	{
		while(input.ready())
		{
			cabecalho += input.readLine()+"</br>";
		}
	}
	
	public String getCabecalho()
	{
		return this.cabecalho;
	}
}
