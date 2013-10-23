package com.trivadis.com.trivadis.ch5.tables.editable.ui;

import com.trivadis.com.trivadis.ch5.tables.first.model.User;
import com.trivadis.com.trivadis.ch5.tables.first.ui.MyFirstTable;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.Item;
import com.vaadin.data.util.BeanItem;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Table;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import javax.servlet.annotation.WebServlet;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Ulises Fasoli
 * Date: 23.10.13
 * Time: 11:36
 */
public class EditableTableUI extends UI {


    @WebServlet(urlPatterns = {"/ch5/tables/editable/*", "/VAADIN/*"})
    @VaadinServletConfiguration(productionMode = false, ui = EditableTableUI.class, widgetset = "com.trivadis.AppWidgetSet")
    public static class EditableTableServlet extends VaadinServlet {

    }

    @Override
    protected void init(VaadinRequest request) {
        VerticalLayout vl = new VerticalLayout();
        vl.setMargin(true);

        User user = new User();
        user.setLogin("Mon  login");
        user.setPassword("My Password");

        BeanItem<User> item = new BeanItem<User>(user);

        Table table = new Table();
        table.addContainerProperty("String", String.class, "");
        table.addContainerProperty("Boolean", Boolean.class, false);
        table.addContainerProperty("Date", Date.class, null);
        table.addContainerProperty("Item", Item.class, null);

        table.addItem();
        table.addItem();
        table.addItem();
        // add item in 4th position
        // since Vaadin uses by default an IndexedContainer that will automatically numerate the previous 1,2,3
        table.addItem(new Object[]{"", true, new Date(), item},4);

        table.setEditable(true);

        vl.addComponent(table);
        setContent(vl);
    }
}
