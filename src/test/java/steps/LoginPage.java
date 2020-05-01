package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Elementos.ElementosMercury {

	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	@FindBy(name = "userName")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(className = "btn-info")

	WebElement button;

	public void set_username(String usuario) {
		username.clear();
		username.sendKeys(usuario);
	}

	public void set_password(String senha) {
		password.clear();
		password.sendKeys(senha);
	}

	public void click_button() {
		driver.findElement(getBtnLogin()).click();
	}

}
