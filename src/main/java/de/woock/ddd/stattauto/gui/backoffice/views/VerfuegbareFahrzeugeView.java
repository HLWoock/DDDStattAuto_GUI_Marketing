package de.woock.ddd.stattauto.gui.backoffice.views;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.jgoodies.forms.builder.ListViewBuilder;
import com.jgoodies.forms.factories.Paddings;
import com.jgoodies.jsdl.component.JGComponentFactory;

import de.woock.ddd.stattauto.gui.backoffice.controller.OverviewController;


@View
public final class VerfuegbareFahrzeugeView  implements ConfigurableView {

	private Logger log = Logger.getLogger(VerfuegbareFahrzeugeView.class);
	
	@Autowired private OverviewController controller;
	
	private DefaultTableModel model;

    private JTable  contactTable;
    private JButton newButton;
    private JButton editButton;
    private JButton deleteButton;
    
    public JComponent buildPanel() {
	initComponents();
	
	return ListViewBuilder.create()
	    	.padding(Paddings.DIALOG)
	    	.labelText("Fahrzeuge:")
	    	.listView(contactTable)
	    	.listBar(newButton, editButton, deleteButton)
	    	.build();
	}

    @Override
	public <T> void setValues(T dto) {
//    	Mitglied versicherter = null;
//    	if (dto instanceof Mitglied) {
//    		versicherter = (Mitglied)dto;
//    	}
//    		
//		log.debug("setValues: versicherter");
//		if (versicherter == null) {
//			while (model.getRowCount() != 0) {
//				model.removeRow(0);
//			}
//		} else {
//			for (Rezept rezept : versicherter.getRezepte()) {
//				model.addRow(new Object[]{rezept.rezeptNummer, versicherter.getVersicherung().getKassenNr(), versicherter.getVersicherung().getStatus() });
//			}
//		}
	}

	private void initComponents() {
    	JGComponentFactory factory = JGComponentFactory.getCurrent();
    	model = new DefaultTableModel(new Object[][] {},
    			new Object[] { "Station", "Klasse", "Bezeichnung", "Status" });
    	
    	contactTable = factory.createReadOnlyTable(model);
    	contactTable.setAutoCreateRowSorter(true);
    	ListSelectionModel selectionModel = contactTable.getSelectionModel();
    	selectionModel.addListSelectionListener(controller);
    	
    	newButton    = factory.createButton("Fertigstellen");
    	editButton   = factory.createButton("Erneut Suchen");
    	deleteButton = factory.createButton("Zubehör Konfigurieren");
    }

}