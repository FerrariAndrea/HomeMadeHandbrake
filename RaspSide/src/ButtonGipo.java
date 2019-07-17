import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Observable;

public class ButtonGipo extends Observable{

		private static String exe_c_name = "./gipoController";
		protected BufferedReader _reader;
		protected int _capture;
		protected int _keyEvent;
	
		
		public ButtonGipo(int keyEvent){
			this._keyEvent = keyEvent;
		}
		public void doJob() {
			doJob(false);
		}
		  
	  
		public void doJob(boolean debug)  {
			try{
				System.out.println("STARTING button hendler");
				Process p = Runtime.getRuntime().exec(exe_c_name);
		 		_reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
		 		while(true){
		 			_capture= Integer.parseInt(_reader.readLine());
		 			setChanged();
		 	        notifyObservers(getActualState());
		 			if(debug) {
		 				if(_capture==0) {
				 			System.out.println("data = RELEASED");
		 				}else {
		 					System.out.println("data = PRESSED");
		 				}
		 			}
	 	 		}
	 		}catch(Exception e){
	 			System.out.println(e.getMessage());
			}
	 	}
			
		public String getActualState() {
			return MyConverter.convert(_keyEvent, _capture==1);
		}
	
		public static void main(String[] args) throws Exception {
	 		new ButtonGipo(0).doJob(true);
		}	
		
		
}
