package com.networkBuddyFinder.info;


public class BuddyInfo {
	String ip;
	String identifier;
	public BuddyInfo() {
		
	}

	public BuddyInfo(String ip, String identifier) {
		super();
		this.ip = ip;
		this.identifier = identifier;
		
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	
	
}
