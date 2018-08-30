package actions;

import java.sql.SQLException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;

import core.CuatroEnUno;
import core.DAO;



public class PonUnTuit {
	
	public static void tuitear(String QueNavegador) throws SQLException, Exception {
		
		String debug = "Incertidumbre cu�ntica";
		String queTest = "Pon un tuit";
		int resulTest=2;
		
		try{ 
			
			CuatroEnUno.driver.manage().window().maximize();
			
			CuatroEnUno.driver.findElement(By.xpath("//*[@id=\"doc\"]/div/div[1]/div[1]/div[2]/div[2]/div/a[2]")).click();
			//problemas aleatorios en acceso
			CuatroEnUno.driver.findElement(By.xpath("//*[@id=\"page-container\"]/div/div[1]/form/fieldset/div[1]/input")).sendKeys("unbotcualquier1");
			CuatroEnUno.driver.findElement(By.xpath("//*[@id=\"page-container\"]/div/div[1]/form/fieldset/div[2]/input")).sendKeys("blabla");
			CuatroEnUno.driver.findElement(By.xpath("//*[@id=\"page-container\"]/div/div[1]/form/div[2]/button")).click();
			
			//Tuiteamos
			CuatroEnUno.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS); //�Espera alta hace petar?
			CuatroEnUno.driver.findElement(By.xpath("//*[@id=\"global-new-tweet-button\"]/span")).click();
			CuatroEnUno.driver.findElement(By.xpath("//*[@id=\"Tweetstorm-tweet-box-0\"]/div[2]/div[1]/div[2]/div[2]/div[2]/div[1]")).sendKeys("Esto es una prueba");
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
