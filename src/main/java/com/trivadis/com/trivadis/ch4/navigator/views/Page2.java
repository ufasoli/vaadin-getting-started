package com.trivadis.com.trivadis.ch4.navigator.views;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;

/**
 * Created with IntelliJ IDEA.
 * User: Ulises Fasoli
 * Date: 23.10.13
 * Time: 09:02
 */
public class Page2 extends VerticalLayout implements View {

    public Page2() {
        addComponent(new Label("Page 2"));
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        Notification.show("Page 2");
    }
}
