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
	private ObjectInputStream inFromClient;

	//output stream to the client
	private ObjectOutputStream outToClient;

	//current game object
	private Game currentGame;

	//load assets object for game constructor
	private LoadAssets gameAssets;

	//giving it an initial value for now. Same for difficulty
	private int numberOfPlayers=2,difficulty=2;

	private Location currentMove;


	public static void main(String[] args){
		new GameServer();
	}

	public GameServer(){

		try{
			//attach serversocket to a port
			sSocket=new ServerSocket(8000);

			//wait for connection
			socket1=sSocket.accept();

			System.out.println("Connection established");

			//instantiate datastreams
			outToClient=new ObjectOutputStream(socket1.getOutputStream());
			
			System.out.println("ostream good");

			inFromClient=new ObjectInputStream(socket1.getInputStream());

			System.out.println("istream good");
			//initialize loadAssets
			gameAssets=new LoadAssets();

			//initialize game object
			currentGame=new Game(numberOfPlayers,difficulty,gameAssets);
			/*currentMove=new Location();
			currentMove.setMessage("Did you get it?");*/

			while(true){
				//outToClient.writeObject(currentMove);

				currentMove=(Location)inFromClient.readObject();

				System.out.println(currentMove.x() + " " + currentMove.y());

				currentMove.setMessage("Cooridnates received");

				outToClient.writeObject(currentMove);

				System.out.println("Message sent");
				


			}



		}catch(IOException io){
			System.err.println(io);
		}
		catch(ClassNotFoundException c){
			System.err.println(c);
		}
	}
	
}