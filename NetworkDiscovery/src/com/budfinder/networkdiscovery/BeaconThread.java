package com.budfinder.networkdiscovery;



import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class BeaconThread extends Thread {
    protected DatagramSocket socket = null;
    String clientName = null;
    public static final long WAIT_TIME = 4000;

    public BeaconThread() throws IOException {
        this( "Beacon Client");
    }

    public BeaconThread(String name) throws IOException {
        super(name);
        this.clientName = name;
        socket = new DatagramSocket(4433);

    }

    public void run() {

        for (int i = 0; i < 10; i++) {
            byte[] buf = this.clientName.getBytes();
            InetAddress group = null;
            try {
                group = InetAddress.getByName("230.0.0.1");
            } catch (UnknownHostException e2) {
                e2.printStackTrace();
                break;
            }
            DatagramPacket packet = new DatagramPacket(buf, buf.length, group,
                    4434);
            try {
                socket.send(packet);
            } catch (IOException e1) {

                e1.printStackTrace();
                break;
            }

            try {
                sleep((long) (Math.random() * WAIT_TIME));
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }

        }
        socket.close();
    }
}
