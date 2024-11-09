package Paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class paginaLogin {

    private WebDriver driver;

    @FindBy(css = "input[name='customer[email]']")
    private static WebElement campoUsuario;

    @FindBy(css = "input[name='customer[password]']")
    private static WebElement campoContraseña;

    @FindBy(css = "input[value='Ingresar']")
    private WebElement botonIngresar;


    public paginaLogin(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public static void escribirUsuario(String usuario) {
        campoUsuario.sendKeys(usuario);
    }

    public static void escribirContraseña(String contraseña) {
        campoContraseña.sendKeys(contraseña);
    }

    public void hacerClicEnIngresar() {
        botonIngresar.click();
    }
}