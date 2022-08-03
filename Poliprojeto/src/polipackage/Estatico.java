package polipackage;

public class Estatico {
	public int som(int x, int y) {
		return x + y;
	}
	
	public int som(int x, int y, int z) {
		return x + y + z;
	}
	
	public int som(double x, int y) {
		return (int)x + y;
	}
	
	public int som(int x, double y) {
		return x + (int)y;
	}

	public static void main(String[] args) {
		Estatico exemplo = new Estatico();
		
		System.out.println(exemplo.som(3, 2));
		System.out.println(exemplo.som(3, 2, 4));
		System.out.println(exemplo.som(3.5, 2));
		System.out.println(exemplo.som(3, 2.3));
	}
}
