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
			//TODO igual un setter en el DAO permitiria limpiar esto apra no copypastearlo siempre
			DAO.defineConnection("jdbc:mysql://localhost:3306/","root","");
			if (debug == "Test OK") {
				resulTest = 1;
						} else {
							resulTest = 0;
						}
			DAO.insertaTrazaTest(queTest,QueNavegador,debug,resulTest);
			//DAO.resultadosPorNavegador(QueNavegador);
			DAO.closeConnection();
		}
			
		
			
	}//Fin desloguear

}//Fin Logout
