package com.networkBuddyFinder;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import com.networkBuddyFinder.info.BuddyInfo;
import com.networkBuddyFinder.info.ConnectionInfo;

public class ListenerThread extends Thread {

	HashMap<String, String> buddies = null;
	MulticastSocket socket;
	BuddyInfo myInfo;
	BuddyListener buddyListener;

	public ListenerThread(ConnectionInfo connectionInfo, BuddyInfo myInfo,
			BuddyListener buddyListener) throws IOException {
		this.myInfo = myInfo;
		this.buddyListener = buddyListener;
		String ip = connectionInfo.getMulticastIp();
		int port = connectionInfo.getPort();
		buddies = new LinkedHashMap<String, String>();
		socket = new MulticastSocket(port);
		InetAddress address = InetAddress.getByName(ip);
		socket.joinGroup(address);
	}

	public void run() {
		while (true) {
			byte buf[] = new byte[256];
			DatagramPacket packet = new DatagramPacket(buf, buf.length);
			try {
				socket.receive(packet);
			} catch (IOException e) {

				e.printStackTrace();
				break;
			}
			String ip = packet.getAddress().toString();
			String identifier = new String(packet.getData(), 0,
					packet.getLength());
			if (!buddies.containsKey(ip)) {
				buddies.put(ip,identifier);
				BuddyInfo buddyInfo = new BuddyInfo(ip, identifier);
				buddyListener.buddyJoined(buddyInfo);
				printBuddies();
			}
		}
	}

	private void printBuddies() {
		System.out.println("My known buddies are:");
		for (Entry<String, String> entry : buddies.entrySet()) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
	}

}
