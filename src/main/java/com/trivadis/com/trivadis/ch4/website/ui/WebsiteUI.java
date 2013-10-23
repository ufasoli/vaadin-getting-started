package com.trivadis.com.trivadis.ch4.website.ui;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.server.WebBrowser;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import javax.servlet.annotation.WebServlet;

/**
 * Created with IntelliJ IDEA.
 * User: Ulises Fasoli
 * Date: 23.10.13
 * Time: 08:49
 */
public class WebsiteUI extends UI {

    @WebServlet(urlPatterns = {"/ch4/website/*", "/VAADIN/*"})
    @VaadinServletConfiguration(productionMode = false, ui = WebsiteUI.class, widgetset = "com.trivadis.AppWidgetSet")
    public static class WebsiteServlet extends VaadinServlet{

    }

    @Override
    protected void init(VaadinRequest vaadinRequest) {


        final VerticalLayout vl = new VerticalLayout();
        vl.setMargin(true);
        setContent(vl);


        String page = vaadinRequest.getPathInfo();
        String param = vaadinRequest.getParameter("param"); // gets the ?param=1
        String fragment = getPage().getUriFragment(); // gets the fragment after # ex localhost/page1#frg1
        WebBrowser browser = getPage().getWebBrowser(); // gets the browser used to access the page

        if(page == null || page.isEmpty() || "/".equals(page)){
            vl.addComponent(new Label("Welcome to simple site web"));
            getPage().setTitle("Simple web site");
        }
        else if("/page1".equals(page)){
            vl.addComponent(new Label("Page 1"));
            getPage().setTitle("Page 1");
        }
        else if("/page2".equals(page)){
            vl.addComponent(new Label("Page 2"));
            getPage().setTitle("Page 2");
        }
        else{
            vl.addComponent(new Label("Error 404"));
            getPage().setTitle("Error 404");
        }

    }
}
