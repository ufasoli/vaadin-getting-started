package com.trivadis.com.trivadis.ch5.tables.first.ui;

import com.trivadis.com.trivadis.ch4.shortcuts.ui.ShortcutsUI;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.util.sqlcontainer.SQLContainer;
import com.vaadin.data.util.sqlcontainer.query.QueryDelegate;
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
public class MyFirstTable extends UI {


    @WebServlet(urlPatterns = {"/ch5/tables/first/*", "/VAADIN/*"})
    @VaadinServletConfiguration(productionMode = false, ui = MyFirstTable.class, widgetset = "com.trivadis.AppWidgetSet")
    public static class ShortcutsServlet extends VaadinServlet {

    }

    @Override
    protected void init(VaadinRequest vaadinRequest) {
     final VerticalLayout vl = new VerticalLayout();
        vl.setMargin(true);
        setContent(vl);

        Table tbl = new Table();
        tbl.addContainerProperty("Column 1", String.class, "(default 1)");
        tbl.addContainerProperty("Column 2", String.class, "(default 2)");

        tbl.addItem(new Object[]{"Hi", "There"}, "item ID 1");
        tbl.addItem(new Object[]{"Well", "Hello"}, "item ID 2");

        // will default to (default1) and (default2)
        tbl.addItem();
        tbl.setSizeFull();

        // this will enable sorting on the tables
        tbl.addHeaderClickListener(new Table.HeaderClickListener() {
            @Override
            public void headerClick(Table.HeaderClickEvent event) {
                Notification.show("Header clicked : "+event.getPropertyId());
            }
        });
        tbl.setColumnHeaders("Header1", "Header2");


        tbl.setFooterVisible(true);


        tbl.setColumnFooter("Column 1", "Footer 1");

        tbl.addFooterClickListener(new Table.FooterClickListener() {
            @Override
            public void footerClick(Table.FooterClickEvent event) {
                Notification.show("Footer clicked : " + event.getPropertyId());
            }
        });

        String[] headers = tbl.getColumnHeaders();
        String header = tbl.getColumnHeader("Header1");

        vl.addComponent(tbl);
    }
}
