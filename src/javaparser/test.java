package javaparser;

import java.net.*;
import java.util.Scanner;
import java.io.*;

// Client class that sends a message to the server and receives an object back.
// The object will contain the number of characters and digits in the message.
public class test {

	public void run() throws IOException {
		Socket sock = null;
		ObjectInputStream objectFromServer = null;
		Scanner scan = new Scanner(System.in);
		String message = "";

		try {
			sock = new Socket("127.0.0.1", 6100);
			System.out.println("Connected to port " + sock.getPort());
			PrintWriter toServer = new PrintWriter(sock.getOutputStream(), true);
			System.out.println("Enter a message");
			message = scan.nextLine();
			while (message.isEmpty()) {
				System.out.println("You must enter a message, try again.");
				message = scan.nextLine();
			}
			toServer.println(message);

			objectFromServer = new ObjectInputStream(sock.getInputStream());

			
			
			//Displaying the character and di

		} catch (IOException ioe) {
			System.err.println("Server unavailable");
		} finally {
			sock.close();
		}
	}

	public static void main(String[] args) throws IOException {
		test client = new test();
		client.run();
	}
}
