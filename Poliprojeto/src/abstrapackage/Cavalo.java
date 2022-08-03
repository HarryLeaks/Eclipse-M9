package abstrapackage;

public class Cavalo extends Animal{
	@Override
	public void som() {
		System.out.println("Relinchar");
	}
	
	public static void main(String[] args) {
		Animal c1 = new Cavalo();
		c1.som();
	}
}
