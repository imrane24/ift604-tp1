import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Serveur {
	public static void main(String[] args){

		        //On se sert d'un pool de thread pour limiter le nombre de threads
		        //en mémoire
		final ExecutorService service = Executors.newFixedThreadPool(100);
		
		ServerSocket serverSocket = null;
		try {
		
			//choix du port pour socket
			serverSocket = new ServerSocket(10000);
			
			while (true) {
		
				try {
					final Socket socket = serverSocket.accept();
		                                //On traite la requète via notre executor
					service.execute(new Runnable(){
		
						@Override
						public void run() {
							//TODO
							//Reponse au client
							//traitementRequete(socket);
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
}
