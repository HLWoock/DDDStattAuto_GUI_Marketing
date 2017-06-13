package de.woock.ddd.stattauto.gui.backoffice.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Adresse {
	
	private String strasse;
	private String Ort;
	private Land   land;
	
	public enum Land {Deutschland, Östereich, Schweiz};

	public Adresse() {
		// TODO Auto-generated constructor stub
	}
	
	public Adresse(String strasse, String ort, Land land) {
		this.strasse = strasse;
		this.Ort     = ort;
		this.land    = land;
	}

	public Adresse(String strasse2, String ort2) {
		// TODO Auto-generated constructor stub
	}
}
