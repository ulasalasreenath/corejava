package org.speakingcs.designpatterns.state2;

public class StateContext {

	private Statelike myState;
	
	StateContext()
	{
		setState(new StateLowerCase());
	}
	
	public void setState(Statelike state) {
		myState = state;
	}
	
	public void writeName(final String name)
	{
		myState.writeName(this, name);
	}

}
