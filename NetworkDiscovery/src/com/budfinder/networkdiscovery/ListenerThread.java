package com.budfinder.networkdiscovery;



import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class ListenerThread extends Thread {

	HashMap<String, String> buddies = null;
	MulticastSocket socket;

	public ListenerThread() throws IOException {
		buddies = new LinkedHashMap<String, String>();
		socket = new MulticastSocket(4434);
		InetAddress address = InetAddress.getByName("230.0.0.1");
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

			String buddyName = new String(packet.getData(), 0,
					packet.getLength());
			if (!buddies.containsKey(buddyName)) {
				buddies.put(buddyName, packet.getAddress().toString());
				printBuddies();
			}
		}
	}

	private void printBuddies() {
		System.out.println("My known buddies are:");
		for (Entry<String, String> entry : buddies.entrySet()) {
			System.out.println(entry.getKey()+":"+entry.getValue());
		}
	}

}
