package ficha1.ex1;

public class TestarForma {
	public static void main(String[] args) {
		Forma rect = new Retangulo();
		Forma tri = new Triangulo();
		
		System.out.println("Area Retangulo: " + rect.area(10,  10));
		System.out.println("Area triangulo: " + tri.area(3.5, 9));
	}
}
