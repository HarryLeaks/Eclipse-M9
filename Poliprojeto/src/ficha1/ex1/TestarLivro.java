package ficha1.ex1;

public class TestarLivro {
	public static void main(String[] args) {
		Livro livro = new Livro();
		
		livro.setNome("O codigo CEO");
		livro.setPreco(7.68);
		System.out.println("Livro: " + livro.getNome() + "Preco: " + livro.getPreco() + " � caro? " + livro.caro());
	
		livro.setAutor("David Rohlander");
		livro.setPaginas(240);
		System.out.println("Autor: " + livro.getAutor() + "\nn� p�ginas: " + livro.getPaginas() + "\ntem muitas p�ginas? " + livro.grande());
	}
}
