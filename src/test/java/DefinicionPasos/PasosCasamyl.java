package DefinicionPasos;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Paginas.paginaRegistro;
import Paginas.paginaLogin;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
public class PasosCasamyl {
static WebDriver driver;
static String pathDriver="./src/test/resources/chrome/chromedriver.exe";
static String tipoDriver="webdriver.chrome.driver";
@Before
public void setUp() throws Exception {
System.setProperty(tipoDriver, pathDriver);
driver=new ChromeDriver();
driver.manage().window().maximize();
driver.manage().deleteAllCookies();
}
@After
public void tearDown() throws Exception {
if (driver != null)
driver.quit();
}
    @Given("el usuario está en la página de registro")
    public void el_usuario_esta_en_la_pagina_de_registro() {
        driver.get("https://casamyl.cl/account/register");
    }

    @When("llena el formulario con los siguientes datos")
    public void llena_el_formulario_con_los_siguientes_datos(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        paginaRegistro.escribirNombre(data.get(0).get("Nombre"));
        paginaRegistro.escribirApellido(data.get(0).get("Apellido"));
        paginaRegistro.escribirEmail(data.get(0).get("Correo electrónico"));
        paginaRegistro.escribirContraseña(data.get(0).get("Contraseña"));
    }


    @When("hace clic en el botón {string}")
    public void hace_clic_en_el_boton(String boton) {
        if (boton.equals("Crear")) {
            driver.findElement(By.cssSelector("input[value='Crear']")).click();
        }  else if (boton.equals("Ingresar")) {
            driver.findElement(By.cssSelector("input[value='Ingresar']")).click();

        }
    }


    @Then("debería ver el mensaje de éxito {string}")
    public void deberia_ver_el_mensaje_de_exito(String mensajeExito) {
        String mensaje = driver.findElement(By.xpath("//*[contains(text(), '" + mensajeExito + "')]")).getText(); //queda por xpath para ser mas específico

        Assert.assertEquals(mensajeExito, mensaje);



    }
    
   @Given("el usuario está en la página de login")
    public void el_usuario_esta_en_la_pagina_de_login() {
        driver.get("https://casamyl.cl/account/login");
    }

     @When("ingresa su usuario {string} y contraseña {string}")
     public void ingresa_su_usuario_y_contraseña(String usuario, String contraseña) {

         paginaLogin.escribirUsuario(usuario);
         paginaLogin.escribirContraseña(contraseña);
     }


    @Then("debería ser redirigido a {string}")
    public void deberia_ser_redirigido_a(String urlEsperada) {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(urlEsperada, currentUrl);
    }

    @Then("debería ver un mensaje de error que contiene {string}")
    public void deberia_ver_un_mensaje_de_error_que_contiene(String mensajeError) {
       WebElement errorMessage = driver.findElement(By.xpath("//*[contains(text(), '" + mensajeError + "')]"));

       Assert.assertTrue(errorMessage.isDisplayed());
       Assert.assertTrue(errorMessage.getText().contains(mensajeError));
    }


}