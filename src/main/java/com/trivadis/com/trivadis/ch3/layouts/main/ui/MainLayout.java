package com.trivadis.com.trivadis.ch3.layouts.main.ui;

import com.vaadin.ui.*;

/**
 * Created with IntelliJ IDEA.
 * User: Ulises Fasoli
 * Date: 22.10.13
 * Time: 13:09
 */
public class MainLayout extends VerticalLayout {

    private VerticalLayout upperSection = new VerticalLayout();
    private HorizontalSplitPanel lowerSection = new HorizontalSplitPanel();
    private VerticalLayout menuSection = new VerticalLayout();
    private VerticalLayout contentSection = new VerticalLayout();

    public MainLayout() {
        upperSection.addComponent(new Label("Header"));
        menuSection.addComponent(new Label("Menu"));
        contentSection.addComponent(new Label("Content"));


        lowerSection.addComponent(menuSection);
        lowerSection.addComponent(contentSection);

        addComponent(upperSection);
        addComponent(lowerSection);



        // full screen main layout
        setSizeFull();
        lowerSection.setSizeFull();

        contentSection.setSizeFull();


        setExpandRatio(lowerSection, 1);

        lowerSection.setSplitPosition(30);

    }

    private void showBorders() {
        String style = "v-ddwrapper-over";
        setStyleName(style);
        upperSection.setStyleName(style);
        lowerSection.setStyleName(style);
        menuSection.setStyleName(style);
        contentSection.setStyleName(style);
    }


    public void addMenuOption(String caption, final Component component) {

        Button button = new Button(caption);
        menuSection.addComponent(button);

        button.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                contentSection.removeAllComponents();
                contentSection.addComponent(component);
            }
        });
    }


    public void setHeader(String title) {

        upperSection.addComponent(new Label(title));
    }

}



