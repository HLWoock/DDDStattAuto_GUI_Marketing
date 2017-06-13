package de.woock.ddd.stattauto.gui.backoffice.views;

/*
 * Copyright (c) 2012-2014 JGoodies Software GmbH. All Rights Reserved.
 *
 * This software is the proprietary information of JGoodies Software GmbH.
 * Use is subject to license terms.
 *
 */

import java.util.Calendar;
import java.util.Date;
import java.util.SortedSet;

import javax.swing.JFormattedTextField;

import org.jdesktop.swingx.JXMonthView;

import com.jgoodies.application.ResourceMap;
import com.jgoodies.forms.factories.CC;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.sandbox.util.AbstractOpenMonthViewPopupAction;

public class OpenMonthViewPopupAction extends AbstractOpenMonthViewPopupAction {

	private static final long serialVersionUID = 1L;

	static final ResourceMap RESOURCES = new MyResourceMap(); // Application.getResourceMap(OpenMonthViewPopupAction.class);

    private JXMonthView monthView;

    OpenMonthViewPopupAction(JFormattedTextField textField) {
        super(textField, RESOURCES, "openMonthViewPopup");
    }

    @Override
    protected void configurePopup() {
        popup.setBackground(monthView.getBackground());
        popup.setLayout(new FormLayout("center:pref", "p, $lg, p, $lg"));
        popup.add(monthView,        CC.xy(1, 1));
        popup.add(buildTodayLink(), CC.xy(1, 3));
    }

    @Override
    protected void initMonthView() {
        monthView = new JXMonthView();
        monthView.setShowingWeekNumber(true);
        monthView.setFirstDayOfWeek(Calendar.MONDAY);
        monthView.setTraversable(true);
        monthView.addActionListener(handler);
        monthView.addFocusListener(handler);
    }


    @Override
    protected void initializeSelection() {
        super.initializeSelection();
        if (monthView.isSelectionEmpty()) {
            setToday();
        }
    }

    @Override
    protected Date getDate() {
        SortedSet<Date> selection = monthView.getSelection();
       return selection.isEmpty() ? null : selection.first();
    }

    @Override
    protected void setDate(Date date) {
        monthView.setSelectionInterval(date, date);
        monthView.ensureDateVisible(date);
    }


    @Override
    protected void cleanup() {
        monthView.removeActionListener(handler);
        monthView.removeFocusListener(handler);
        monthView = null;
        super.cleanup();
    }


    @Override
    protected void postVisible() {
        monthView.requestFocusInWindow();
    }



}