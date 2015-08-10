package servidorHTTP;


import java.io.DataOutputStream;
import java.io.IOException;

public class HTTPResponse {
	
	private DataOutputStream output;
	private HTTPRequest request;
	
	public HTTPResponse(DataOutputStream output){
		this.output = output;
	}
	

	public void setRequest(HTTPRequest request){
		this.request = request;
	}
	
	public void enviaResposta() throws IOException{
		String cabecalhoHTML = "<html><head><title>Página do Servidor</title></head>";
		String corpoHTML = "<body> <h1> Página Encontrada </h1> Bem vindo! <br /> Você está acessando de: ";
		if(request.getCabecalho().contains("Android"))
			corpoHTML += "<b>Um Dispositivo Android</b><br />"+request.getCabecalho()+ "</body>";
		else
			corpoHTML += "<b>Um Computador</b><br />"+request.getCabecalho()+ "</body>";
		
		output.writeBytes(construirCabecalhoHTTP(200));
		output.writeBytes(cabecalhoHTML+corpoHTML);
		output.close();
		
	}
	
	private String construirCabecalhoHTTP(int codigoRetorno) {
		String cabecalho = "HTTP/1.0 ";
		
		switch (codigoRetorno) {
		case 200:
			cabecalho += "200 OK";
			break;
		case 400:
			cabecalho += "400 Bad Request";
			break;
		case 403:
			cabecalho += "403 Forbidden";
			break;
		case 404:
			cabecalho += "404 Not Found";
			break;
		case 500:
			cabecalho += "500 Internal Server Error";
			break;
		case 501:
			cabecalho += "501 Not Implemented";
			break;
		}

		cabecalho += cabecalho + "\r\n";
		cabecalho += cabecalho + "Connection: close\r\n";
		cabecalho += cabecalho + "Server: Tutorial Servidor HTTP em Java v0\r\n";	
		cabecalho += cabecalho + "Content-Type: text/html\r\n";
		cabecalho += cabecalho + "\r\n";
		
		return cabecalho;
	}
	
	

}
