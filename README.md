## Teste prático de automação - http://www.newtours.demoaut.com/

### Como executar o cenário ?
### src/test/java > Executar > CucumberExecute.java 

```java
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
			plugin = {
					"pretty",
					"html:src/test/resources/relatorios/cucumber-reports/",
					"json:src/test/resources/relatorios/cucumber-reports/cucumber.json",
					"junit:src/test/resources/relatorios/cucumber-reports/cucumber-reports/Cucumber.xml" }
		
			)

public class CucumberExecute {
	


}
``

### ou

### src/test/java > features > Formulario - MercuryTours.feature

```java
 #enconding: utf-8
 Feature: Mercury Tours
  Como usuáro
  Quero preencher informações
  Para continuar o processo de reserva
  
  Background: 
    Given que acesso o sistema "http://www.newtours.demoaut.com/"
    And opto por preencher usuario "mercury"
    And opto por preencher senha "mercury"
    Then opto por clicar em Sign-in

 
  Scenario: Deve preencher informações de reserva
    Given opto por acessar tela com titulo "Find a Flight: Mercury Tours: "
    And opto por selecionar type "Round Trip"
    And opto por selecionar Passenger "1 "
    And opto por selecionar Departing From "London"
    And opto por selecionar On "December" e "20"
    And opto por selecionar Arriving In "Acapulco"
    And opto por selecionar Returning "October" e "21"
    And opto por selecionar Service Class "First Class"
    And opto por selecionar Arline "Blue Skies Airlines"
    Then opto por continuar
  	And opto por selecionar partida "Blue Skies Airlines$361$271$7:10"
  	And opto por selecionar retorno "Blue Skies Airlines$631$273$14:30"
  	Then opto por continuar reserva
  	And opto por verificar se as ecolhas estao corretas
  	And opto por prencher primeiro nome "Teste"
  	And opto por preencher ultimo nome "Nextel"
  	And opto por preencher numero "118998038904"
  	Then opto por secure purchase
  	Then opto por confirmar numero de voo
  	
  	
  	
   ```
   
