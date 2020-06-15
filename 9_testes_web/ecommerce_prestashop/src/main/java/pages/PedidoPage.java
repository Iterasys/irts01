package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PedidoPage {

	private WebDriver driver;

	private By textoPedidoConfirmado = By.cssSelector("#content-hook_order_confirmation h3");

	public PedidoPage(WebDriver driver) {
		this.driver = driver;
	}

	public String obter_textoPedidoConfirmado() {
		return driver.findElement(textoPedidoConfirmado).getText();
	}
	
}
