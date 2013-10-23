package com.trivadis.com.trivadis.ch5.tables.fieldfactory.ui;

import com.trivadis.com.trivadis.ch5.tables.fieldfactory.util.UserFieldFactory;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Table;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import javax.servlet.annotation.WebServlet;

/**
 * Created with IntelliJ IDEA.
 * User: Ulises Fasoli
 * Date: 23.10.13
 * Time: 10:12
 */
public class FieldFactoryUI extends UI {


    @WebServlet(urlPatterns = {"/ch5/tables/fieldfactory/*", "/VAADIN/*"})
    @VaadinServletConfiguration(productionMode = false, ui = FieldFactoryUI.class, widgetset = "com.trivadis.AppWidgetSet")
    public static class FieldFactoryServlet extends VaadinServlet {

    }

    @Override
    protected void init(VaadinRequest vaadinRequest) {
     final VerticalLayout vl = new VerticalLayout();
        vl.setMargin(true);
        setContent(vl);

        Table table = new Table("Users");
        table.setPageLength(0);
        table.setEditable(true);
        table.addContainerProperty("Login", String.class, "");
        table.addContainerProperty("Password", String.class, "");
        table.addItem();
        table.addItem();
        table.addItem();

        table.setTableFieldFactory(new UserFieldFactory());
        vl.addComponent(table);
    }
}
