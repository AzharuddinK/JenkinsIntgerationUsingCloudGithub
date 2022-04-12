package actions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class KeyboardActions {
	public static Robot rt=null;
	public static void pressTab() throws AWTException, InterruptedException{
		rt= new Robot();
	    rt.keyPress(KeyEvent.VK_TAB);
	    rt.keyRelease(KeyEvent.VK_TAB);
	    Thread.sleep(5000);
	}
	public static void pressEnter() throws AWTException, InterruptedException {
		// TODO Auto-generated method stub
		rt= new Robot();
	    rt.keyPress(KeyEvent.VK_ENTER);
	    rt.keyRelease(KeyEvent.VK_ENTER);
	    Thread.sleep(5000);
	}
	
	public static void pressLeftArrow() throws AWTException, InterruptedException {
		// TODO Auto-generated method stub
		rt= new Robot();
	    rt.keyPress(KeyEvent.VK_LEFT);
	    rt.keyRelease(KeyEvent.VK_LEFT);
	    Thread.sleep(200);
	}
	
	public static void enterFileName() throws AWTException, InterruptedException{
		//String folderLocation = System.getProperty("user.dir") + "/Downloads/";
		String text ="sample.xlsx";
		StringSelection stringSelection = new StringSelection(text);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, stringSelection);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		Thread.sleep(5000);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(5000);
	}
	
	public static void enterFolderPath() throws AWTException, InterruptedException{
		String folderLocation = System.getProperty("user.dir") + "/Downloads/";
		StringSelection stringSelection = new StringSelection(folderLocation);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, stringSelection);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		Thread.sleep(5000);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(5000);
	}
	public static void controlSave() throws AWTException, InterruptedException {
		// TODO Auto-generated method stub
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_S);
		Thread.sleep(5000);
		robot.keyRelease(KeyEvent.VK_S);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(5000);
	}
	public static void pressRightArrow() throws AWTException, InterruptedException {
		// TODO Auto-generated method stub
		rt= new Robot();
	    rt.keyPress(KeyEvent.VK_RIGHT);
	    rt.keyRelease(KeyEvent.VK_RIGHT);
	    Thread.sleep(200);
	}
	
	
	
	public static void pressShiftTAB() throws AWTException{
		rt.keyPress(KeyEvent.VK_SHIFT);
        rt.keyPress(KeyEvent.VK_TAB);
        rt.keyRelease(KeyEvent.VK_TAB);
        rt.keyPress(KeyEvent.VK_SHIFT);
	}
	
	public static void pressDownArrow() throws AWTException, InterruptedException{
		rt= new Robot();
	    rt.keyPress(KeyEvent.VK_DOWN);
	    rt.keyRelease(KeyEvent.VK_DOWN);
	    Thread.sleep(200);
	}
	
	public static void pressUpArrow() throws AWTException, InterruptedException{
		rt= new Robot();
	    rt.keyPress(KeyEvent.VK_UP);
	    rt.keyRelease(KeyEvent.VK_UP);
	    Thread.sleep(200);
	}
	
	
	public static void pressShiftTabMultipleTimes(int count , int delay) throws AWTException{
		rt= new Robot();
		for(int i=0;i<count;i++){
			pressShiftTAB();
			rt.delay(2000);
		}
	}

	public static void pressBackSpace() throws AWTException, InterruptedException {
		// TODO Auto-generated method stub
		rt= new Robot();
	    rt.keyPress(KeyEvent.VK_BACK_SPACE);
	    rt.keyRelease(KeyEvent.VK_BACK_SPACE);
	    Thread.sleep(5000);
	}
	public static void releaseAllKey() throws AWTException, InterruptedException {
		// TODO Auto-generated method stub
		rt= new Robot();
	    rt.keyRelease(KeyEvent.VK_CONTROL);
	    Thread.sleep(5000);
	    
	    rt.keyRelease(KeyEvent.VK_SHIFT);
	    Thread.sleep(5000);
	    
	    rt.keyRelease(KeyEvent.VK_TAB);
	    Thread.sleep(5000);
	}

}
