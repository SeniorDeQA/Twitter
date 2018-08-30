package actions;

import java.sql.SQLException;
import org.openqa.selenium.By;

import core.CuatroEnUno;
import core.DAO;



public class Login {
	
	public static void loguear(String QueNavegador) throws SQLException, Exception {
		
		String debug = "Incertidumbre cuántica";
		String queTest = "Loguearse";
		int resulTest=2;
		
		try{ 
			
			CuatroEnUno.driver.manage().window().maximize();
			
			CuatroEnUno.driver.findElement(By.xpath("//*[@id=\"doc\"]/div/div[1]/div[1]/div[2]/div[2]/div/a[2]")).click();
			//problemas aleatorios en acceso
			CuatroEnUno.driver.findElement(By.xpath("//*[@id=\"page-container\"]/div/div[1]/form/fieldset/div[1]/input")).sendKeys("unbotcualquier1");
			CuatroEnUno.driver.findElement(By.xpath("//*[@id=\"page-container\"]/div/div[1]/form/fieldset/div[2]/input")).sendKeys("blabla");
			CuatroEnUno.driver.findElement(By.xpath("//*[@id=\"page-container\"]/div/div[1]/form/div[2]/button")).click();
		
			
			
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
			
		
			
	}//Fin loguear

}//Fin Login
