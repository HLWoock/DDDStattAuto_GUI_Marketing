package de.woock.ddd.stattauto.gui.backoffice.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Controller;

import de.woock.ddd.stattauto.gui.backoffice.entity.Mitglied;
import de.woock.ddd.stattauto.gui.backoffice.event.NewVersicherterEvent;
import de.woock.ddd.stattauto.gui.backoffice.service.ReservierungsService;
import de.woock.ddd.stattauto.gui.backoffice.views.FahrzeugReservierenView;

@Controller
public class FahrzeugReservierenController implements ApplicationEventPublisherAware, 
                                               ApplicationListener<NewVersicherterEvent>,
                                               ActionListener{

	@Autowired private ReservierungsService    service;
	@Autowired private FahrzeugReservierenView view;

	private Mitglied                versicherter;
	private ApplicationEventPublisher   publisher;

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		publisher = applicationEventPublisher;
	}
	
	@Override
	public void onApplicationEvent(NewVersicherterEvent event) {
		Mitglied versicherter = event.mitglied;
		if (versicherter != null) {
			view.setValues(versicherter);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String name    = view.txName.getText();
		String vorname = view.txVorname.getText();
		
		versicherter = service.getVersicherter(name, vorname);
		
		NewVersicherterEvent newVersicherterEvent = new NewVersicherterEvent(this, versicherter);
		publisher.publishEvent(newVersicherterEvent);
	}

}
