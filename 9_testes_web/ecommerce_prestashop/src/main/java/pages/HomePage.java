package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	private WebDriver driver;

	List<WebElement> listaProdutos = new ArrayList<WebElement>();	

	private By textoProdutosNoCarrinho = By.className("cart-products-count");

	private By produtos = By.className("product-description");

	private By descricoesDosProdutos = By.cssSelector(".product-description a");

	private By precoDosProdutos = By.className("price");

	private By botaoSignIn = By.cssSelector("#_desktop_user_info span.hidden-sm-down");

	private By usuarioLogado = By.cssSelector("#_desktop_user_info span.hidden-sm-down");
	
	private By botaoSignOut = By.cssSelector("a.logout ");	

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public int contarProdutos() {
		carregarListaProdutos();
		return listaProdutos.size();
	}

	private void carregarListaProdutos() {
		listaProdutos = driver.findElements(produtos);
	}

	public int obterQuantidadeProdutosNoCarrinho() {

		String quantidadeProdutosNoCarrinho = driver.findElement(textoProdutosNoCarrinho).getText();

		quantidadeProdutosNoCarrinho = quantidadeProdutosNoCarrinho.replace("(", "");
		quantidadeProdutosNoCarrinho = quantidadeProdutosNoCarrinho.replace(")", "");

		int qtdProdutosNoCarrinho = Integer.parseInt(quantidadeProdutosNoCarrinho);

		return qtdProdutosNoCarrinho;
	}

	public String obterNomeProduto(int indice) {
		return driver.findElements(descricoesDosProdutos).get(indice).getText();
	}

	public String obterPrecoProduto(int indice) {
		return driver.findElements(precoDosProdutos).get(indice).getText();
	}

	public ProdutoPage clicarProduto(int indice) {
		driver.findElements(descricoesDosProdutos).get(indice).click();
		return new ProdutoPage(driver);
	}

	public LoginPage clicarBotaoSignIn() {
		driver.findElement(botaoSignIn).click();
		return new LoginPage(driver);
	}

	public boolean estaLogado(String texto) {
		return texto.contentEquals(driver.findElement(usuarioLogado).getText());
	}
	
	public void clicarBotaoSignOut() {
		driver.findElement(botaoSignOut).click();
	}

	public void carregarPaginaInicial() {
		driver.get("https://marcelodebittencourt.com/demoprestashop/");		
	}

	public String obterTituloPagina() {
		return driver.getTitle();
	}

	public boolean estaLogado() {
		return !"Sign in".contentEquals(driver.findElement(usuarioLogado).getText());		
	}

}