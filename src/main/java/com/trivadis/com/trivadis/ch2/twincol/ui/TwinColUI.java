package com.trivadis.com.trivadis.ch2.twincol.ui;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.Property;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
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
public class TwinColUI extends UI  {


    @WebServlet(urlPatterns = {"/ch2/twincol/*", "/VAADIN/*"})
    @VaadinServletConfiguration(productionMode = false, ui = TwinColUI.class, widgetset = "com.trivadis.AppWidgetSet")
    public static class TwinColServlet extends VaadinServlet {

    }


    @Override
    protected void init(VaadinRequest vaadinRequest) {

        List<String> answers = new ArrayList<String>();
        answers.add("Vaadin beans");
        answers.add("Session Beans");
        answers.add("Entreprise app for Vaadin beans");
        answers.add("Message-driven beans");


        TwinColSelect og = new TwinColSelect("Two kinds of EJB in JEE are ? ", answers);

        VerticalLayout vl = new VerticalLayout();
        vl.addComponent(og);

        setContent(vl);
    }
}
