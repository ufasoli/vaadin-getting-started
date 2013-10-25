package com.trivadis.com.trivadis.ch6.tretables.ui;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.util.FilesystemContainer;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinService;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.TreeTable;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import javax.servlet.annotation.WebServlet;
import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: Ulises Fasoli
 * Date: 24.10.13
 * Time: 08:44
 */
public class TreetableUI extends UI {


    @WebServlet(urlPatterns = {"/ch6/treetable/*", "/VAADIN/*"})
    @VaadinServletConfiguration(productionMode = false, ui = TreetableUI.class, widgetset = "com.trivadis.AppWidgetSet")
    public static class TreeTableServlet extends VaadinServlet {

    }

    @Override
    protected void init(VaadinRequest request) {
      final VerticalLayout vl = new VerticalLayout();
        vl.setMargin(true);

        setContent(vl);

        // file instance to where the application has been deployed
        File folder = VaadinService.getCurrent().getBaseDirectory();
        FilesystemContainer fsContainer = new FilesystemContainer(folder);

        TreeTable treetable = new TreeTable();
        treetable.setContainerDataSource(fsContainer);
        treetable.setSizeFull();

        vl.addComponent(treetable);

    }
}
