import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Main {


	public static void main(String[] args){
		
		System.out.println("HomeMadeHandbrake Client side (pc) start...");
		System.out.println("Init conf");
		Configuration.getIstanza();
		System.out.println("Waiting for server on ip: "+Configuration.getIstanza().get_serviceIp() );
		try {
			while(!sendPingRequest(Configuration.getIstanza().get_serviceIp())){			
				Thread.sleep(500);				
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.exit(-1);
		}
		System.out.println("Create socket client.");
		try {
			Client mySocket = new Client(Configuration.getIstanza().get_serviceIp(),Configuration.getIstanza().get_servicePort());
			System.out.println("Socket on port " + Configuration.getIstanza().get_servicePort() + " ready.");
			String response = "start";
			while(mySocket.isUp() && response!=null) {
				response= mySocket.read();
				if(response!=null) {
					emulate(response);
				}
			}
			System.out.println("Socket closed.");
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

	public static Boolean sendPingRequest(String ipAddress) throws UnknownHostException, IOException { 
		InetAddress geek = InetAddress.getByName(ipAddress); 
		//System.out.println("Sending Ping Request to " + ipAddress); 
		return geek.isReachable(5000);
	} 
	
	public static void emulate(String response) {
		//System.out.println(response);	
		try {
			
			Robot robot = new Robot();
			if(MyConverter.isPress(response)) {
				robot.keyPress(MyConverter.getKeyEvent(response));
			}else {
				robot.keyRelease(MyConverter.getKeyEvent(response));
			}
			

		}catch(Exception ex) {
			System.out.println("Recived cmd, but can't emulate it :(");
			ex.printStackTrace();
		}
	}
	
}
