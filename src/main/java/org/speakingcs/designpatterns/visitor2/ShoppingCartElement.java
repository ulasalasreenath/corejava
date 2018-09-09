package org.speakingcs.designpatterns.visitor2;

public interface ShoppingCartElement {

	public int accept(ShoppingCartVisitor visitor);
	
}
