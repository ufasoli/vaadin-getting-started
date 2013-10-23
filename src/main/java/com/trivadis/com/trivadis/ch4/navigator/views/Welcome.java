package com.trivadis.com.trivadis.ch4.navigator.views;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.BaseTheme;

/**
 * Created with IntelliJ IDEA.
 * User: Ulises Fasoli
 * Date: 23.10.13
 * Time: 09:02
 */
public class Welcome extends VerticalLayout implements View {

    private Navigator navigator;

    public Welcome() {
        addComponent(new Label("Welcome"));

        Button gotoPage1 = new Button("page1");
        Button gotoPage2 = new Button("page2");


        Button.ClickListener listener = new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                navigator.navigateTo(clickEvent.getButton().getCaption());
            }
        };

        gotoPage1.addClickListener(listener);
        gotoPage1.setStyleName(BaseTheme.BUTTON_LINK);
        gotoPage2.addClickListener(listener);
        gotoPage2.setStyleName(BaseTheme.BUTTON_LINK);

        addComponent(new Label("Welcome"));
        addComponent(gotoPage1);
        addComponent(gotoPage2);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        navigator = viewChangeEvent.getNavigator();
        Notification.show("Welcome Page");
    }
}
