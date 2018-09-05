package actions;

import java.sql.Timestamp;
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
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			CuatroEnUno.driver.findElement(By.xpath("//*[@id=\"global-new-tweet-button\"]")).click();
			CuatroEnUno.driver.findElement(By.xpath("//*[@id=\"Tweetstorm-tweet-box-0\"]/div[2]/div[1]/div[2]/div[2]/div[2]/div[1]")).sendKeys("Esto es un tuitazo: "+QueNavegador+" a las "+timestamp);
			CuatroEnUno.driver.findElement(By.xpath("//*[@id=\"Tweetstorm-tweet-box-0\"]/div[2]/div[2]/div[2]/span/button[2]/span")).click();

			debug = "Test OK";
			
			
		} catch (Exception e){
			debug = e.getMessage();
			System.out.print(debug);
		} finally {
			
			DAO.insertaTrazaTest(queTest,QueNavegador,debug,resulTest);
			
		}
			
		
			
	}//Fin ponerTuit

}//Fin PonUnTuit
