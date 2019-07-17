
public class Configuration {

	private static  Configuration instanza = null;  
	
	public static Configuration getIstanza() {
		if(instanza==null) {
			instanza= new Configuration();
		}
		return instanza;		
	}
	
	private Configuration() {
		//in future need to do--> reed from a .conf file 
		
		
	}
	
	private int _servicePort =9999;
	public int get_servicePort() {
		return _servicePort;
	}

	public void set_servicePort(int _servicePort) {
		this._servicePort = _servicePort;
	}

	public String get_serviceIp() {
		return _serviceIp;
	}

	public void set_serviceIp(String _serviceIp) {
		this._serviceIp = _serviceIp;
	}

	private String _serviceIp ="11.0.0.18";

	
	
}
