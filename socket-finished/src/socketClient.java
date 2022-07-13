//import java.util.*;
import java.util.Scanner;
//import java.io.Serializable;
//import java.time.temporal.Temporal;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
import java.io.*;
import java.net.Socket;

public class socketClient {
	
	
	public static void main(String[] args) {
		//Implement Socket Listener with specified socket #?
		String socketHost = "localhost";
		int socketNum = 25;
		try {
		Socket s1 = new Socket(socketHost, socketNum);
		PrintWriter out = new PrintWriter(s1.getOutputStream(), true);
		BufferedReader in = new BufferedReader(new InputStreamReader(s1.getInputStream()));
		BufferedReader streamIn = new BufferedReader(new InputStreamReader(System.in));
		while(streamIn.readLine() != null) {
			out.println("CONNECTION CONFIRMED");
			System.out.println("echo: " + in.readLine());
		}s1.close();
		}catch(IOException exc) {
			exc.printStackTrace();
		}

		}
}
