package abstrapackage;

public class ACao extends AAnimal{
	public String som() {
		return ("Ladrar");
	}
	
	public static void main(String[] args) {
		AAnimal c1 = new ACao();
		System.out.println(c1.som());
	}
}
