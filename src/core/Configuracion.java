package core;

import java.io.*;
import java.util.*;


public class Configuracion {
	
	
	static final String RUTA_PROPERTIES="C://Users//dortiz//workspace//Twitter//Twitter//config.properties";
	

	//Prueba de que engancha
	//public static void main(String[] args) {
	//	getConfig("BD.user");
	//}
	
	
    static public String getConfig(String clave) {
    	
		Properties prop = new Properties();
		InputStream ficheroConfig = null;
		String valor = "";
		
		try {
			ficheroConfig = new FileInputStream(RUTA_PROPERTIES);
			//TODO el segundo nivel
			prop.load(ficheroConfig);
			valor = prop.getProperty(clave);
			
			//TODO aquí se podría comprobar que existe esa clave
			//Nos estamos creyendo que nos piden una clave buena
			
		} catch(IOException e) {
			System.out.println(e.toString());
			System.out.println("La ruta del properties está mal");
		}
		
		System.out.println(valor);
		return valor;

    }			
		
		
			
}//Fin clase Configuracion










/*FORMA 1 de hacer getProperty a una clave, (nombre o curso, p.ej)
	
public static void main(String[] args) throws IOException {
	try {
        String path = "C:/Users/dortiz/workspace/Ejercicios/ejemplo.properties";
        Properties prop = new Properties();
        FileInputStream fs = new FileInputStream(path);
        prop.load(fs);
        System.out.println(prop.getProperty("name"));
        System.out.println(prop.getProperty("course"));
	} catch (Exception e) {
		e.printStackTrace();
		System.out.println("Algo ha fallado con el fichero. Debe existir y ser un properties");
		//System.out.close();
	}
}//Fin main que usa un printstacktrace para sacar la exception


FORMA 2 de hacer getProperty a otras claves + forma de recorrerlas todas 

public static void main(String[] args) throws IOException{
	Properties prop = new Properties();
	InputStream is = null;
	
	try {
		is = new FileInputStream("C://Users//dortiz//workspace//Twitter//Twitter//config.properties");
		prop.load(is);
	} catch(IOException e) {
		System.out.println(e.toString());
	}

	// Acceder a las propiedades por su nombre
	//System.out.println("Propiedades por nombre:");
	//System.out.println("-----------------------");
	//System.out.println(prop.getProperty("Tuit.contenido"));
	//System.out.println(prop.getProperty("Bot.clave"));
	//System.out.println(prop.getProperty("BD.cadena"));
	
	// Recorrer todas sin conocer los nombres de las propiedades
	//System.out.println("Recorrer todas las propiedades:");
	//System.out.println("-------------------------------");

	//for (Enumeration e = prop.keys(); e.hasMoreElements() ; ) {
		// Obtenemos el objeto
	//	Object obj = e.nextElement();
	//	System.out.println(obj + ": " + prop.getProperty(obj.toString()));
	//}
	
}//Fin Main, usa un .toString para printear la excepción. Aquí vemos lectura por clave 
 //y una iteración por el fichero con sintaxis mas elaborada

*/
	





