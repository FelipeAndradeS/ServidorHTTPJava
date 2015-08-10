package servidorHTTP;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class HTTPservidor {

	private int porta;

	public HTTPservidor() {
		this.porta = 80;
	}

	public HTTPservidor(int porta) {
		this.porta = porta;
	}

	public void setPorta(int porta) {
		this.porta = porta;
	}
	
	public void iniciar()
	{
		ServerSocket socketServidor = null;
		System.out.println("Iniciando Servidor...");
	
		try
		{
			System.out.println("Tentando alocar a porta…");

			socketServidor = new ServerSocket(porta);	
		}
		catch (IOException e)
		{
			System.out.println("Erro Fatal: "+ e.getMessage());
		}
		
		catch (Exception e)
		{
			System.out.println("Erro Fatal: "+ e.getMessage());
		}
		
		System.out.println("Servidor OK!");
		
		
		while (true)
		{

			System.out.println("Servidor Aguardando…");
			Socket socket = null;

		       try
		       {

		         socket = socketServidor.accept();
		         InetAddress infoCliente = socket.getInetAddress();
		         System.out.println("Cliente: " + infoCliente.getHostName() + " conectou ao servidor!");
		         BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));        
		         int linhaRequisicao = 0;
		
		         
					DataOutputStream output = new DataOutputStream(socket.getOutputStream());
					HTTPRequest requisicaoCliente = new HTTPRequest();
					requisicaoCliente.httpHandler(input, output);
					HTTPResponse resposta = new HTTPResponse(output);
					resposta.setRequest(requisicaoCliente);
					resposta.enviaResposta();
					System.out.println(requisicaoCliente.getCabecalho());
					
					socket.close();
		         while (input.ready()) {
        

		        	 System.out.println(linhaRequisicao + " "+ input.readLine());          

		        	 linhaRequisicao++;

		        	 }

		        	 socket.close();

		        	 } catch (IOException e) {

		        	 System.out.println("Erro de conexão:  "+ e.getMessage());

		        	 }
	}
	}
	}
