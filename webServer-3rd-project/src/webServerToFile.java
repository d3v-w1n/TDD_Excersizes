import java.util.*;
//import java.util.stream.Stream;
import java.io.*;
import java.net.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDate;
import java.time.temporal.Temporal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Pattern;
import java.nio.file.InvalidPathException;

public class webServerToFile extends Thread implements Serializable{


	//run() method call to constructor + while loop
	public static void run(ServerSocket s) {
		
		try {
		Socket n = new Socket();
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(n.getInputStream()));
		while(in.readLine() == null) {
				n = s.accept(); System.out.println("Connection Established Bug III" + n.toString());
				}} catch(IOException exc) {
				exc.printStackTrace();
			}
				
	}
	
	public static void main(String[] args) throws IOException {
		
		
		try {
		ServerSocket ss = new ServerSocket(8080);
		Socket n = new Socket();
		Thread serv = new webServerToFile();
		serv = serverHandler(ss);
		System.out.println("Connection Closed " + n.toString());
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
			String pathTree = Pattern.compile(s.getInetAddress().getHostAddress()).toString();
			System.out.printf("%s%n", "Connection Path Tree - - - " + pathTree);
			}catch(IOException exc) {
		exc.printStackTrace();
		}
		System.out.printf("%s%n", "Bug Tester II");
		return null;
	}
	
	public static void newHandler(ServerSocket s) throws IOException {
		try {
		System.out.printf("%s%n", "Bug Tester");
		Socket newSocket = new Socket();
		while(newSocket.getInetAddress() == null) {
			newSocket = s.accept(); System.out.println("Connection Established " + newSocket.toString());
			readOutServer(newSocket);
			}
		}catch(IOException exc) {
			exc.printStackTrace();
		}
	}
	
public static void readOutServer(Socket s1) {	
	try {
	String pathDir = Pattern.compile(s1.getInetAddress().getHostAddress()).toString();
	System.out.printf("%s%S%n", "Bug Tester IV ", pathDir);
	String PathTree = new URL(pathDir).toString(); 
	System.out.printf("%s%S%n", "Bug Tester V ", PathTree);
	String fn = new File(pathDir).getName();
	System.out.printf("%s%s%n", "Bug Tester VI ", fn);
	String filename = PathTree.concat(LocalDate.now().toString().concat(".txt"));
	System.out.printf("%s%S%n", "Bug Tester VII ", filename);
	File directory = new File(PathTree);
	//PrintWriter out = new PrintWriter(s1.getOutputStream(), true);
	if (!directory.exists()) directory.mkdirs();
	Files.createDirectories(Paths.get(filename)).toFile(); //.toFile();
	BufferedReader in = new BufferedReader(new InputStreamReader(s1.getInputStream()));
	BufferedReader streamIn = new BufferedReader(new InputStreamReader(System.in));
	FileOutputStream fos = new FileOutputStream(PathTree + filename);
	ObjectOutputStream oos = new ObjectOutputStream(fos);
	if(in != null) {
		String autogentext = "New File Created From Simple Server Connection";
		Files.writeString(Paths.get(filename), autogentext);
		//oos.writeFields();
		}
		oos.flush();
		oos.close();
		s1.close();
		/*
	while(streamIn.readLine() != null) {
		out.println();
		System.out.println("echo: " + in.readLine());
	}try{
				 Stream<String> webPage = Files.readAllLines(Path.of(Stream.generate(s)).forEach(oos.writeObject("socketTraffic.txt")));
				 }finally {
					 s.close();
				 }
				 public static Path createFileWithDir(String directory, String filename) {
        File dir = new File(directory);
        if (!dir.exists()) dir.mkdirs();
        return Paths.get(directory + File.separatorChar + filename);
    }
			if(in != null) {
			oos.writeObject(out);
			}
			oos.flush();
			oos.close();
			s1.close();
			}catch(IOException exc) {
				exc.printStackTrace();
			}
	*/}catch(IOException exc) {
		exc.printStackTrace();
	}

	}
}

