
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.UnknownHostException;

import gipo.devices.MyMatrixLed;
import gipo.devices.MyMatrixLed.IMG;

public class Main {


	public static void main(String[] args){

		System.out.println("HomeMadeHandbrake Server side (Rasp) start...");
		System.out.println("Init conf");
		Configuration.getIstanza();
    	MyMatrixLed ml = new MyMatrixLed((short)1);	
		ml.open();
		ml.brightness((byte) 6);
		ButtonGipo bg = new ButtonGipo(KeyEvent.VK_SPACE,ml);
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
		try {
			ml.draw(0,MyMatrixLed.ImgFactory(IMG.NOP));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("See you later :)");
		
	}


	
	
}
