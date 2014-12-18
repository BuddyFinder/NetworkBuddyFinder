package com.networkBuddyFinder;

import com.networkBuddyFinder.info.BuddyInfo;

public interface BuddyListener {

	public void buddyJoined(BuddyInfo buddyInfo);
	
	public void buddyLeft(BuddyInfo buddyInfo);
	
}
