//Juan Luis Garcia
//14189
//Redes
import java.util.InputMismatchException;
import java.net.*;
import java.io.*;
import java.util.Scanner;

public class main {
    public static void main (String [ ] args) {
	//objetos
	Scanner sn = new Scanner(System.in);
	boolean salir = false;
	int opcion;
	while(!salir) {
		System.out.println("Elija que desea iniciar");
		System.out.println("1. Servidor TCP");
		System.out.println("2. Cliente TCP");
		System.out.println("3. Servidor UDP");
		System.out.println("4. Cliente UDP");
		System.out.println("5. Salir");
		try {
			System.out.println("Elija una de las opciones por medio de su numero");
			opcion = sn.nextInt();
			switch(opcion) {
				case 1:
					servertcp server = new servertcp();
					try {
						server.serve();
					}
					catch(IOException e) {
						e.printStackTrace();
					}
					break;
				case 2:
					clienttcp client = new clienttcp();
					try {
						client.client();
					}
					catch(Exception e) {
						e.printStackTrace();
					}
					break;
				case 3:
					serverudp serverudp = new serverudp();
					try {
						serverudp.serve();
					}
					catch(Exception e) {
						e.printStackTrace();
					}
					break;
				case 4:
					clientudp clientudp = new clientudp();
					try {
						clientudp.client();
					}
					catch(Exception e) {
						e.printStackTrace();
					}
					break;
				case 5:
					salir = true;
					break;
				default:
					System.out.println("Solo números entre 1 y 4");
			}
		}
		catch (InputMismatchException e) {
	                System.out.println("Debes insertar un número");
	                sn.next();
            	}
	}
    }

}
