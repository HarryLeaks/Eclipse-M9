package ficha1.ex1;

public class Livro extends Produto{
	private String autor;
	private int paginas;
	
	public String getAutor() {
		return autor;
	}
	public int getPaginas() {
		return paginas;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}
	
	public boolean grande() {
		if(paginas > 200)
			return true;
		else
			return false;
	}
}
