package com.networkBuddyFinder;

import com.networkBuddyFinder.info.BuddyInfo;
import com.networkBuddyFinder.info.ConnectionInfo;

public class NetworkBuddyFinder {

	private ConnectionInfo connectionInfo;
	private BuddyInfo myInfo;
	private BuddyListener buddyListener;
	
	private static final String DEFAULT_MULTICAST_IP =  "230.0.0.1";
	private static final int DEFAULT_LISTENER_PORT = 4434;
	
	public NetworkBuddyFinder(ConnectionInfo connectionInfo, BuddyInfo myInfo,
			BuddyListener buddyListener) {
		super();
		this.connectionInfo = connectionInfo;
		this.myInfo = myInfo;
		this.buddyListener = buddyListener;
	}

	public NetworkBuddyFinder(BuddyInfo myInfo, BuddyListener buddyListener) {
		super();
		this.myInfo = myInfo;
		this.buddyListener = buddyListener;
		this.connectionInfo = new ConnectionInfo(DEFAULT_MULTICAST_IP, DEFAULT_LISTENER_PORT);
	}

	public NetworkBuddyFinder(BuddyListener buddyListener) {
		super();
		this.buddyListener = buddyListener;
		this.connectionInfo = new ConnectionInfo(DEFAULT_MULTICAST_IP, DEFAULT_LISTENER_PORT);
		this.myInfo = new BuddyInfo();
	}
	
	public void start(){
		
	}
	
	public void stop(){
		
	}
	
	
	
	
	
	
	
	
}
