package com.trivadis.com.trivadis.ch2.textarea.ui;


import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.Property;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.*;

import javax.servlet.annotation.WebServlet;

/**
 * Created with IntelliJ IDEA.
 * User: Ulises Fasoli
 * Date: 21.10.13
 * Time: 16:38
 */
public class TextareaUI extends UI implements Property.ValueChangeListener {




    @WebServlet(value = {"/ch2/textarea/*", "/VAADIN/*"}, asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = TextareaUI.class, widgetset = "com.trivadis.AppWidgetSet")
    public static class TextareaServlet extends VaadinServlet {
    }



    @Override
    protected void init(VaadinRequest vaadinRequest) {
       TextArea textArea = new TextArea("Enter multi lined text and press TAB");
        textArea.addValueChangeListener(this);
        textArea.setImmediate(true);
         textArea.setWordwrap(true);


        RichTextArea rta = new RichTextArea();
        rta.setImmediate(true);

        Label richTextLabel = new Label(rta, ContentMode.HTML);


        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.addComponent(textArea);

        verticalLayout.addComponent(rta);
        verticalLayout.addComponent(richTextLabel);


        setContent(verticalLayout);
    }

    @Override
    public void valueChange(Property.ValueChangeEvent valueChangeEvent) {
        String userText = valueChangeEvent.getProperty().getValue().toString();

        Notification.show(userText);
    }
}
