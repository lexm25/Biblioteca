package clases.helpers;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

public class Chrono {
	
	//Solo usable desde la propia clase
	private static Chrono singleton = new Chrono();
	//Marcas de tiempo almacenadas
	private static Map<String, Chrono.TimeStamp> marcas = new HashMap<String, Chrono.TimeStamp>();

	private Chrono() {
		// TODO Auto-generated constructor stub
	}
	
	public static void start(String crono) {
		//Creamos la marca a null
		Chrono.TimeStamp marca;
		if(marcas.containsKey(crono))
			marca = marcas.get(crono);
		else
			marca = Chrono.singleton.new TimeStamp();
		
		
		marca.startStamp = LocalDateTime.now();
		
		marcas.put(crono, marca);
	}
	
	public static long stop(String crono) {
		
		TimeStamp marca = getStamp(crono);
		
		marca.stopStamp = LocalDateTime.now();
		
		return ChronoUnit.MILLIS.between(marca.startStamp, marca.stopStamp);
	}
	
	public static long getTimeMillis(String crono) {
		
		
		TimeStamp marca = getStamp(crono);
		
		return ChronoUnit.MILLIS.between(marca.startStamp, marca.stopStamp);
	}
	
	private static TimeStamp getStamp(String crono) {

		//Si no existe el crono lanzamos un error
		if(!marcas.containsKey(crono))
			throw new RuntimeException("No existe el cronometro especificado");
		
		return marcas.get(crono);
	}
	
	private class TimeStamp{
		
		private LocalDateTime startStamp;
		private LocalDateTime stopStamp;
		
		public TimeStamp() {
			
		}
	}

}
