package tests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageWaitTests {

	private static WebDriver driver;

	// HomePage
	private By descricoesDosProdutos = By.cssSelector(".product-description a");

	// ProdutoPage
	private By botaoAddToCart = By.className("add-to-cart");

	// ModalProdutoPage
	private By mensagemProdutoAdicionado = By.id("myModalLabel");

	@BeforeAll
	public static void inicializar() {
		System.setProperty("webdriver.chrome.driver", 
				"C:\\webdrivers\\chromedriver\\83\\chromedriver.exe");
		driver = new ChromeDriver();	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@BeforeEach
	public void carregarPaginaInicial() {
		driver.get("https://marcelodebittencourt.com/demoprestashop/");
	}

	@AfterAll
	public static void finalizar() {
		driver.quit();
	}

	@Test
	public void testIncluirProdutoNoCarrinho_ProdutoIncluidoComSucesso() {
		driver.findElements(descricoesDosProdutos).get(0).click();

		driver.findElement(botaoAddToCart).click();

		/*
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mensagemProdutoAdicionado));
		*/
		
		FluentWait fluentWait = new FluentWait(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(1))
				.ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.visibilityOfElementLocated(mensagemProdutoAdicionado));
		
		String string_mensagemProdutoAdicionado = 
				driver.findElement(mensagemProdutoAdicionado).getText();

		System.out.println(string_mensagemProdutoAdicionado);

		assertThat(string_mensagemProdutoAdicionado
				.endsWith("Product successfully added to your shopping cart"),
				is(true));
//		assertTrue(modalProdutoPage.obterMensagemProdutoAdicionado()
//				.endsWith("Product successfully added to your shopping cart"));

		System.out.println("Teste rodou ok");
	}
}
