package de.woock.ddd.stattauto.gui.backoffice.views;

import java.text.DateFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JTextField;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.jgoodies.common.format.EmptyDateFormat;
import com.jgoodies.forms.builder.FormBuilder;
import com.jgoodies.forms.factories.Paddings;
import com.jgoodies.jsdl.component.JGFormattedTextField;

import de.woock.ddd.stattauto.gui.backoffice.controller.FahrzeugReservierenController;
import de.woock.ddd.stattauto.gui.backoffice.entity.Mitglied;

@View
public final class FahrzeugReservierenView implements ConfigurableView {
	
	private Logger log = Logger.getLogger(FahrzeugReservierenView.class);
	
	@Autowired private FahrzeugReservierenController controller;

    public JTextField          txName                = new JTextField();
    public JTextField          txVorname             = new JTextField();
    private JComboBox<String>  cbGeschlecht;
    private JTextField         txGeburtsdatum        = new JTextField();
    private JTextField         txStrasse              = new JTextField();
    private JTextField         txOrt                 = new JTextField();
    private JComboBox<String>  cbLand;
    private JTextField         txVersNr              = new JTextField();
    private JTextField         txZahlungsstatus      = new JTextField();
    private JTextField         txKrankenkasse        = new JTextField();
    private JComboBox<String>  cbVericherungsStatus;
    private JTextField         txBeginVersSchutz     = new JTextField();
    private JButton            bnSuche               = new JButton("Suchen");
    private JGFormattedTextField dateField;

    public JComponent buildPanel() {
	initComponents();
	
	return FormBuilder.create()
	                  .columns("right:[40dlu,pref], 3dlu, 70dlu, 7dlu, right:[40dlu,pref], 3dlu, 70dlu")
	                  .rows("4*(p, 3dlu, p, 3dlu, p, 3dlu, p, 9dlu, p, 3dlu)")
	     	          .padding(Paddings.DIALOG)
	
	                  .addSeparator("Zeitraum")          .xyw(1,  1, 7)
	                  	.add("Begin")                    .xy (1,  3)   
	                  	.add("Ende")                     .xy (5,  3)   
	                  	.add("Datum:")                   .xy (1,  5)   .add(dateField)           .xy (3,  5)
	                  	.add("Datum:")                   .xy (5,  5)   .add(txVorname)           .xy (7,  5)
	                  	.add("Uhrzeit:")                 .xy (1,  7)   .add(txStrasse)           .xy (3,  7)
	                  	.add("Uhrzeit:")                 .xy (5,  7)   .add(txGeburtsdatum)      .xy (7,  7)
	
	                  .addSeparator("Station")           .xyw(1,  9, 7)
	                  	.add("Name:")                    .xy (1, 11)   .add(cbLand)              .xy (3, 11)
	
	                  .addSeparator("Fahrzeug")          .xyw(1, 13, 7)
	                  	.add("Fahrzeugtyp")              .xy (1, 15)   .add(cbVericherungsStatus).xy (3, 15)
	                  	.add("Fahrzeugklasse:")          .xy (1, 17)   .add(cbGeschlecht)        .xy (3, 17)
					  
					  .add(bnSuche)                      .xy (1, 21)
	     
	                  .build();     
	}

	public <T> void setValues(T dto) {
    	Mitglied mitglied = null;
    	if (dto instanceof Mitglied) {
    		mitglied = (Mitglied)dto;
    	}

		log.debug("setValues: versicherter");
		
//		txName              .setText(mitglied.getName());
//		txVorname           .setText(mitglied.getVorname());
//		cbGeschlecht        .setSelectedIndex(0);
//		txGeburtsdatum      .setText(DateFormatter.getFormattedDate(mitglied.getGeburtsdatum()));
//		txStrase            .setText(mitglied.getAdresse().getStrasse());
//		txOrt               .setText(mitglied.getAdresse().getOrt());
//		cbLand              .setSelectedIndex(mitglied.getAdresse().getLand().ordinal());
//		txVersNr            .setText(mitglied.getVersicherung().getVersNr());
//		txZahlungsstatus    .setText(mitglied.getVersicherung().getZahlungsStatus());
//		txKrankenkasse      .setText(mitglied.getVersicherung().getKassenNr());
//		cbVericherungsStatus.setSelectedIndex(mitglied.getVersicherung().getStatus().ordinal());
//		txBeginVersSchutz   .setText(DateFormatter.getFormattedDate(mitglied.getVersicherung().getBegin()));
	}

	private void initComponents() {
		DateFormat format = new EmptyDateFormat(DateFormat.getDateInstance(DateFormat.MEDIUM));
        dateField = new JGFormattedTextField(format);
        dateField.setColumns(8);
        dateField.setIconAction(new OpenMonthViewPopupAction(dateField));
        dateField.setIconVisibleAlways(true);
		
		cbGeschlecht         = createGeschlechtComboBox();
        cbLand               = createApprovalStatusComboBox();
        cbVericherungsStatus = createProjectTypeComboBox();
        
        bnSuche.addActionListener(controller);
    }

	
	
    private static JComboBox<String> createGeschlechtComboBox() {
        return new JComboBox<>(new String[] { "Kompakt", "Mittelklasse", "Komfort" });
    }

    private static JComboBox<String> createApprovalStatusComboBox() {
        return new JComboBox<>(new String[] { "Altona", "Christuskirche", "Langenhorn" });
    }

    private static JComboBox<String> createProjectTypeComboBox() {
        return new JComboBox<>(new String[] { "PKW", "Fahrrad" });
    }


}