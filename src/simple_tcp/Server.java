package simple_tcp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public Server() throws Exception {
		ServerSocket server_socket = new ServerSocket(2020); //Opening new socket 
		System.out.println("Port 2020 has been openned");
		Socket socket = server_socket.accept();
		System.out.println("Client "+socket.getInetAddress()+" has connected");
		
		// I/O buffers:
		BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);
		String message;
		int secret_number = (int)(Math.random()*10+1);
		do {
			out_socket.println("Guess a number from 1 to 10");
			message = in_socket.readLine();
		}while(!(Integer.parseInt(message)==secret_number));
		out_socket.println("You got it!!");
		System.out.println("Exiting the app...");
		
		socket.close();
		System.out.println("Socket is Closed!");
		
	}
	public static void main(String[] args) {
		try {
			new Server();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
