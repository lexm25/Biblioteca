package clases.helpers;

import java.util.Random;

public class Aleatorios {
	
	private static Random r = new Random();

	public Aleatorios() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Construye cadenas aleatorias de tamaño variable
	 * @param minlen
	 * @param maxlen
	 * @return
	 */
	public static String cadenaAleatoria(int minlen, int maxlen) {
		StringBuilder cad = new StringBuilder();
		
		int len = numeroAleatorio(minlen, maxlen);
		
		for(int i=0;i<len;i++) {
			String car = String.valueOf((char)(r.nextInt('z'-'a'+1)+'a'));
			if(r.nextBoolean())
				car.toUpperCase();
			
			cad.append(car);
		}
		
		return cad.toString();
	}
	
	public static int numeroAleatorio(int min, int max) {
		return r.nextInt((max-min)+1)+min;
	}

}
