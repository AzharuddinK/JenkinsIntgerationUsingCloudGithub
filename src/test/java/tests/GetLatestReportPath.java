package tests;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import utility.FileUtility;
import utility.JSONUtils;

public class GetLatestReportPath {
	static Map<String,String> data_for_Json = new HashMap<>();
	public static void main(String[] args) {
		File file = FileUtility.getLastModified(System.getProperty("user.dir")+"/ExtentReports/");
		data_for_Json.put("ReportName", file.getName());
		JSONUtils.writeObjects2JsonFile(data_for_Json, System.getProperty("user.dir")+"/ExtentReports/TestReport.json");
	}
}
