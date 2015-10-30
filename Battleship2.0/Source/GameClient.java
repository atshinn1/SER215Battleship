/**
*@author Alec Shinn
*@version 1.0
*@date 10/30/15
*/

import java.net.*;
import java.io.*;
import java.util.*;


public class GameClient{
	
	//iostreams
	private DataInputStream fromServer;
	private DataOutputStream toServer;

	private Socket socket;

	//this is the InetAddress address that represents my computer
	private String localHost="10.143.233.200";

	//The port that the server is on
	private int port=8000;

	public GameClient(){

		try{
			
			//looks for the server with InetAddress and port.
			socket=new Socket(localHost,port);

			//connect iostreams
			fromServer=new DataInputStream(socket.getInputStream());
			toServer=new DataOutputStream(socket.getOutputStream());



		}catch(IOException io){
			System.err.println(io);
		}
	}

	//again this main is just for testing purposes. will be removed eventually
	public static void main(String[] args){
		new GameClient();
	}



}