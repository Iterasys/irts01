package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src\\test\\resources\\features\\comprar_produto.feature",
		glue     = "steps",
		tags     = "@fluxopadrao",
		plugin   = "pretty",
		monochrome = true
		)

public class Runner {

}
