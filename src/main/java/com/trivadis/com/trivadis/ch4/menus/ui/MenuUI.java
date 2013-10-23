package com.trivadis.com.trivadis.ch4.menus.ui;

import com.vaadin.annotations.PreserveOnRefresh;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;

import com.vaadin.ui.MenuBar;
import com.vaadin.ui.Notification;
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
public class MenuUI extends UI {


    @WebServlet(urlPatterns = {"/ch4/menus/*", "/VAADIN/*"})
    @VaadinServletConfiguration(productionMode = false, ui = MenuUI.class, widgetset = "com.trivadis.AppWidgetSet")
    public static class MenuServlet extends VaadinServlet {

    }

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout vl = new VerticalLayout();
        vl.setMargin(true);
        setContent(vl);

        MenuBar menuBar = new MenuBar();
        menuBar.addItem("Option 1", null);
        menuBar.addItem("Option with command", new MenuBar.Command() {
            @Override
            public void menuSelected(MenuBar.MenuItem menuItem) {
                Notification.show("Option with command");
            }
        });

        vl.addComponent(menuBar);
    }
}
