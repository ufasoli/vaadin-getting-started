package com.trivadis.com.trivadis.ch4.shortcuts.ui;


import com.vaadin.annotations.PreserveOnRefresh;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.event.Action;
import com.vaadin.event.ShortcutAction;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;

import javax.servlet.annotation.WebServlet;

/**
 * Created with IntelliJ IDEA.
 * User: Ulises Fasoli
 * Date: 23.10.13
 * Time: 09:17
 */
@PreserveOnRefresh // components will not be reinitialized on page refresh ( init method will not be called)
public class ShortcutsUI extends UI {


    @WebServlet(urlPatterns = {"/ch4/shortcuts/*", "/VAADIN/*"})
    @VaadinServletConfiguration(productionMode = false, ui = ShortcutsUI.class, widgetset = "com.trivadis.AppWidgetSet")
    public static class ShortcutsServlet extends VaadinServlet {

    }

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout vl = new VerticalLayout();
        vl.setMargin(true);
        vl.setSpacing(true);
        setContent(vl);

        final TextField tf = new TextField("Your data :");
        vl.addComponent(tf);

        Button btn = new Button("Send data (ENTER)");
        btn.setClickShortcut(ShortcutAction.KeyCode.ENTER);
        btn.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                vl.addComponent(new Label(tf.getValue()));
                tf.setValue("");
                tf.focus();
            }
        });

        vl.addComponent(btn);


        Action.Handler handler = new Action.Handler() {
            @Override
            public Action[] getActions(Object o, Object o2) {
                return new Action[]{
                        new ShortcutAction("Enter", ShortcutAction.KeyCode.ENTER, null),
                        new ShortcutAction("Shift + U", ShortcutAction.KeyCode.U, new int[]{ShortcutAction.ModifierKey.SHIFT})
                };  //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public void handleAction(Action action, Object o, Object o2) {
                Notification.show(action.getCaption());
            }


        };

        addActionHandler(handler);
    }


}
