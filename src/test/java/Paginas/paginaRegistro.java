package Paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class paginaRegistro {

    private WebDriver driver;

    @FindBy(id = "RegisterForm-FirstName")
    private static WebElement campoNombre;

    @FindBy(id = "RegisterForm-LastName")
    private static WebElement campoApellido;

    @FindBy(id = "RegisterForm-email")
    private static WebElement campoEmail;

    @FindBy(id = "RegisterForm-password")
    private static WebElement campoContraseña;

    @FindBy(id = "input[value='Crear']")
    private WebElement botonCrear;


    public paginaRegistro(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public static void escribirNombre(String nombre) {
        campoNombre.sendKeys(nombre);
    }

    public static void escribirApellido(String apellido) {
        campoApellido.sendKeys(apellido);
    }

    public static void escribirEmail(String email) {
        campoEmail.sendKeys(email);
    }

    public static void escribirContraseña(String contraseña) {
        campoContraseña.sendKeys(contraseña);
    }

    public void hacerClicEnCrear() {
        botonCrear.click();
    }


}