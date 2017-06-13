package de.woock.ddd.stattauto.gui.backoffice.event;

import org.springframework.context.ApplicationEvent;

import de.woock.ddd.stattauto.gui.backoffice.entity.Mitglied;

@SuppressWarnings("serial")
public class NewVersicherterEvent extends ApplicationEvent {
	
	public Mitglied mitglied;
	
	public NewVersicherterEvent(Object source, Mitglied mitglied) {
		super(source);
		this.mitglied = mitglied;
	}

}
