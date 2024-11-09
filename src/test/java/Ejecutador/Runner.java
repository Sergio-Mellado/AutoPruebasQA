package Ejecutador;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(features=".src/test/resources/Feature/EscenarioRegistro.feature",glue = {".src/test/java/DefinicionPasos/PasosCasamyl.java"})

public class Runner {

}