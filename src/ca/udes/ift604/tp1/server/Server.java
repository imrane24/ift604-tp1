package ca.udes.ift604.tp1.server;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Server {
	public static void main(String[] args){

		final ExecutorService service = Executors.newFixedThreadPool(100);
		
		ServerSocket serverSocket = null;
		try {
		
			//choix du port pour socket
			serverSocket = new ServerSocket(6666);
			
			while (true) {
		
				try {
					final Socket socket = serverSocket.accept();
					System.out.println("client connecte");
					service.execute(new Runnable(){
		
						@Override
						public void run() {
							//TODO
							//Reponse au client
							traitementRequete(socket);
							//fin de la connexion
							try {
								socket.close();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
						}
					});
				} 
				catch (IOException e) {
			              e.printStackTrace();
				}
			}
		} 
		catch (IOException e) {
		     e.printStackTrace();
		} 
		finally {
			try {
			     serverSocket.close();
			} 
			catch (IOException e) {
			     e.printStackTrace();
			}
		}
	}
	
	public static void traitementRequete(Socket socket){
		
	}
}
