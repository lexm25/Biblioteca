package clases;

public enum Genero {
	NOVELA,
	POESIA,
	FICCION;

	public static Genero getGenero(String genero) {
		Genero seleccionado = null;
    	
    	switch(genero.toUpperCase()) {
    		case "NOVELA":
    			seleccionado = Genero.NOVELA;
    			break;
    		case "FICCION":
    			seleccionado = Genero.FICCION;
    			break;
    		case "POESIA":
    			seleccionado = Genero.POESIA;
    			break;
    	}
    	
    	return seleccionado;
	}
}
