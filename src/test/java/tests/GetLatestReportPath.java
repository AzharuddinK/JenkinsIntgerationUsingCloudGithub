package tests;

import utility.FileUtility;

public class GetLatestReportPath {
	
	public static void main(String[] args) {
		System.out.println(FileUtility.getLastModifiedFileName(System.getProperty("user.dir")+"/ExtentReports/"));
	}

}
