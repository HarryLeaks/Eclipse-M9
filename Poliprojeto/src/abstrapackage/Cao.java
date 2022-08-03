package abstrapackage;

public class Cao extends Animal{
	@Override
	public void som() {
		System.out.println("Ladrar");
	}
	
	public static void main(String[] args) {
		Animal c1 = new Cao();
		c1.som();
	}
}
