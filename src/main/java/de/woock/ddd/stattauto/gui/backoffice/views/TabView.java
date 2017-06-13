package de.woock.ddd.stattauto.gui.backoffice.views;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

import org.springframework.beans.factory.annotation.Autowired;

@SuppressWarnings("serial")
@View
public class TabView extends JFrame {
	
	@Autowired MitgliedAuthentifizierenView paneMitgliedAuthentifizieren;
	@Autowired VerfuegbareFahrzeugeView     paneReservierungen;
	@Autowired FahrzeugReservierenView      paneBelege;
	
	@Autowired List<ConfigurableView> tabs;
	

	@PostConstruct
	private void init() {
		setTitle("StattAuto Backoffice");
		setDefaultLookAndFeelDecorated(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(new GridLayout(1, 1));
		add(createTabPane(), BorderLayout.CENTER);
		setSize(480, 450);
		setLocationRelativeTo(null);
		UIManager.put("swing.boldMetal", Boolean.TRUE);
		setVisible(true);		
	}
	
	private JPanel createTabPane() {
		JPanel tabPane = new JPanel(new GridLayout(1, 1));
		JTabbedPane tabbedPane = new JTabbedPane();
		
		tabbedPane.addTab("Mitglied Ermitteln" , paneMitgliedAuthentifizieren.buildPanel());
		tabbedPane.addTab("Reservierungen"     , paneReservierungen.buildPanel());
		tabbedPane.addTab("Belege"             , paneBelege.buildPanel());
		
//		tabbedPane.setEnabledAt(1, false);
//		tabbedPane.setEnabledAt(2, false);
		
		tabPane.add(tabbedPane);
		
		return tabPane;
	}
}
