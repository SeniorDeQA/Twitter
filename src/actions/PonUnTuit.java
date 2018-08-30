package actions;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;
import java.sql.SQLException;
import org.openqa.selenium.By;

import core.CuatroEnUno;
import core.DAO;



public class PonUnTuit {
	
	public static void tuitear(String QueNavegador) throws SQLException, Exception {
		
		String debug = "Incertidumbre cuántica";
		String queTest = "Pon un tuit";
		int resulTest=2;
		
		try{ 
			
			CuatroEnUno.driver.manage().window().maximize();
			
			//Tuiteamos
			CuatroEnUno.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS); //¿Espera alta hace petar?
			CuatroEnUno.driver.findElement(By.xpath("//*[@id="global-new-tweet-button"]")).click();
			
			//SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
	
			//Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			//System.out.println (timestamp);
			CuatroEnUno.driver.findElement(By.xpath("//*[@id=\"Tweetstorm-tweet-box-0\"]/div[2]/div[1]/div[2]/div[2]/div[2]/div[1]")).sendKeys("Esto es un tuitazo: ");
			CuatroEnUno.driver.findElement(By.xpath("//*[@id=\"Tweetstorm-tweet-box-0\"]/div[2]/div[2]/div[2]/span/button[2]/span")).click();


			debug = "Test OK";
			
			
			
		} catch (Exception e){
			debug = e.getMessage();
			System.out.print(debug);
		} finally {
			DAO.defineConnection("jdbc:mysql://localhost:3306/","root","");
			if (debug == "Test OK") {
				resulTest = 1;
						} else {
							resulTest = 0;
						}
			DAO.insertaTrazaTest(queTest,QueNavegador,debug,resulTest);
			
			DAO.closeConnection();
		}
			
		
			
	}//Fin ponerTuit

}//Fin PonUnTuit
