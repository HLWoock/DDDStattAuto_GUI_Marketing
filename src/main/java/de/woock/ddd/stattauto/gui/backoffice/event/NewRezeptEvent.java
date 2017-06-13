package de.woock.ddd.stattauto.gui.backoffice.event;

import org.springframework.context.ApplicationEvent;

import de.woock.ddd.stattauto.gui.backoffice.entity.Reservierung;

@SuppressWarnings("serial")
public class NewRezeptEvent extends ApplicationEvent {
	
	public Reservierung reservierung;
	
	public NewRezeptEvent(Object source, Reservierung reservierung) {
		super(source);
		this.reservierung = reservierung;
	}

}
