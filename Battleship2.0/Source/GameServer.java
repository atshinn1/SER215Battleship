/**
*@author Alec Shinn
*@version 1.0
*@date10/30/15
*/
/*At this point all I have is a Server that waits for a connection. The main is just for easier testing it will be removed later*/
import java.net.*;
import java.io.*;
import java.util.*;

public class GameServer{
	//creates the server socket
	private ServerSocket sSocket;
	
	//creates the socket that will communicate with the client 
	private Socket socket1;
	
	//inputstream from the client
	private DataInputStream inFromClient;

	//output stream to the client
	private DataOutputStream outToClient;

	//current game object
	private Game currentGame;

	//load assets object for game constructor
	private LoadAssets gameAssets;

	//giving it an initial value for now. Same for difficulty
	private int numberOfPlayers=2,difficulty=2;



	public static void main(String[] args){
		new GameServer();
	}

	public GameServer(){

		try{
			//attach serversocket to a port
			sSocket=new ServerSocket(8000);

			//wait for connection
			socket1=sSocket.accept();

			//instantiate datastreams
			inFromClient=new DataInputStream(socket1.getInputStream());
			outToClient=new DataOutputStream(socket1.getOutputStream());

			//initialize loadAssets
			gameAssets=new LoadAssets();

			//initialize game object
			currentGame=new Game(numberOfPlayers,difficulty,gameAssets);

			while(true){
				outToClient.writeChars(currentGame.getPlayer("Player 1").toString() );
			}



		}catch(IOException io){
			System.err.println(io);
		}
	}
	
}