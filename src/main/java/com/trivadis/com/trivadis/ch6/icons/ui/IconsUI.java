package com.trivadis.com.trivadis.ch6.icons.ui;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.Item;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.server.ClassResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;

import javax.servlet.annotation.WebServlet;

/**
 * User: ufasoli
 * Date: 23/10/13
 * Time: 16:17
 * Project : vaadin.tutorial
 */
public class IconsUI extends UI {

    @WebServlet(urlPatterns = {"/ch6/icons/*", "/VAADIN/*"})
    @VaadinServletConfiguration(productionMode = false, ui = IconsUI.class, widgetset = "com.trivadis.AppWidgetSet")
    public static class IconsServlet extends VaadinServlet {

    }

    private TextField tf = new TextField("Email");
    private ComboBox cb = new ComboBox("Type");
    private TextArea ta = new TextArea("Details");
    private OptionGroup og = new OptionGroup("Priority");
    private Button button = new Button("send");

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout vl = new VerticalLayout();
        vl.setMargin(true);

        og.addItem("Too low");
        og.addItem("Extremely high");


        tf.setWidth("100%");
        cb.setWidth("100%");
        ta.setWidth("100%");
        og.setWidth("100%");

        HorizontalLayout topLayout = new HorizontalLayout();
        topLayout.setWidth("100%");
        topLayout.addComponent(tf);
        topLayout.addComponent(cb);


        HorizontalLayout bottomLayout = new HorizontalLayout();
        bottomLayout.setWidth("100%");
        bottomLayout.addComponent(og);
        bottomLayout.addComponent(button);
        bottomLayout.setComponentAlignment(button, Alignment.BOTTOM_RIGHT);


        vl.addComponent(topLayout);
        vl.addComponent(ta);
        vl.addComponent(bottomLayout);


        tf.setIcon(new ClassResource("email.png"));
        cb.setIcon(new ClassResource("note.png"));
        ta.setIcon(new ClassResource("document.png"));
        button.setIcon(new ClassResource("ok.png"));

        og.setItemIcon("Too low", new ClassResource("attention.png"));
        og.setItemIcon("Extremely high", new ClassResource("error.png"));

        setContent(vl);
    }
}

