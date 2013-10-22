package com.trivadis.com.trivadis.ch2.datepickers.ui;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.Property;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.shared.ui.datefield.Resolution;
import com.vaadin.ui.*;

import javax.servlet.annotation.WebServlet;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Ulises Fasoli
 * Date: 22.10.13
 * Time: 11:07
 */
public class DatePickersUI extends UI {


    @WebServlet(urlPatterns = {"/ch2/datep/*", "/VAADIN/*"})
    @VaadinServletConfiguration(productionMode = false, ui = DatePickersUI.class, widgetset = "com.trivadis.AppWidgetSet")
    public static class DatePickersServlet extends VaadinServlet {

    }


    @Override
    protected void init(VaadinRequest vaadinRequest) {

        DateField dateField = new DateField();

        DateField yearDateField = new DateField();
        yearDateField.setResolution(Resolution.YEAR);


        VerticalLayout vl = new VerticalLayout();
        vl.addComponent(dateField);
        vl.addComponent(yearDateField);
        setContent(vl);


    }


}
