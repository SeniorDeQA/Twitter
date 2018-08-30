package actions;

import java.sql.SQLException;
import org.openqa.selenium.By;

import core.CuatroEnUno;
import core.DAO;



public class BorraUltimo {
	
	public static void borrar(String QueNavegador) throws SQLException, Exception {
		
		String debug = "Incertidumbre cuántica";
		String queTest = "Borra ultimo tuit";
		int resulTest=2;
		
		try{ 
			
			//CuatroEnUno.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			//Vamos listado de tuits
			CuatroEnUno.driver.findElement(By.xpath("//*[@id=\"timeline\"]/div/div[1]/button"));
			//Entramos al último
			//CuatroEnUno.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			CuatroEnUno.driver.findElement(By.xpath("//*[@id=\"stream-item-tweet-1035137500170338304\"]/div[1]/div[2]/div[2]/p"));
			//lo borramos
			
			
			/*
			 <li class="js-actionDelete" role="presentation">
			 <button class="dropdown-link" type="button" role="menuitem">Eliminar Tweet</button>
			*/
			
			//CuatroEnUno.driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[4]/div/div/div[2]/div/div[2]/div[4]/div/div[2]/ol[1]/li/div[1]/div[2]/div[1]/div/div/div/ul/li[7]/button/text()")).click();
			//CuatroEnUno.driver.findElement(By.cssSelector(".dropdown-link")).click();
			
			
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
			
		
			
	}//Fin borrar

}//Fin BorraUltimo
