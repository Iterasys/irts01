package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;

	private By email = By.name("email");

	private By password = By.name("password");

	private By botaoSignIn = By.id("submit-login");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void preencherEmail(String texto) {
		driver.findElement(email).sendKeys(texto);
	}

	public void preencherPassword(String texto) {
		driver.findElement(password).sendKeys(texto);
	}

	public void clicarBotaoSignIn() {
		driver.findElement(botaoSignIn).click();
	}

}