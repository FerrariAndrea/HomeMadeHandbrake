
public class MyConverter {

	
	public static String convert(int KeyEvent, Boolean press) {
		int int_press=0;//flase
		if(press) {
			int_press=1;
		}
		return "["+KeyEvent+";"+int_press+"]";
		
	}
	
	public static int getKeyEvent(String str) throws Exception {
		try {
			return Integer.parseInt(str.split(";")[0].replace("[", ""));
		}catch(Exception e){
			throw new Exception("String invalid format!");
		}
			
	}
	public static Boolean isPress(String str) throws Exception {
		try {
			return 1==Integer.parseInt(str.split(";")[1].replace("[", ""));
		}catch(Exception e){
			throw new Exception("String invalid format!");
		}
			
	}
}
