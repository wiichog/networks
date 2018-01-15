//Juan Luis Garcia
//14189
//Redes
import java.io.*;
import java.net.*;
import java.util.*;

public class clienttcp{
	public void client() throws Exception {
		String sentence;
		String modifiedSentence;
		BufferedReader inFromUser =  new BufferedReader(new InputStreamReader(System.in));
		Socket clientSocket = new Socket("localhost", 6789);
		DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		sentence = inFromUser.readLine();
		outToServer.writeBytes(sentence + '\n');
		modifiedSentence = inFromServer.readLine();
		System.out.println("From Server: " + modifiedSentence);
		clientSocket.close();
	}
}
