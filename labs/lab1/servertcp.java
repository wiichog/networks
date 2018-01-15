//Juan Luis Garcia
//14189
//Redes
import java.util.*;
import java.io.*;
import java.net.*;

public class servertcp {
	final static int SERVER_PORT = 6789;
	public void serve() throws java.io.IOException{
		System.out.println("Se inicio servidor 14189");
		String clientSentence;
		String capitalizedSentence;
		ServerSocket welcomeSocket = new ServerSocket(SERVER_PORT);
		while(true) {
			Socket connectionSocket = welcomeSocket.accept();
			BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
			DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
			clientSentence = inFromClient.readLine();
			System.out.println("Se recibio: " + clientSentence);
			capitalizedSentence = clientSentence.toUpperCase() + '\n';
			outToClient.writeBytes(capitalizedSentence);
		}
	}
}
