package com.trivadis.com.trivadis.ch2.option.ui;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.Property;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Notification;
import com.vaadin.ui.OptionGroup;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import javax.servlet.annotation.WebServlet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Ulises Fasoli
 * Date: 22.10.13
 * Time: 11:07
 */
public class OptionGroupUI extends UI implements Property.ValueChangeListener{




    @WebServlet(urlPatterns = {"/ch2/options/*", "/VAADIN/*"})
    @VaadinServletConfiguration(productionMode = false, ui = OptionGroupUI.class, widgetset = "com.trivadis.AppWidgetSet")
    public static class OptionGroupServlet extends VaadinServlet{

    }


    @Override
    protected void init(VaadinRequest vaadinRequest) {

        List<String> answers =new ArrayList<String>();
        answers.add("Vaadin beans");
        answers.add( "Session Beans");
        answers.add("Entreprise app for Vaadin beans");
        answers.add("Message-driven beans" );

        OptionGroup optionGroup = new OptionGroup("Two kinds of EJB in JEE are ? ", answers);

        optionGroup.addValueChangeListener(this);
        optionGroup.setImmediate(true);
         optionGroup.setMultiSelect(true);
        VerticalLayout vl = new VerticalLayout();
        vl.addComponent(optionGroup);

        setContent(vl);

    }

    @Override
    public void valueChange(Property.ValueChangeEvent valueChangeEvent) {
        Set<String> answers = (Set<String>) valueChangeEvent.getProperty().getValue();

        if(answers.size() == 2 && answers.contains("Session Beans") && answers.contains("Message-driven beans") ) {
            Notification.show(String.format("Correct your answer is : %s", answers.toString()), Notification.Type.WARNING_MESSAGE);
        }
        else{
            Notification.show(String.format("Incorrect your answer is : %s", answers.toString()), Notification.Type.ERROR_MESSAGE);
        }


    }
}
