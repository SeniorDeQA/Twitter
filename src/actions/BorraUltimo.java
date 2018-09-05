package actions;

import java.sql.SQLException;
import org.openqa.selenium.By;

import core.CuatroEnUno;
import core.DAO;



public class BorraUltimo {
	
	public static void borrar(String QueNavegador, int CuantosBorrados) throws SQLException, Exception {
		
		String debug = "Incertidumbre cuántica";
		String queTest = "Borra "+CuantosBorrados+" tuit";
		int resulTest=2;
		
		try{ 
			
			for (int i=1; i <= CuantosBorrados; i++) {
				
			//CuatroEnUno.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			//click flecha
			CuatroEnUno.driver.findElement(By.xpath("//*[@id=\"stream-item-tweet-1037236240930811904\"]/div[1]/div[2]/div[1]/div/div/button/div/span[1]")).click();
			//CuatroEnUno.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			//click eliminar
			CuatroEnUno.driver.findElement(By.xpath("//*[@id=\"stream-item-tweet-1037236240930811904\"]/div[1]/div[2]/div[1]/div/div/div/ul/li[6]/button")).click();
			//click confirmar modal
			CuatroEnUno.driver.findElement(By.xpath("/html/body/div[33]/div/div[2]/div[4]/button[2]")).click();
			
			System.out.print("Borro un tuit");
			}
			
			debug = "Test OK";
			
			
			
		} catch (Exception e){
			debug = e.getMessage();
			System.out.print(debug);
		} finally {
			
			DAO.insertaTrazaTest(queTest,QueNavegador,debug,resulTest);
			
		}
			
		
			
	}//Fin borrar

}//Fin BorraUltimo
