
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.UnknownHostException;

public class Main {


	public static void main(String[] args){
		
		System.out.println("HomeMadeHandbrake Server side (Rasp) start...");
		System.out.println("Init conf");
		Configuration.getIstanza();
		ButtonGipo bg = new ButtonGipo(KeyEvent.VK_SPACE);
		System.out.println("Lunch server on port " +Configuration.getIstanza().get_servicePort());
		try {		
			Server server = new Server(Configuration.getIstanza().get_servicePort(),bg);
			server.Start();
			System.out.println("Socket on port " + Configuration.getIstanza().get_servicePort() + " ready.");	
			bg.doJob();			
			System.out.println("Server closed.");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(-1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(-1);
		}

		System.out.println("See you later :)");
		
	}


	
	
}
