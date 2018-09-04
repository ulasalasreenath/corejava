package org.speakingcs.designpatterns.visitor;

import java.util.ArrayList;

public class ShoppingCart {

	private ArrayList<Visitable> items = new ArrayList<Visitable>();
	private PostageVisitor visitor = new PostageVisitor();

	public void add(Visitable item) {
		items.add(item);
		item.accept(visitor);
	}

	public double getTotalPostage() {
		return visitor.getTotalPostage();
	}
	
	public static void main(String[] args)
	{
		ShoppingCart cart = new ShoppingCart();
		cart.add(new Book(500, 6));
		cart.add(new Book(200, 3));
		cart.add(new Book(300, 4));
		cart.add(new Book(400, 5));
		cart.add(new Book(100, 6));
		
		System.out.println(cart.getTotalPostage());
	}

}
