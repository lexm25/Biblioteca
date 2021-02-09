package clases;

public class Libro {
	
	private String titulo;
	private String isbn;
	private Genero genero;
	private String autor;
	private Integer paginas;
	
	public Libro() {
	}
	
	public Libro(String titulo, String isbn, Genero genero, String autor, Integer paginas) {
		super();
		this.titulo = titulo;
		this.isbn = isbn;
		this.genero = genero;
		this.autor = autor;
		this.paginas = paginas;
	}

	/**
	 * @return titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * @param modificar el titulo
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * @return isbn
	 */
	public String getIsbn() {
		return isbn;
	}

	/**
	 * @param modificar el isbn 
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	/**
	 * @return genero
	 */
	public Genero getGenero() {
		return genero;
	}

	/**
	 * @param modificar el genero
	 */
	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	/**
	 * @return autor
	 */
	public String getAutor() {
		return autor;
	}

	/**
	 * @param modificar el autor
	 */
	public void setAutor(String autor) {
		this.autor = autor;
	}

	/**
	 * @return paginas
	 */
	public Integer getPaginas() {
		return paginas;
	}

	/**
	 * @param modificar el paginas
	 */
	public void setPaginas(Integer paginas) {
		this.paginas = paginas;
	}

	@Override
	public String toString() {
		return "Titulo: " + titulo + " ISBN:" + isbn + " Genero:" 
				+ genero + " Autor:" + autor + " Paginas:" + paginas;
	}
	@Override
	public boolean equals(Object o){
    	Libro l = (Libro)o;
		boolean a = false;
    	if(this == o) {
    		a = true;
    	}else {
    		if(this.isbn.equalsIgnoreCase(l.isbn)) {
    			a = true;
    		}
    	}
    	return a;
    }
	
	
}