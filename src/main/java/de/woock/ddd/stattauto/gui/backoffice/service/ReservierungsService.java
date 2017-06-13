package de.woock.ddd.stattauto.gui.backoffice.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import de.woock.ddd.stattauto.gui.backoffice.entity.Mitglied;
import de.woock.ddd.stattauto.gui.backoffice.entity.Reservierung;  

@Service
public class ReservierungsService {
	
	private RestTemplate restTemplate = new RestTemplate();
	private static final String RESERVIERUNG = "http://localhost:8080/reservierung/%s";
	private static final String MITGLIED     = "http://localhost:8080/Mitglieder/%s/%s";

	public Reservierung getReservierung(String resNr) {
		String url = String.format(RESERVIERUNG, resNr);
		return restTemplate.getForObject(url, Reservierung.class); 
	}

	public Mitglied getVersicherter(String name, String vorname) {
		String url = String.format(MITGLIED, name, vorname);
		return restTemplate.getForObject(url, Mitglied.class); 
	}
}
