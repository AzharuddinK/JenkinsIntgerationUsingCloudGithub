package tests;

import java.io.IOException;

public class RunVBSFile {


	public static void main(String[] args) throws InterruptedException {
	   openTcode();
	   /*Thread.sleep(5000);
	   clickOnCustomerAccountNumberToOpenGoldenIdWindow();
	  Thread.sleep(5000);
	   openCustomerDetailsUsingGoldenID("0000");*/
	}
	
	public static void openTcode(){
		try {
		      Runtime.getRuntime().exec( "wscript C:\\Schneider\\ScriptingPath\\TEST2021.vbs" );
		   }
		   catch( IOException e ) {
		      System.out.println(e);
		      System.exit(0);
		   }
	}
	
	public static void clickOnCustomerAccountNumberToOpenGoldenIdWindow(){
		try {
		      Runtime.getRuntime().exec( "wscript C:/Schneider/ScriptingPath/openCustomerGoldenID.vbs" );
		   }
		   catch( IOException e ) {
		      System.out.println(e);
		      System.exit(0);
		   }
	}
	public static void openCustomerDetailsUsingGoldenID(String goldenID){
		try {
		      Runtime.getRuntime().exec( "wscript C:/Schneider/ScriptingPath/OpenCustomerDetailsUsingGoldenID.vbs" );
		   }
		   catch( IOException e ) {
		      System.out.println(e);
		      System.exit(0);
		   }	
	}
}
