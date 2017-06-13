package de.woock.ddd.stattauto.gui.backoffice.views;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JTextField;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.jgoodies.forms.builder.FormBuilder;
import com.jgoodies.forms.factories.Paddings;
import com.jgoodies.jsdl.common.action.ActionObject;

import de.woock.ddd.stattauto.gui.backoffice.controller.FahrzeugReservierenController;

@View
public final class MitgliedAuthentifizierenView extends ActionObject implements ConfigurableView {
	
	private Logger log = Logger.getLogger(MitgliedAuthentifizierenView.class);
	
	@Autowired private FahrzeugReservierenController controller;

    public JTextField          txName                = new JTextField();
    public JTextField          txVorname             = new JTextField();
    private JComboBox<String>  cbGeschlecht;
    private JTextField         txGeburtsdatum        = new JTextField();
    private JTextField         txStrase              = new JTextField();
    private JTextField         txOrt                 = new JTextField();
    private JComboBox<String>  cbLand;
    private JTextField         txVersNr              = new JTextField();
    private JTextField         txZahlungsstatus      = new JTextField();
    private JTextField         txKrankenkasse        = new JTextField();
    private JTextField         txTitel               = new JTextField();
    private JTextField         txGeburtsort          = new JTextField();
    private JComboBox<String>  cbVericherungsStatus;
    private JTextField         txBeginVersSchutz     = new JTextField();
    private JButton            bnSuche               = new JButton("Ermitteln");

    public JComponent buildPanel() {
	initComponents();
	
	return FormBuilder.create()
	                  .columns("right:[40dlu,pref], 3dlu, 70dlu, 7dlu, right:[40dlu,pref], 3dlu, 70dlu")
	                  .rows("4*(p, 3dlu, p, 3dlu, p, 3dlu, p, 9dlu, p, 3dlu)")
	     	          .padding(Paddings.DIALOG)
	
	                  .addSeparator("Mitglied")          .xyw(1,  1, 7)
	                  	.add("Mitgliedsnummer:")         .xy (1,  3)   .add(txVersNr)            .xy (3,  3)
	                  	.add(bnSuche)                    .xy (3,  5)
		              
	                  	.addSeparator("Personendaten")     .xyw(1,  7, 7)
	                  	.add("Anrede:")                  .xy (1,  9)   .add(cbGeschlecht)        .xy (3,  9)
	                  	.add("Titel:")                   .xy (5,  9)   .add(txTitel)             .xy (7,  9)	                  	
	                  	.add("Vorname:")                 .xy (1, 11)   .add(txVorname)           .xy (3, 11)
	                  	.add("Name:")                    .xy (5, 11)   .add(txName)              .xy (7, 11)	                  	
	                  	.add("Geburtsort:"  )            .xy (1, 13)   .add(txGeburtsort)        .xy (3, 13)
	                  	.add("Geburtsdatum:")            .xy (1, 15)   .add(txGeburtsdatum)      .xy (3, 15)
	
	                  .addSeparator("Anschrift")         .xyw(1, 17, 7)
	                  	.add("Strasse:")                 .xy (1, 19)   .add(txStrase)            .xy (3, 19)
	                  	.add("Nr:")                      .xy (5, 19)   .add(txZahlungsstatus)    .xy (7, 19)
	                  	.add("Plz:")                     .xy (1, 21)   .add(txBeginVersSchutz)   .xy (3, 21)
	                  	.add("Ort:")                     .xy (5, 21)   .add(txOrt)               .xy (7, 21)
	                  	.add("Tel:")                     .xy (1, 23)   .add(txKrankenkasse)      .xy (3, 23)
	                  	.add("Land:")                    .xy (1, 25)   .add(cbLand)              .xy (3, 25)
	
//	                  .addSeparator("Versicherungsdaten").xyw(1, 17, 7)
//	                  	.add("Vers. Nr:")                .xy (1, 19)   .add(txVersNr)            .xyw(3, 19, 5)
//	                  	.add("Zahlungsstatus:")          .xy (1, 21)   .add(txZahlungsstatus)    .xy (3, 21)
//	                  	.add("Krankenkasse:")            .xy (5, 21)   .add(txKrankenkasse)      .xy (7, 21)
//	                  	.add("Versicherungsstatus:")     .xy (1, 23)   .add(cbVericherungsStatus).xy (3, 23)
//	                  	.add("Begin Vers. Schutz")       .xy (1, 25)   .add(txBeginVersSchutz)   .xy (3, 25)
					  
	     
	                  .build();     
	}

	public <T> void setValues(T dto) {
//    	Mitglied versicherter = null;
//    	if (dto instanceof Mitglied) {
//    		versicherter = (Mitglied)dto;
//    	}
//
//		log.debug("setValues: versicherter");
//		
//		txName              .setText(versicherter.getName());
//		txVorname           .setText(versicherter.getVorname());
//		cbGeschlecht        .setSelectedIndex(0);
//		txGeburtsdatum      .setText(DateFormatter.getFormattedDate(versicherter.getGeburtsdatum()));
//		txStrase            .setText(versicherter.getAdresse().getStrasse());
//		txOrt               .setText(versicherter.getAdresse().getOrt());
//		cbLand              .setSelectedIndex(versicherter.getAdresse().getLand().ordinal());
//		txVersNr            .setText(versicherter.getVersicherung().getVersNr());
//		txZahlungsstatus    .setText(versicherter.getVersicherung().getZahlungsStatus());
//		txKrankenkasse      .setText(versicherter.getVersicherung().getKassenNr());
//		cbVericherungsStatus.setSelectedIndex(versicherter.getVersicherung().getStatus().ordinal());
//		txBeginVersSchutz   .setText(DateFormatter.getFormattedDate(versicherter.getVersicherung().getBegin()));
	}

	private void initComponents() {
		cbGeschlecht         = createGeschlechtComboBox();
        cbLand               = createApprovalStatusComboBox();
        cbVericherungsStatus = createProjectTypeComboBox();
        
//        bnSuche.addActionListener(controller);
    }

	
	
    private static JComboBox<String> createGeschlechtComboBox() {
        return new JComboBox<>(new String[] { "", "Herr", "Frau" });
    }

    private static JComboBox<String> createApprovalStatusComboBox() {
        return new JComboBox<>(new String[] { "", "Deutschland", "Österreich", "Schweiz" });
    }

    private static JComboBox<String> createProjectTypeComboBox() {
        return new JComboBox<>(new String[] { "Mitglied", "Familieversicherter", "Rentner" });
    }


}