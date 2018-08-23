
public class A {
	
	private int a, b;
	private String[] strs = null;
	
	A()
	{
		
	}

	A(A a)
	{
		this.a = a.getA();
		this.b = a.getB();
		
		int i = 0;
		
		strs = new String[a.getStrs().length];
		for(int j = 0; i < a.getStrs().length; j++)
		{
			strs[i++] = a.getStrs()[j];
		}
		
	}
	
	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public String[] getStrs() {
		return strs;
	}

	public void setStrs(String[] strs) {
		this.strs = strs;
	}
	
}
