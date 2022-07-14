import java.util.*;
import java.util.Scanner;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.temporal.Temporal;
import java.nio.file.Files;

public class webServerToFile extends Thread {


	//run() method call to constructor + while loop
	public void run(ServerSocket s) {
		
		try {
		Socket n = new Socket();
		while(!s.isClosed()) {
				n = s.accept(); }} catch(IOException exc) {
				exc.printStackTrace();
			}
				
				}
	
	public static void main(String[] args) throws IOException {
		
		//Implement Socket Listener with specified socket #?
		try {
		ServerSocket ss = new ServerSocket(25);
		Socket n = new Socket();
		Thread serv = new Thread();
		serv = serverHandler(ss);
		serv.start();
		System.out.println("Connection Established" + n.toString());
		n.close();
		}catch(IOException exc) {
			exc.printStackTrace();
		}
		/*using Files library to transfer information to auto-generated file w/FILEIOSTREAM
		 * try{
		 * Stream<String> webPage = Files.lines(Path.of(-webSeverStream-));
		 * 						also - 	.readAllLines(Path.of(-webSeverStream-));
		 * lines.forEach(System.out::println); -- will be revised for INPUT.OUTPUTSTREAM .TXT / .CSV FILE
		 * }
		 * 
		 * BUFFEREDREADER webPage = new BufferedReader(Path.of(-webSeverStream-));
		 * Stream<String> wPBR = webPage.lines();
		 * wPBR.forEach(System.out::println);
		 */
		}
	
	public final static Thread serverHandler(ServerSocket s) {
		try {
			newHandler(s);
			System.out.printf("%s%n", "Establishing Connection - - -");
		}catch(IOException exc) {
		exc.printStackTrace();
		}
		return serverHandler(s);
	}
	
	public static void newHandler(ServerSocket s) throws IOException {
		try {
		s.accept();
		}catch(IOException exc) {
			exc.printStackTrace();
		}
	
	
	//Get socket # to listen with socketNum()
	//Implement Socket Listener with specified socket #?
	try {
	Socket s1 = new Socket();//socketHost(), socketNum());
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
