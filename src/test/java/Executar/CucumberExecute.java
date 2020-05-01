package Executar;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
	(
			features="src/test/java/features/Formulario - MercuryTours.feature",
			glue="steps",
			dryRun=false,
			monochrome=true,
			strict = false,
			plugin= {"pretty", "html:test-output"}
			
			)



public class CucumberExecute {
	


}
