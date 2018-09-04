package org.speakingcs.designpatterns.state;

public class MobileContext implements MobileState {

	private MobileState mobileState;
	
	public MobileContext(MobileState mobileState) {
		super();
		this.mobileState = mobileState;
	}

	public void setMobileState(MobileState state) {
		this.mobileState = state;
	}

	@Override
	public void getState() {
		mobileState.getState();
	}

	public MobileState getMobileState() {
		return mobileState;
	}

}
