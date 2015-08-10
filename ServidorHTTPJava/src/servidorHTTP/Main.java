package servidorHTTP;

import servidorHTTP.HTTPservidor;

public class Main {
	
	public static void main(String[] args) {	
		// TODO Auto-generated method stub
		HTTPservidor servidor = new HTTPservidor(8080);
		 servidor.iniciar();
	}

}
