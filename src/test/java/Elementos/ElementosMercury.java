package Elementos;

import org.openqa.selenium.By;

public class ElementosMercury {

	// *************** Elemento de Login ************//

	private By txtUser = By.xpath("//input[@name='userName']"); // Campo Usuário

	private By txtSenha = By.xpath("//input[@name='password']"); // Campo senha

	private By btnLogin = By.xpath("//input[@value='Login']"); // Botão Sig-in

	public By getTxtUser() {
		return txtUser;
	}

	public By getTxtSenha() {
		return txtSenha;
	}

	public By getBtnLogin() {
		return btnLogin;
	}

	// *************** Fim Elementos de Login ************//

	// *************** Elementos tela Flight Finder ************//

	// ************** Flight Details *****************//

	private By selectPassenger = By.xpath("//select[@name='passCount']");

	public By getSelectPassenger() {
		return selectPassenger;
	}

	private By selectDeparting = By.xpath("//select[@name='fromPort']");

	public By getSelectDeparting() {
		return selectDeparting;
	}

	private By selectMesPartida = By.xpath("//select[@name='fromMonth']");

	private By selectDiaPartida = By.xpath("//select[@name='fromDay']");

	private By selectArriving = By.xpath("//select[@name='toPort']");

	private By selectMesRetorno = By.xpath("//select[@name='toMonth']");

	private By selectDiaRetorno = By.xpath("//select[@name='toDay']");

	public By getSelectMesPartida() {
		return selectMesPartida;
	}

	public By getSelectDiaPartida() {
		return selectDiaPartida;
	}

	public By getSelectArriving() {
		return selectArriving;
	}

	public By getSelectMesRetorno() {
		return selectMesRetorno;
	}

	public By getSelectDiaRetorno() {
		return selectDiaRetorno;
	}

	// *************** Preferences ****************//

	private By inputClasse = By.xpath("//input[@value='First']");

	public By getInputClasse() {
		return inputClasse;
	}

	private By selectAirline = By.xpath("//select[@name='airline']");

	public By getSelectAirline() {
		return selectAirline;
	}

	private By btnContinuar = By.xpath("//input[@name='findFlights']");

	public By getBtnContinuar() {
		return btnContinuar;
	}

	// *************** Fim Elementos tela Flight Finder ************//

	// ************* Elementos Select Flight ****************//

	private By radioPartida = By.xpath("//form[@name='results']/table//tr[5]/td/input");

	public By getRadioPartida() {
		return radioPartida;
	}

	private By lblVooPartida = By.xpath("//form[@name='results']/table//tr[5]/td//font/b");

	public By getLblVooPartida() {
		return lblVooPartida;
	}

	public void setLblVooPartida(By lblVooPartida) {
		this.lblVooPartida = lblVooPartida;
	}

	private By radioRetorno = By.xpath("//form[@name='results']/table[2]/tbody/tr[5]/td/input");

	public By getRadioRetorno() {
		return radioRetorno;
	}

	private By lblVooRetorno = By.xpath("//form[@name='results']/table[2]//tr[5]/td//font/b");

	public By getLblVooRetorno() {
		return lblVooRetorno;
	}

	public void setLblVooRetorno(By lblVooRetorno) {
		this.lblVooRetorno = lblVooRetorno;
	}

	private By btnReservaContinue = By.xpath("//input[@name='reserveFlights']");

	public By getBtnReservaContinue() {
		return btnReservaContinue;
	}

	// ************* Fim Select Flight ****************//

	// ************* Book a Flight *****************//

	private By txtFirstName = By.xpath("//input[@name='passFirst0']");

	private By txtLastName = By.xpath("//input[@name='passLast0']");

	private By txtNumber = By.xpath("//input[@name='creditnumber']");

	private By btnCompra = By.xpath("//input[@name='buyFlights']");

	public By getTxtFirstName() {
		return txtFirstName;
	}

	public By getTxtLastName() {
		return txtLastName;
	}

	public By getTxtNumber() {
		return txtNumber;
	}

	public By getBtnCompra() {
		return btnCompra;
	}

	// ************* Fim Book a Flight *****************//
	
	//************ Flight Confirmation ************/

	private By lblVooConfirmado = By.xpath("//td[@class='frame_header_info']/table/tbody/tr/td/b//b/font");
		
	public By getLblVooConfirmado() {
		return lblVooConfirmado;
	}

	
	//********** Fim Flight Confirmation ************//

}
