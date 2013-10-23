package com.trivadis.com.trivadis.ch6.trees.ui;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Tree;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import javax.servlet.annotation.WebServlet;

/**
 * User: ufasoli
 * Date: 23/10/13
 * Time: 16:17
 * Project : vaadin.tutorial
 */
public class TreeUI extends UI{

    @WebServlet(urlPatterns = {"/ch6/trees/*", "/VAADIN/*"})
    @VaadinServletConfiguration(productionMode = false, ui = TreeUI.class, widgetset = "com.trivadis.AppWidgetSet")
    public static class TreeServlet extends VaadinServlet{

    }


    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout vl = new VerticalLayout();
        vl.setMargin(true);

        Tree familyTree = new Tree();
        familyTree.addItem("Families");
        familyTree.addItem("The Jacksons");
        familyTree.addItem("The Simpsons");
        familyTree.addItem("The Rothschilds");
        familyTree.addItem("The Hapsburgs");
        familyTree.addItem("The Addams");

        familyTree.setParent("The Jacksons", "Families");
        familyTree.setParent("The Simpsons", "Families");
        familyTree.setParent("The Rothschilds", "Families");
        familyTree.setParent("The Hapsburgs", "Families");
        familyTree.setParent("The Addams", "Families");


        familyTree.setChildrenAllowed("The Jackson", false);
        familyTree.setChildrenAllowed("The Simpsons", false);
        familyTree.setChildrenAllowed("The Rothschilds", false);
        familyTree.setChildrenAllowed("The Hapsburgs", false);
        familyTree.setChildrenAllowed("The Addams", false);


        vl.addComponent(familyTree);
        setContent(vl);
}
}

