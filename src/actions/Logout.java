package actions;

import java.sql.SQLException;
import org.openqa.selenium.By;

import core.CuatroEnUno;
import core.DAO;



public class Logout {
	
	public static void desloguear(String QueNavegador) throws SQLException, Exception {
		
		String debug = "Incertidumbre cuántica";
		String queTest = "Desloguearse";
		int resulTest=2;
		
		try{ 
			
			CuatroEnUno.driver.findElement(By.xpath("//*[@id=\"user-dropdown-toggle\"]")).click();
			CuatroEnUno.driver.findElement(By.xpath("//*[@id=\"signout-button\"]/button")).click();
			
			debug = "Test OK";
			
			CuatroEnUno.driver.quit();
			
		} catch (Exception e){
			debug = e.getMessage();
			System.out.print(debug);
		} finally {
			
			DAO.insertaTrazaTest(queTest,QueNavegador,debug,resulTest);
		
		}	
			
		
			
	}//Fin desloguear

}//Fin Logout
