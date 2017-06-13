package de.woock.ddd.stattauto.gui.backoffice.controller;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Controller;

import de.woock.ddd.stattauto.gui.backoffice.entity.Mitglied;
import de.woock.ddd.stattauto.gui.backoffice.entity.Reservierung;
import de.woock.ddd.stattauto.gui.backoffice.event.NewRezeptEvent;
import de.woock.ddd.stattauto.gui.backoffice.event.NewVersicherterEvent;
import de.woock.ddd.stattauto.gui.backoffice.views.VerfuegbareFahrzeugeView;

@Controller
public class OverviewController implements ApplicationListener<NewVersicherterEvent>,
                                           ApplicationEventPublisherAware,
                                           ListSelectionListener {

	@Autowired 
	private VerfuegbareFahrzeugeView        view;
	private Mitglied                  mitglied;
	private ApplicationEventPublisher publisher;

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		publisher = applicationEventPublisher;
	}
	
	@Override
	public void onApplicationEvent(NewVersicherterEvent event) {
		mitglied = event.mitglied;
		if (mitglied != null) {
			view.setValues(mitglied);
		}
	}
	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		int index = e.getFirstIndex();
		Reservierung reservierung = mitglied.reservierungen.get(index);
		publisher.publishEvent(new NewRezeptEvent(this, reservierung));
	}

}
