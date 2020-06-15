package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

	private WebDriver driver;

	private By totalTaxIncTotal = By.cssSelector("div.cart-total span.value");

	private By nomeCliente = By.cssSelector("div.address");

	private By botaoContinueAddress = By.name("confirm-addresses");

	private By shippingValor = By.cssSelector("span.carrier-price");
	
	private By botaoContinueShipping = By.name("confirmDeliveryOption");
	
	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
	}

	public String obter_totalTaxIncTotal() {
		return driver.findElement(totalTaxIncTotal).getText();
	}

	public String obter_nomeCliente() {
		return driver.findElement(nomeCliente).getText();
	}

	public void clicarBotaoContinueAddress() {
		driver.findElement(botaoContinueAddress).click();
	}

	public String obter_shippingValor() {
		return driver.findElement(shippingValor).getText();
	}
	
	public void clicarBotaoContinueShipping() {
		driver.findElement(botaoContinueShipping).click();
	}

}
