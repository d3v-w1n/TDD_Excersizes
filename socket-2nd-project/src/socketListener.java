import java.util.*;
import java.util.Scanner;
import java.io.*;
import java.net.Socket;
import java.io.Serializable;
import java.time.temporal.Temporal;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class socketListener {

	
	public static int socketNum (){
		int Num;
		String request = "Please specify a Socket Number: ";
		Scanner scan = new Scanner(request);
		Num = scan.nextInt();
		scan.close();
		return Num;
	}
		
	public static String socketHost() {
		String hostName;
		String request = "Please specify a Server/Client Host: ";
		Scanner scan = new Scanner(request);
		hostName = scan.next();
		scan.close();
		return hostName;
	}
	
	
	
	public static void main(String[] args) {
		//Get socket # to listen with socketNum()
		//Implement Socket Listener with specified socket #?
		try {
		Socket s1 = new Socket(socketHost(), socketNum());
		PrintWriter out = new PrintWriter(s1.getOutputStream(), true);
		BufferedReader in = new BufferedReader(new InputStreamReader(s1.getInputStream()));
		BufferedReader streamIn = new BufferedReader(new InputStreamReader(System.in));
		while(streamIn.readLine() != null) {
			out.println();
			System.out.println("echo: " + in.readLine());
		}}catch(IOException exc) {
			exc.printStackTrace();
		}
		
			
			try {
				//Reading Socket Input/Connection Status + Writing to File
				FileOutputStream fos = new FileOutputStream("socketTraffic.txt");
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject("socketTraffic.txt");
				oos.flush();
				}catch(IOException exc) {
					exc.printStackTrace();
				}
		}
}