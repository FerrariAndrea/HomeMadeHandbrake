
import java.net.Socket;
import java.net.UnknownHostException;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Client {

	private Socket _socket;
	private DataInputStream _input;
	private DataOutputStream _output;
	public Client(String ip, int port) throws UnknownHostException, IOException {
		_socket = new Socket(ip, port);
		_input = new DataInputStream(_socket.getInputStream());
		_output= new DataOutputStream(_socket.getOutputStream());		
	}
	
	public Boolean isUp() {
		return _socket.isConnected() && !_socket.isClosed();
	}
	
	
	public void write(String message) throws IOException {
		
		_output.writeUTF(message);	
	}
	
	public String read() {	
		try {
			return _input.readUTF();
		}catch(Exception ex){ //if you want mask error better...
			return null;
		}
	
	}
	
	
	
	
}
