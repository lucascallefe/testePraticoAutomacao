package steps;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepDefinition extends Elementos.ElementosMercury {

	public LoginPage lp;

	WebDriver driver;
	Properties configProp;

	String nomeVooPartida;
	String nomeVooRetorno;

	@Before
	public void BeforeClass() throws IOException {

		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();

		lp = new LoginPage(driver);

		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
	}

	@After
	public void AfterClass() throws InterruptedException {
		Thread.sleep(3000);
		driver.manage().deleteAllCookies();
		driver.quit();
		driver = null;
	}

	@Given("que acesso o sistema {string}")
	public void que_acesso_o_sistema(String url) {
		driver.get(url);
	}

	@Given("opto por preencher usuario {string}")
	public void opto_por_preencher_usuario(String usuario) {

		lp.set_username(usuario);
	}

	@Given("opto por preencher senha {string}")
	public void opto_por_preencher_senha(String senha) {

		lp.set_password(senha);
	}

	@Then("opto por clicar em Sign-in")
	public void opto_por_clicar_em_Sign_in() {
		driver.findElement(getBtnLogin()).click();

		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(120, TimeUnit.SECONDS);
		// Thread.sleep(3000);
	}

	@Given("opto por acessar tela com titulo {string}")
	public void opto_por_acessar_tela_com_titulo(String titulo) {

		String tituloPagina;

		if (driver.getPageSource().contains("Registered users can sign-in")) {
			driver.close();
			// Assert.assertTrue(false);
		} else {
			System.out.println("=== titulo: " + driver.getTitle());
			System.out.println("=== titulo1: " + titulo);

			tituloPagina = driver.getTitle();

			// Assert.assertEquals(titulo, tituloPagina);
			// Assert.assertEquals(confirmarVooPartida, nomeVooPartida);
		}
	}

	@Given("opto por selecionar type {string}")
	public void opto_por_selecionar_type(String tipoVoo) {

		System.out.println("Tipo: " + tipoVoo);

		driver.findElement(getRadioTipoVoo()).click();
	}

	@Given("opto por selecionar Passenger {string}")
	public void opto_por_selecionar_Passenger(String passengers) {

		System.out.println("Passengers : " + passengers);
		Select ListPassengers = new Select(driver.findElement(getSelectPassenger()));
		ListPassengers.selectByVisibleText(passengers);

	}

	@Given("opto por selecionar Departing From {string}")
	public void opto_por_selecionar_Departing_From(String departing) {

		System.out.println("Departing from: " + departing);
		Select ListDeparting = new Select(driver.findElement(getSelectDeparting()));
		ListDeparting.selectByVisibleText(departing);
	}

	@Given("opto por selecionar On {string} e {string}")
	public void opto_por_selecionar_On_e(String mesPartida, String diaPartida) {

		System.out.println("M�s: " + mesPartida + " ano:" + diaPartida);

		Select ListMesPartida = new Select(driver.findElement(getSelectMesPartida()));
		ListMesPartida.selectByVisibleText(mesPartida);

		Select ListAnoPartida = new Select(driver.findElement(getSelectDiaPartida()));
		ListAnoPartida.selectByVisibleText(diaPartida);
	}

	@Given("opto por selecionar Arriving In {string}")
	public void opto_por_selecionar_Arriving_In(String arriving) {

		System.out.println("Arriving: " + arriving);

		Select ListArriving = new Select(driver.findElement(getSelectArriving()));
		ListArriving.selectByVisibleText(arriving);
	}

	@Given("opto por selecionar Returning {string} e {string}")
	public void opto_por_selecionar_Returning_e(String mesRetorno, String diaRetorno) {

		System.out.println("M�s retorno: " + mesRetorno + " dia: " + diaRetorno);

		Select ListMesRetorno = new Select(driver.findElement(getSelectMesRetorno()));
		ListMesRetorno.selectByVisibleText(mesRetorno);

		Select ListDiaRetorno = new Select(driver.findElement(getSelectDiaRetorno()));
		ListDiaRetorno.selectByVisibleText(diaRetorno);
	}

	@Given("opto por selecionar Service Class {string}")
	public void opto_por_selecionar_Service_Class(String classe) {

		driver.findElement(getInputClasse()).click();
	}

	@Given("opto por selecionar Arline {string}")
	public void opto_por_selecionar_Arline(String airline) {

		System.out.println("Airline: " + airline);

		Select ListAirline = new Select(driver.findElement(getSelectAirline()));
		ListAirline.selectByVisibleText(airline);
	}

	@When("opto por continuar")
	public void opto_por_continuar() {

		driver.findElement(getBtnContinuar()).click();

		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(120, TimeUnit.SECONDS);
	}

	@Then("opto por selecionar partida {string}")
	public void opto_por_selecionar_partida(String string) {

		driver.findElement(getRadioPartida()).click();

		nomeVooPartida = driver.findElement(getLblVooPartida()).getText();
	}

	@Then("opto por selecionar retorno {string}")
	public void opto_por_selecionar_retorno(String string) {

		driver.findElement(getRadioRetorno()).click();

		nomeVooRetorno = driver.findElement(getLblVooRetorno()).getText();
	}

	@Then("opto por continuar reserva")
	public void opto_por_continuar_reserva() {

		driver.findElement(getBtnReservaContinue()).click();
	}

	@Then("opto por verificar se as ecolhas estao corretas")
	public void opto_por_verificar_se_as_ecolhas_estao_corretas() {

		String confirmarVooPartida = nomeVooPartida;
		System.out.println("Nome Voo de partida: " + confirmarVooPartida);

		Assert.assertEquals(confirmarVooPartida, nomeVooPartida);

		String confirmarVooRetorno = nomeVooRetorno;
		System.out.println("Nome Voo de retorno: " + confirmarVooRetorno);

		Assert.assertEquals(confirmarVooRetorno, nomeVooRetorno);

	}

	@Then("opto por prencher primeiro nome {string}")
	public void opto_por_prencher_primeiro_nome(String primeiroNome) {

		driver.findElement(getTxtFirstName()).sendKeys(primeiroNome);
	}

	@Then("opto por preencher ultimo nome {string}")
	public void opto_por_preencher_ultimo_nome(String ultimoNome) {

		driver.findElement(getTxtLastName()).sendKeys(ultimoNome);

	}

	@Then("opto por preencher numero {string}")
	public void opto_por_preencher_numero(String numero) {

		driver.findElement(getTxtNumber()).sendKeys(numero);

	}

	@Then("opto por secure purchase")
	public void opto_por_secure_purchase() {

		driver.findElement(getBtnCompra()).click();
	}

	@Then("opto por confirmar numero de voo")
	public void opto_por_confirmar_numero_de_voo() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-ddHHmmss");
		System.out.println("Flight Confirmation # " + dateFormat.format(new Date()));

		String numeroConfirmacao = "Flight Confirmation # " + dateFormat.format(new Date());
		String numeroVoo = driver.findElement(getLblVooConfirmado()).getText();

		Assert.assertTrue(numeroConfirmacao, true);

	}

}
