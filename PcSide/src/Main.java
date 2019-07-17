import java.awt.Robot;
import java.awt.event.KeyEvent;

public class Main {


		static void main(String[] args){
		
				try {
					Robot robot = new Robot();
					robot.keyPress(KeyEvent.VK_SPACE);
					robot.keyRelease(KeyEvent.VK_SPACE);
					
				}catch(Exception ex) {
					
				}
			
		}
		

}
