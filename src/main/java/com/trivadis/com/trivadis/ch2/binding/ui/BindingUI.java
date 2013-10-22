package com.trivadis.com.trivadis.ch2.binding.ui;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.util.ObjectProperty;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import javax.servlet.annotation.WebServlet;

/**
 * Created with IntelliJ IDEA.
 * User: Ulises Fasoli
 * Date: 21.10.13
 * Time: 16:38
 */
public class BindingUI extends UI {



    @WebServlet(value = {"/ch2/binding/*", "/VAADIN/*"}, asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = BindingUI.class, widgetset = "com.trivadis.AppWidgetSet")
    public static class BindingServlet extends VaadinServlet {
    }



    @Override
    protected void init(VaadinRequest vaadinRequest) {
        TextField textField = new TextField("Data");
        textField.setImmediate(true);

        Label label = new Label();

        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.addComponent(textField);
        verticalLayout.addComponent(label);

        setContent(verticalLayout);

        // bind properties datasource to elements
        ObjectProperty<String> property = new ObjectProperty<String>("the value");
        textField.setPropertyDataSource(property);
        label.setPropertyDataSource(property);
    }
}
