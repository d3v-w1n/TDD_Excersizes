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

public class socketProject {
	
	
	
	public static void main(String[] args) {
		//Implement Socket Listener with specified socket #?
		String socketHost = args[0];
		int socketNum = Integer.parseInt(args[1]);
		try {
		Socket s1 = new Socket(socketHost, socketNum);
		PrintWriter out = new PrintWriter(s1.getOutputStream(), true);
		BufferedReader in = new BufferedReader(new InputStreamReader(s1.getInputStream()));
		BufferedReader streamIn = new BufferedReader(new InputStreamReader(System.in));
		while(streamIn.readLine() != null) {
			out.println();
			System.out.println("echo: " + in.readLine());
		}}catch(IOException exc) {
			exc.printStackTrace();
		}
		
		}
}
