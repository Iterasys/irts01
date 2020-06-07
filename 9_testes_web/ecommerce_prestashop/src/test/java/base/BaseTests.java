package base;

//JUnit 5
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

//JUnit 4
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.HomePage;

public class BaseTests {
	
	private static WebDriver driver;
	protected HomePage homePage;

	@BeforeAll //JUnit 5
//	@BeforeClass //JUnit 4
	public static void inicializar() {
		System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver\\83\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@BeforeEach //JUnit 5
//	@Before //JUnit 4
	public void carregarPaginaInicial() {
		driver.get("https://marcelodebittencourt.com/demoprestashop/");
		homePage = new HomePage(driver);
	}

	@AfterAll //JUnit 5
//	@AfterClass //JUnit 4
	public static void finalizar() {
		driver.quit();
	}	

}
