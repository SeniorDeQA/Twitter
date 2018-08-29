package selenium;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import selenium.PonUnTuit;


public class CuatroEnUno {
	
	static final String RUTA_SELENIUM = "C://Users//dortiz//workspace//selenium_3.4.0";
	static WebDriver driver; 
	static DesiredCapabilities caps;
	
	
	private static void Pruebas(String QueNavegador) throws Exception, SQLException {
		//Baterías de pruebas, abstraida de navegador
		
		try {
			PonUnTuit.tuitear(QueNavegador);
		} catch (SQLException e) {
			System.out.println("-- Excepción al presistir resultado del test --");
		} catch (Exception e) {
			System.out.println("-- Excepción. Fijo que ha sido por no poder localizar un elemento --");
		}
		
		
		
		
		//driver.quit();
		System.out.println("FIN PRUEBAS en "+QueNavegador);
	}
	
	
	
	private static void Lanzador(int Case) throws Exception{
		//Lanzamos los navegadores, y pasamos a la prueba
		
		String baseURL = "https://twitter.com/";	
		String QueNavegador;
		
		switch (Case) {
	     case (1)://Edge
	    	caps = DesiredCapabilities.edge();
	     	QueNavegador = "Edge";
	    	System.setProperty("webdriver.edge.driver", RUTA_SELENIUM+"//edgedriver.exe");			
	    	//TODO sintaxis edge capabilities
	    	/*caps.setCapability(EdgeDriver.NATIVE_EVENTS, true);
	    	caps.setCapability(EdgeDriver.ENABLE_PERSISTENT_HOVERING, false);
			caps.setCapability(EdgeDriver.REQUIRE_WINDOW_FOCUS, false);
			caps.setCapability(EdgeDriver.EDGE_ENSURE_CLEAN_SESSION, true);
			caps.setCapability(EdgeDriver.IGNORE_ZOOM_SETTING, true);
			caps.setCapability(EdgeDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		 	*/driver = new EdgeDriver(caps);
		 	driver.get(baseURL);
		 	Pruebas(QueNavegador);
	 		break; 
	     case (2)://IE
	    	caps = DesiredCapabilities.internetExplorer(); 
	    	QueNavegador = "IE";
	 		System.setProperty("webdriver.ie.driver", RUTA_SELENIUM+"//iedriver.exe");			
			caps.setCapability(InternetExplorerDriver.NATIVE_EVENTS, true);
			caps.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, false);
			caps.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, false);
			caps.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
			caps.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
			caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			driver =new InternetExplorerDriver(caps);
		    driver.get(baseURL);
		 	Pruebas(QueNavegador);
			break;
	     case (3)://Chrome
	    	caps = DesiredCapabilities.chrome(); 
	    	QueNavegador = "Chrome"; 
	 		System.setProperty("webdriver.chrome.driver", RUTA_SELENIUM+"//chromedriver.exe");
	 		caps.setCapability("NATIVE_EVENTS", true);
	 		caps.setCapability("ENABLE_PERSISTENT_HOVERING", false);
	 		caps.setCapability("REQUIRE_WINDOW_FOCUS", false);
	 		caps.setCapability("CHROME_ENSURE_CLEAN_SESSION", true);
	 		caps.setCapability("IGNORE_ZOOM_SETTING", true);
	 		caps.setCapability("INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS", true);
			driver = new ChromeDriver(caps) ;		
		    driver.get(baseURL);
		 	Pruebas(QueNavegador);
		 	break; 
	     case (4)://Firefox
	    	caps = DesiredCapabilities.firefox(); 
	     	QueNavegador = "Firefox";
	     	System.setProperty("webdriver.gecko.driver", RUTA_SELENIUM+"//geckodriver.exe");
	 		caps.setCapability("NATIVE_EVENTS", true);
	 		caps.setCapability("ENABLE_PERSISTENT_HOVERING", false);
	 		caps.setCapability("REQUIRE_WINDOW_FOCUS", false);
	 		caps.setCapability("FIREFOX_ENSURE_CLEAN_SESSION", true);
	 		caps.setCapability("IGNORE_ZOOM_SETTING", true);
	 		caps.setCapability("INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS", true); 
			driver =new FirefoxDriver(caps);
			driver.get(baseURL);
			Pruebas(QueNavegador);
		 	break; 		    		
		}	
				 
	}//FIN LANZADOR
	
	
	
	
	public static void main(String[] args) throws Exception {
		
		//Solo iteramos para trabajar con 4 navegadores
		//Pasamos a Lanzador
		for (int i=4; i<=4; i++){
			
			switch (i) {
		     case (1)://Edge
		 	    Lanzador(1);
		 		break; 
		     case (2)://IE
		    	Lanzador(2);
				break;
		     case (3)://Chrome
		    	Lanzador(3);
				break; 
		     case (4)://Firefox
		    	Lanzador(4);
		    	break; 		    		
			}	
			
		}//FIN FOR
		
	}//FIN MAIN

	

}
