package org.speakingcs.designpatterns.state;

public class Ringing implements MobileState{

	@Override
	public void getState() {
		System.out.println("Mobile is in rining state");
	}

}
