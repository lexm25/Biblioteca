package clases;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    
    public static void main (String [] args) {
        ArrayList<Libro> catalogo = new ArrayList<Libro>();     
        while (true) {
            int opcion = menu();
            switch (opcion) {
            case 1:
                alta(catalogo);
                break;
            case 2:
                listaDeLibros(catalogo);
                break;
            case 3:
                bajaDeLibros(catalogo);
                break;
            case 4:
                busquedaDeLibros(catalogo);
                break;
            case 5:
                ordenarLibros(catalogo);
                break;
            case 6:
                salvarFichero(catalogo);
                break;
            case 7:
                cargarFichero(catalogo);
                break;
            case 8:
                limpiarCatalogo(catalogo);
                break;
            }
        }
    }
    
    private static int menu() {
        int opcion=0;
        
        do {
            System.out.println("Opciones:");
            System.out.println("1. Alta de Libro");
            System.out.println("2. Lista de Libros");
            System.out.println("3. Baja de Libros");
            System.out.println("4. Búsqueda de Libros");
            System.out.println("5. Ordenacion de Libros");
            System.out.println("6. Salvar Fichero");
            System.out.println("7. Cargar Fichero");
            System.out.println("8. Limpiar catalogo");
            System.out.println("Introduce la opcion:");
        
            opcion = leerOpcion(8);
            
        }while(opcion <=0);
        
        return opcion;
    }
    
    private static int leerOpcion(int max) {
        int opcion = -1;
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        try {
            opcion = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("La opcion no es correcta");
            if(opcion > max) {
                opcion = -1;
            }
        }        
        return opcion;
    }
    
    private static String leerCadena() {
        String opcion = null;
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        try {
            opcion = sc.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("La opcion no es correcta");
            
            }
        return opcion;
        }
    
    private static Libro procesaEntrada(String entrada) {
        Libro libro = null;
        
        String [] datos = entrada.split(":");
        try {
        String titulo = datos[0];
        String isbn = datos[1];
        Genero genero = Genero.getGenero(datos[2]);
        String autor = datos[3];
        Integer paginas = Integer.parseInt(datos[4]);
        
        libro = new Libro(titulo,isbn,genero,autor,paginas);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("El formato no es correcto");
        }
        return libro;
    }
    
    private static void alta(ArrayList<Libro> catalogo) {
        //Leer de la entradacatalogo
        String datosLibro = obtenerDatosLibro();
        //titulo:isbn:genero:autor:paginas
        //Procesar la entrada
        Libro libro = procesaEntrada(datosLibro);
        //Crear el libro con los datos de la entrada
        catalogo.add(libro);
        //Meter el libro en el catalogo
    }
    
    private static String obtenerDatosLibro() {
        String datos=null;
        
        boolean validado=false;
        while(!validado) {
            System.out.println("Introduce los datos de un libro.");
            System.out.println("Usa el formato \"titulo:isbn:genero:autor:paginas\"");
            try {
                datos = leerCadena();
                if(true)//Supongo de momento que valida siempre
                    validado=true;
            }catch (InputMismatchException e) {
                System.out.println("Datos de entrada no validos");
            }
        }
        
        return datos;
    }
    //Don Quijote:46N5fdB45Ajya4:Ficcion:Miguel de Cervantes:523
    //Platero y yo:64gr98f6kj423j4:Novela:Miguel de Cervantes:256
    //La Celestina:88f6dg4h9w47:Novela:Fernando de Rojas:365
    
    private static void listaDeLibros(ArrayList<Libro> catalogo){
        for (int i = 0; i < catalogo.size(); i++) {
             Libro libro = catalogo.get(i);
             System.out.print((i+1)+".");
             System.out.println(libro);
              System.out.println("---------------------------------------------------------");
            }
        if(catalogo.size()==0) {
            System.out.println("El catalogo esta vacio");
        }
    }
        
    private static void bajaDeLibros(ArrayList<Libro> catalogo) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        int seleccion = 0;
       
        do {
            System.out.println("Introduzca la posicion del libro que quiere borrar");
            seleccion = sc.nextInt();
            if(seleccion>catalogo.size()) {
            System.out.println("Posicion incorrecta, introduce una posicion valida");
            }
        }while(seleccion>catalogo.size());
        catalogo.remove(seleccion);
    }
    
    private static void busquedaDeLibros(ArrayList<Libro> catalogo) {
        String isbn = "";
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);    
        System.out.println("Introduzca el isbn del libro a buscar");
        isbn = sc.next();
        
        Libro l = new Libro();
        l.setIsbn(isbn);
        
        int posicion = 0;
        posicion = catalogo.indexOf(l);
        if( posicion< 0){
            System.out.println("El libro no se encuentra en nuestro catalogo");
        }
        else {
            System.out.println(catalogo.get(posicion));
        }
    }
    
    private static void ordenarLibros(ArrayList<Libro> catalogo) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        do {
        System.out.println("Elige como quieres ordenar el catalogo:\n"
                + "1.Titulo(alfabeticamente)\n2.Numero de paginas");
        opcion = sc.nextInt();
        if(opcion == 1) {
            Collections.sort(catalogo);
        }
        else {
            Libro libro = new Libro();
            Collections.sort(catalogo, libro);        
        }
        
        }while(opcion<=2 && 1<=opcion);
    }
    
    private static void salvarFichero(ArrayList<Libro> catalogo) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        String respuesta = "";
        
        System.out.println("¿Como se llama el fichero a guardar?");
        respuesta = sc.next();
        
        try {
              FileWriter escribeFichero = new FileWriter(respuesta);
              for(Libro l : catalogo) {
                  escribeFichero.write(l.toStringFile());
              }
              escribeFichero.close();
            } catch (IOException e) {
              System.out.println("Se ha producido un error, vuelva a intentarlo");
              e.printStackTrace();
            }
    }
    
    private static void cargarFichero(ArrayList<Libro> catalogo) {
        Libro libro = null;
        
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        String respuesta = "";
        System.out.println("Como se llama el fichero que quieres cargar");
        respuesta = sc.next();
              try {
                  File myObj = new File(respuesta);
                  Scanner myReader = new Scanner(myObj);
                  while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    
                    String [] datos = data.split(",");
                    
                    String titulo = datos[0];
                    String isbn = datos[1];
                    Genero genero = Genero.getGenero(datos[2]);
                    String autor = datos[3];
                    Integer paginas = Integer.parseInt(datos[4]);
                    
                    libro = new Libro(titulo,isbn,genero,autor,paginas);
                    catalogo.add(libro);
                  }
                  myReader.close();
              } catch (FileNotFoundException e) {
                  System.out.println("No se ha encontrado el fichero");
                  e.printStackTrace();
                }
    }
    
    private static void limpiarCatalogo(ArrayList<Libro> catalogo) {
        catalogo.clear();
        }
}