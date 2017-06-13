package de.woock.ddd.stattauto.gui.backoffice.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString 
public class Mitglied {
	
	public Long         mitgliedsNr;
	public String       name;
	public String       vorname;
	public Date         geburtsdatum;
	public Adresse      adresse;
	public List<Reservierung> reservierungen = new ArrayList<>();
	
	public Mitglied() {
	}
	
	public Mitglied(long id) {
		this.mitgliedsNr = id;
	}
	
	public Mitglied(Long mitgliedsNr, String name, String vorname, Date geburtsdatum, String strasse, String ort) {
		this.mitgliedsNr = mitgliedsNr;
		this.name = name;
		this.vorname = vorname;
		this.geburtsdatum = geburtsdatum;
		this.adresse = new Adresse(strasse, ort);
	}
	
	public void addRezept(Reservierung reservierung) {
		reservierungen.add(reservierung);
	}
}
