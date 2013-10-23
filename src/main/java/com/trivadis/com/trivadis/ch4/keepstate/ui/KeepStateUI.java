package com.trivadis.com.trivadis.ch4.keepstate.ui;

import com.vaadin.annotations.PreserveOnRefresh;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.Property;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import javax.servlet.annotation.WebServlet;

/**
 * Created with IntelliJ IDEA.
 * User: Ulises Fasoli
 * Date: 23.10.13
 * Time: 09:17
 */
@PreserveOnRefresh // components will not be reinitialized on page refresh ( init method will not be called)
public class KeepStateUI extends UI {


    @WebServlet(urlPatterns = {"/ch4/keepstate/*", "/VAADIN/*"})
    @VaadinServletConfiguration(productionMode = false, ui = KeepStateUI.class, widgetset = "com.trivadis.AppWidgetSet")
    public static class KeepStateServlet extends VaadinServlet {

    }

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout vl = new VerticalLayout();
        vl.setMargin(true);
        setContent(vl);

        TextField textField = new TextField("Type, press ENTER and refresh the browser");
        textField.setImmediate(true);

        textField.addValueChangeListener(new Property.ValueChangeListener() {
            @Override
            public void valueChange(Property.ValueChangeEvent valueChangeEvent) {
                Notification.show("Value : "+valueChangeEvent.getProperty().getValue());
            }
        });

        vl.addComponent(textField);
    }
}
