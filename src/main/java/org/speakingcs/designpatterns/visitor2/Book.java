package org.speakingcs.designpatterns.visitor2;

public class Book implements ShoppingCartElement{

	private int price;
	private String isbnNumber;
	
	
	public Book(int cost, String isbn)
	{
		this.price = cost;
		this.isbnNumber = isbn;
	}
	
	public int getPrice()
	{
		return price;
	}
	
	public String getIsbnNumber()
	{
		return isbnNumber;
	}
	
	
	@Override
	public int accept(ShoppingCartVisitor visitor) {
		return visitor.visit(this);
	}

}
