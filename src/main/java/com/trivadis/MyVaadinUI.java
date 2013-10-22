package com.trivadis;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.*;
import com.vaadin.ui.Button.ClickEvent;
import sun.awt.HorizBagLayout;

@Theme("mytheme")
@SuppressWarnings("serial")
public class MyVaadinUI extends UI {

    @WebServlet(value = {"/myui/*", "/VAADIN/*"}, asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = MyVaadinUI.class, widgetset = "com.trivadis.AppWidgetSet")
    public static class Servlet extends VaadinServlet {


    }

    @Override
    protected void init(VaadinRequest request) {

        final VerticalLayout layout = new VerticalLayout();
        layout.setMargin(true);
        setContent(layout);

        final TextField name1 = new TextField("Somebody's name");
        name1.setRequired(true);
        final TextField name2 = new TextField("Somebody's name");
        name2.setRequired(true);

        layout.addComponent(name1);                   layout.addComponent(name2);

        Button button = new Button("Click Me");
        button.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent clickEvent) {

                if(name1.getValue().isEmpty() || name2.getValue().isEmpty() ){
                       Notification.show("Name1 and name2 are required fields", Notification.Type.ERROR_MESSAGE);
                }
                else{
                    Label label = new Label(getFunnyPhrase(name1.getValue(), name2.getValue()));
                    label.setContentMode(ContentMode.HTML);
                    layout.addComponent(label);
                }

            }
        });
        layout.addComponent(button);


    }

    public String getFunnyPhrase(String name1, String name2) {

        String[] verbs = new String[]{
                "eats", "melts", "breaks", "washes", "sells"
        };


        String[] bodyParts = new String[]{
                "head", "hands", "waist", "eyes", "elbows"
        };

        return name1 + " " +
                verbs[(int) (Math.random() * 100 % verbs.length)] + " " +
                name2 + "'s " +
                bodyParts[(int) (Math.random() * 100 % bodyParts.length)] + " " ;

    }

}
