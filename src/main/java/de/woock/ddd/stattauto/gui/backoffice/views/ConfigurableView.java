package de.woock.ddd.stattauto.gui.backoffice.views;

import javax.swing.JComponent;

public interface ConfigurableView {
	public <T> void   setValues(T dto);
	public JComponent buildPanel();
}
