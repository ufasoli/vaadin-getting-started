package com.trivadis.com.trivadis.ch4.navigator.ui;

import com.trivadis.com.trivadis.ch4.navigator.views.Page1;
import com.trivadis.com.trivadis.ch4.navigator.views.Page2;
import com.trivadis.com.trivadis.ch4.navigator.views.Welcome;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;

import javax.servlet.annotation.WebServlet;

/**
 * Created with IntelliJ IDEA.
 * User: Ulises Fasoli
 * Date: 23.10.13
 * Time: 09:05
 */
public class NavigatorUI extends UI {


    @WebServlet(urlPatterns = {"/ch4/navigator/*", "/VAADIN/*"})
    @VaadinServletConfiguration(productionMode = false, ui = NavigatorUI.class, widgetset = "com.trivadis.AppWidgetSet")
    public static class NavigatorServlet extends VaadinServlet {

    }

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        Navigator navigator = new Navigator(this, this);
        navigator.addView("", new Welcome());


        // allow navigation like
        // http://localhost:8080/ch3/navigator/#!page1
        // http://localhost:8080/ch3/navigator/#!page2
        navigator.addView("page1", new Page1());
        navigator.addView("page2", new Page2());
    }
}
