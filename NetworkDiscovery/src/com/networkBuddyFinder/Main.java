package com.networkBuddyFinder;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		if(args.length < 1){
			System.out.println("Wrong usage, use:\n java Main <identifier>");
		}else{
			//new ListenerThread().start();
			new BeaconThread(args[0]).start();
		}

	}

}
