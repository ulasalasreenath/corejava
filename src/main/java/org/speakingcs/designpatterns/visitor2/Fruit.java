package org.speakingcs.designpatterns.visitor2;

public class Fruit implements ShoppingCartElement{

	private int pricePerKg;
	private int weight;
	private String name;
	
	public Fruit(int priceKg, int wt, String nm)
	{
		this.pricePerKg = priceKg;
		this.weight = wt;
		this.name = nm;
	}
	
	public int getPricePerKg()
	{
		return pricePerKg;
	}
	
	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPricePerKg(int pricePerKg) {
		this.pricePerKg = pricePerKg;
	}

	@Override
	public int accept(ShoppingCartVisitor visitor) {
		return visitor.visit(this);
	}

}
