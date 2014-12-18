package com.networkBuddyFinder.info;

public class ConnectionInfo {

	String multicastIp;
	
	int port;

	public String getMulticastIp() {
		return multicastIp;
	}

	public void setMulticastIp(String multicastIp) {
		this.multicastIp = multicastIp;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public ConnectionInfo(String multicastIp, int port) {
		super();
		this.multicastIp = multicastIp;
		this.port = port;
	}

	public ConnectionInfo(int port) {
		super();
		this.port = port;
	}

	public ConnectionInfo(String multicastIp) {
		super();
		this.multicastIp = multicastIp;
	}
	
	
	
	
}
