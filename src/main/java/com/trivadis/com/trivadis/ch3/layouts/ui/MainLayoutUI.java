package com.trivadis.com.trivadis.ch3.layouts.ui;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;

import javax.servlet.annotation.WebServlet;

/**
 * Created with IntelliJ IDEA.
 * User: Ulises Fasoli
 * Date: 22.10.13
 * Time: 13:15
 */
public class MainLayoutUI extends UI {

    @WebServlet(urlPatterns = {"/ch3/mainlayout/*", "/VAADIN/*"})
    @VaadinServletConfiguration(productionMode = false, ui = MainLayoutUI.class, widgetset = "com.trivadis.AppWidgetSet")
    public static class MainLayoutServlet extends VaadinServlet {

    }

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        setContent(new MainLayout());
    }





}
