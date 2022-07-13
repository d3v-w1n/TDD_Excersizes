import java.util.*;
import java.util.Scanner;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.Serializable;
import java.time.temporal.Temporal;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class socketServer extends Thread {

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
		}}
}