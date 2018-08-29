package actions;

import java.sql.SQLException;
import java.util.concurrent.TimeUnit;
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

			CuatroEnUno.driver.findElement(By.xpath("//*[@id='doc']/div[1]/div/div[1]/div[2]/a[3]")).click();
			CuatroEnUno.driver.findElement(By.xpath("//*[@id='login-dialog-dialog']/div[2]/div[2]/div[2]/form/div[1]/input")).sendKeys("unbotcualquier1");
			CuatroEnUno.driver.findElement(By.xpath("//*[@id='login-dialog-dialog']/div[2]/div[2]/div[2]/form/div[2]/input")).sendKeys("blabla");
			CuatroEnUno.driver.findElement(By.xpath("html/body/div[22]/div[2]/div[2]/div[2]/div[2]/form/input[1]")).click();
			
			CuatroEnUno.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
			CuatroEnUno.driver.findElement(By.id("global-new-tweet-button")).click();
			CuatroEnUno.driver.findElement(By.xpath("html/body/div[10]/div[2]/div[2]/div[4]/form/div[2]/div[2]/div[2]/div[2]/div[1]")).sendKeys("Esto es una prueba");
			CuatroEnUno.driver.findElement(By.xpath("html/body/div[10]/div[2]/div[2]/div[4]/form/div[3]/div[2]/button")).click();
		
			//modalposttuiteo - se evita dejando un tuit
			//CuatroEnUno.driver.findElement(By.xpath("html/body/div[3]/div/div/a")).click();
		
			//borrar tuit
			CuatroEnUno.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			CuatroEnUno.driver.findElement(By.cssSelector(".ProfileTweet-actionButton.u-textUserColorHover.dropdown-toggle.js-dropdown-toggle"));
			CuatroEnUno.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
			/*
			 <li class="js-actionDelete" role="presentation">
			 <button class="dropdown-link" type="button" role="menuitem">Eliminar Tweet</button>
			*/
			
			CuatroEnUno.driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[4]/div/div/div[2]/div/div[2]/div[4]/div/div[2]/ol[1]/li/div[1]/div[2]/div[1]/div/div/div/ul/li[7]/button/text()")).click();
			//CuatroEnUno.driver.findElement(By.cssSelector(".dropdown-link")).click();
		
			//logout
			
			/*
			<li id="signout-button" class="js-signout-button" data-nav="logout">
			<button class="dropdown-link" type="button">Cerrar sesión</button>
			<form id="signout-form" class="t1-form dropdown-link-form signout-form" action="/logout" method="POST">
			<input class="authenticity_token" value="adea0e20a5d43b45625e4975e27ccf8894414d1a" name="authenticity_token" type="hidden"/>
			<input class="js-reliability-event" name="reliability_event" type="hidden"/>
			<input name="scribe_log" type="hidden"/>
			</form>
			*/
			
			CuatroEnUno.driver.findElement(By.xpath("html/body/div[2]/div[1]/div[2]/div/div/div[3]/ul/li[1]/a")).click();
			CuatroEnUno.driver.findElement(By.xpath("html/body/div[2]/div[1]/div[2]/div/div/div[3]/ul/li[1]/div/ul/li[12]/button")).click();
		
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
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
