package controller;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

import controller.Entity;
import view.queue.QueueListPanel;


public class Client implements Runnable{

	private static Client instance;

	private Socket socket;
	private int id;
	private int port;
	private String host;
	private boolean running;
	private ObjectOutputStream outputStream;
	private ObjectInputStream inputStream;

	private CurrentDate d = new CurrentDate();

	private Client(String host, int port) {
		this.host = host;
		this.port = port;
	}

	@Override
	public void run() {
		try {
			
			display("Local IP = " + getClientIP());
			display("Connecting to: " + host);
			socket = new Socket(host, port);

			outputStream = new ObjectOutputStream(socket.getOutputStream());
			inputStream = new ObjectInputStream(socket.getInputStream());

			outputStream.writeObject("TV");

			running = true;

		} catch (UnknownHostException uhe) {
			display("Can't connect to the server");
		} catch (IOException ioe) {
			display("Can't create in/output stream");
		} catch (Exception e) {
			display(e.toString());
		}

		try {
			while(running) {
				Entity entity = (Entity) inputStream.readObject();

				switch(entity.getType()){

				case LIST_UPDATE:
					display("List update received from server");
					// do tv list update here
					break;
				}
			}
		} catch (IOException | ClassNotFoundException ioec) {
			display("Client disconnected");
		} catch (Exception e) {
			display("Error in reading entity");
		}

	}
	
	public String getClientIP() throws UnknownHostException{
		String ip;
		ip = Inet4Address.getLocalHost().getHostAddress();
		return ip;
	}

	public int getID(){
		return id;
	}

	public void display(String s){
		System.out.println(d.now() + " - Client - " + s);
	}

	public static Client newInstance(String host, int port){
		if(instance == null){
			instance = new Client(host, port);
		}
		return instance;
	}

	public static Client getInstance(){
		return instance;
	}

	public String ToString(){
		return host;
	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}	
}
