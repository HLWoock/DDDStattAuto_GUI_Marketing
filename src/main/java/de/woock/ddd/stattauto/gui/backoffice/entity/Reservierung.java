package de.woock.ddd.stattauto.gui.backoffice.entity;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Reservierung {
	
	private Long   id;
	private String versNr;
	private String zahlungsStatus;
	private String kassenNr;
	private Status status;
	private Date   begin;
	
	public enum Status {Mitglied, Familienvericherter, Rentner}

	public Reservierung() {
	}

	public Reservierung(String versNr, String zahlungsStatus, String kassenNr, Status status, Date begin) {
		this.versNr         = versNr;
		this.zahlungsStatus = zahlungsStatus;
		this.kassenNr       = kassenNr;
		this.status         = status;
		this.begin          = begin;
	}
}
