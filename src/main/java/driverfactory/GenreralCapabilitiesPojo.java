package driverfactory;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GenreralCapabilitiesPojo {
	@SerializedName("platformName")
	@Expose
	private String platformName;
	@SerializedName("platformVersion")
	@Expose
	private String platformVersion;
	@SerializedName("deviceName")
	@Expose
	private String deviceName;
	@SerializedName("automationName")
	@Expose
	private String automationName;
	@SerializedName("app")
	@Expose
	private String app;
	
	@SerializedName("capabilityName")
	@Expose
	private String capabilityName;

	public String getCapabilityName() {
		return capabilityName;
	}

	public void setCapabilityName(String capabilityName) {
		this.capabilityName = capabilityName;
	}

	public String getPlatformName() {
	return platformName;
	}

	public void setPlatformName(String platformName) {
	this.platformName = platformName;
	}

	public String getPlatformVersion() {
	return platformVersion;
	}

	public void setPlatformVersion(String platformVersion) {
	this.platformVersion = platformVersion;
	}

	public String getDeviceName() {
	return deviceName;
	}

	public void setDeviceName(String deviceName) {
	this.deviceName = deviceName;
	}

	public String getAutomationName() {
	return automationName;
	}

	public void setAutomationName(String automationName) {
	this.automationName = automationName;
	}

	public String getApp() {
	return app;
	}

	public void setApp(String app) {
	this.app = app;
	}

}
