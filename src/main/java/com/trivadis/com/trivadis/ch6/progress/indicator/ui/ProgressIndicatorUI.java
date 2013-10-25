package com.trivadis.com.trivadis.ch6.progress.indicator.ui;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.ProgressIndicator;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import javax.servlet.annotation.WebServlet;

/**
 * Created with IntelliJ IDEA.
 * User: Ulises Fasoli
 * Date: 24.10.13
 * Time: 08:57
 */
public class ProgressIndicatorUI extends UI {


    @WebServlet(urlPatterns = {"/ch6/progress-indicator/*", "/VAADIN/*"})
    @VaadinServletConfiguration(productionMode = false, ui = ProgressIndicatorUI.class, widgetset = "com.trivadis.AppWidgetSet")
    public static class ProgressIndicatorServlet extends VaadinServlet {

    }

    private ProgressIndicator progressIndicator = new ProgressIndicator();
    @Override
    protected void init(VaadinRequest request) {

        final VerticalLayout vl = new VerticalLayout();
        vl.setMargin(true);
        setContent(vl);

        Button button = new Button("start algorithm");

        button.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                new HighTechAlgorithm().start();
            }
        });

        vl.addComponent(progressIndicator);
        vl.addComponent(button);
    }

    private class HighTechAlgorithm extends Thread{

        public void run(){

            try{

                for(int i = 0; i < 10; i++){
                    sleep(1000);
                    progressIndicator.setValue(i*0.1f);
                }
            }
            catch (InterruptedException ie){
                ie.printStackTrace();
            }
        }
    }
}
