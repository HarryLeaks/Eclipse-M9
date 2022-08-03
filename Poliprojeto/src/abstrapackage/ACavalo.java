package abstrapackage;

public class ACavalo extends AAnimal{
	@Override
	public String som() {
		return ("Relinchar");
	}
	
	public static void main(String[] args) {
		AAnimal c1 = new ACavalo();
		System.out.println(c1.som());
	}
}
