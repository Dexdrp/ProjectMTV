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
		System.out.println("run()");
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

				case Entity.MESSAGE:
					display("Message received from server: " +  entity.getO().toString());
					/*TeacherPanel.getInstance().getListModel().addElement(entity.getO().toString());
					TeacherPanel.getInstance().getList().setBounds(350, 50, 600, 500);
					TeacherPanel.getInstance().repaint();*/
	
				
					break;

				case Entity.LIST_UPDATE:
					display("List update received from server");
					/*TeacherPanel.getInstance().getListModel().remove((int)entity.getO());
					TeacherPanel.getInstance().repaint();*/
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

	public void sendMessage(String message){
		Entity messageEntity = new Entity(Entity.MESSAGE, message);
		try {        	
			outputStream.writeObject(messageEntity);
		} catch (IOException e1) {
			display("Can't send message to server");
		}
	}


	public void updateTeacherList(int index) {
		Entity update = new Entity(Entity.LIST_UPDATE, index);
		try {
			outputStream.writeObject(update);
		} catch (Exception e) {
			display("Can't send update to server");
		}
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
