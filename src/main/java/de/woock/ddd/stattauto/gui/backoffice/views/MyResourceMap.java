package de.woock.ddd.stattauto.gui.backoffice.views;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.File;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.text.MessageFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;

import com.jgoodies.application.ResourceMap;

public class MyResourceMap implements ResourceMap {

	@Override
	public String getString(String key, Object... args) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getBaseName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getBoolean(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ResourceBundle getBundle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public byte getByte(String arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Calendar getCalendar(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public char getCharacter(String arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ClassLoader getClassLoader() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Color getColor(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Date getDate(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Dimension getDimension(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getDouble(String arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public EmptyBorder getEmptyBorder(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public File getFile(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public float getFloat(String arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Font getFont(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Icon getIcon(String arg0) {
		// TODO Auto-generated method stub
		return new Icon() {
			
			@Override
			public void paintIcon(Component c, Graphics g, int x, int y) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public int getIconWidth() {
				return 0;
			}
			
			@Override
			public int getIconHeight() {
				return 0;
			}
		};
	}

	@Override
	public Image getImage(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ImageIcon getImageIcon(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Insets getInsets(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getInt(String arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public KeyStroke getKeyStroke(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getLong(String arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public MessageFormat getMessageFormat(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T getObject(String arg0, Class<T> arg1) {
		return (arg1.getSimpleName().equals("String")) ?(T) "cal" : null;
	}

	@Override
	public <T> T getObject(ResourceMap arg0, String arg1, Class<T> arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResourceMap getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Point getPoint(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rectangle getRectangle(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getResourceParentPath() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public short getShort(String arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public URI getURI(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public URL getURL(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InputStream getURLAsStream(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String resolvePath(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
