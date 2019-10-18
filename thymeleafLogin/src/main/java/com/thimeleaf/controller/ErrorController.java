package com.thimeleaf.controller;

import java.util.Map;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.apache.log4j.Logger;




@Controller
public class ErrorController {

	private static Logger logger = Logger.getLogger(ErrorController.class);
	
	/*
	//redirect originale
	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public String getGenericError() {

		return "error";
	}
	*/
	
	//recupero tutti i parametri in console
	@RequestMapping(value = "/getAllParams", method = RequestMethod.POST)
	public String getAllParams(@RequestParam Map<String,String> allParams) {
		
		System.out.println("Questi sono i parametri: " + allParams.entrySet());
		
	    return "error";
	}
		
	
	//redirect errori specifici
	@RequestMapping(value = "/error", method = RequestMethod.POST)
	public String getErrorType(@RequestParam String errorType,
							   @RequestParam String errorText) {
	
		String errorTextOriginale = errorText;
		
		System.out.println("Questo è il valore di errorType: " + errorType);
		System.out.println("Questo è il valore di errorText: " + errorTextOriginale);
		
		//cambio messaggio a seconda dell'errore
		switch(errorType) {		
		case "opensaml::SecurityPolicyException":
			
			
			errorText = "Il messaggio è firmato, ma non è stato possibile verificare la firma";
			
			//messaggio per sviluppo
			logger.debug("Errore di sicurezza: " + errorText);
			
			//messaggio per utente
			logger.error("Errore 403: Impossibile stabilire l'autenticità della richiesta di autenticazione\r\n" + "-Contattare il gestore del servizio"); // messaggio diretto all'utente
			
			return "error";
			//String divPersonalizzato = "<div th:replace='fragments/errorFragments :: SecurityPolicyException'></div>"; // Creo il div corretto per il messaggio
			
		case "opensaml::FatalProfileException":
			
			errorText = "Impossibile stabilire la sicurezza dell'asserzione ricevuta";
			
			//messaggio per sviluppo
			logger.debug("Errore letale di Profilo " + errorText);
			
			//messaggio diretto fornitore del servizio SP
			logger.error("AssertionConsumerService non correttametne valorizzato/r/n" + "-Formulare correttamente la richiesta"); 
			
			return "error";
			
			//String divPersonalizzato = "<div th:replace='fragments/errorFragments :: FatalProfileException'></div>"; 
			
		case "xmltooling::ValidationException":
			errorText = "Valore top-level dello StatusCode non valido";
		
			//messaggio per sviluppo
			logger.debug("Errore di Validazione " + errorText);
			
			//messaggio diretto fornitore del servizio SP
			logger.error("Utente privo di credenziali compatibili con il livello richiesto dal fornitore del servizio"); 
			
			return "error";
			
			//String divPersonalizzato = "<div th:replace='fragments/errorFragments :: ValidationException'></div>";
			
		default:
			//messaggio per sviluppo
			logger.debug("Errore Generico");
			
			//messaggio per utente
			logger.error("Sistema di autenticazione non disponibile/n/r" + "-Riprovare più tardi");
			
			return "error";
			
			//String divPersonalizzato = "<div th:replace='fragments/errorFragments :: erroreGenerico'></div>";
	}
		
 }
	
}
