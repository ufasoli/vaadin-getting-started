package com.trivadis.com.trivadis.ch3.layouts.ui;

import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

/**
 * Created with IntelliJ IDEA.
 * User: Ulises Fasoli
 * Date: 22.10.13
 * Time: 13:09
 */
public class MainLayout extends VerticalLayout {

    private VerticalLayout upperSection = new VerticalLayout();
    private HorizontalLayout lowerSection = new HorizontalLayout();
    private VerticalLayout menuSection = new VerticalLayout();
    private VerticalLayout contentSection = new VerticalLayout();

    public MainLayout() {
        upperSection.addComponent(new Label("Header"));
        menuSection.addComponent(new Label("Menu"));
        contentSection.addComponent(new Label("Content"));

        upperSection.addComponent(contentSection);
        lowerSection.addComponent(menuSection);
        addComponent(upperSection);
        addComponent(lowerSection);
        showBorders();


        // full screen main layout
       setSizeFull();

    }

    private void showBorders(){
        String style = "v-ddwrapper-over";
        setStyleName(style);
        upperSection.setStyleName(style);
        lowerSection.setStyleName(style);
        menuSection.setStyleName(style);
        contentSection.setStyleName(style);
    }

}



