
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Server {

	private List<SingleSocketService> _clients;
	private  Semaphore sem;
	ServerSocket _listener ;
	public Server(int port) throws IOException {
		_clients= new ArrayList<SingleSocketService>();		
	 	 _listener = new ServerSocket(port);
	 	sem= new Semaphore(1);
        System.out.println("The capitalization server is running...");
     
	     
	}
	
	
	public void Start()  {		 
		    Thread thread = new Thread(new Runnable(){
		        public void run(){
		            System.out.println("Server accept running");
		            while(true) {
		    			try {
		    				SingleSocketService temp =new SingleSocketService(_listener.accept())
		    				sem.acquire();
		    				_clients.add(temp);
		    				sem.release();
		    			}catch(Exception ex) {
		    				ex.printStackTrace();
		    			}
		    			
		    		}
		        }
		    });
		    thread.start();
	}
	
	public void notifyAllClient(String msg) throws InterruptedException {
		sem.acquire();
		for(int x =0;x<_clients.size();x++) {
			try {
				_clients.get(x).write(msg);	
			}catch(Exception ex) {
				ex.printStackTrace();
			}				
			
		}		
		sem.release();
	}
	
	public class SingleSocketService  {

		
		private Socket socket;
		private DataInputStream _input;
		private DataOutputStream _output;
		SingleSocketService(Socket socket) throws IOException {
	        this.socket = socket;
	        _input= new DataInputStream(socket.getInputStream());
        	_output = new DataOutputStream(socket.getOutputStream());
	    }
		

		public void write(String message) throws IOException {
			
			_output.writeUTF(message);	
		}
		

	  
	}

	
	
}
