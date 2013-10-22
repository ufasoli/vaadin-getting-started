package com.trivadis.com.trivadis.ch3.layouts.main.ui;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.event.LayoutEvents;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;

import javax.servlet.annotation.WebServlet;

/**
 * Created with IntelliJ IDEA.
 * User: Ulises Fasoli
 * Date: 22.10.13
 * Time: 13:15
 */
public class MainLayoutUI extends UI {

    @WebServlet(urlPatterns = {"/ch3/mainlayout/*", "/VAADIN/*"})
    @VaadinServletConfiguration(productionMode = false, ui = MainLayoutUI.class, widgetset = "com.trivadis.AppWidgetSet")
    public static class MainLayoutServlet extends VaadinServlet {

    }

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        MainLayout ml = new MainLayout();
        ml.addMenuOption("Option 1", new Label("Component 1"));
        ml.addMenuOption("Option 2", new Label("Component 2"));

        ml.setHeader("Layout UI");

        ml.addMenuOption("Grid layout", getGridLayout());
        ml.addMenuOption("Absolute Layout", getAbsoluteLayout());
        ml.addMenuOption("Click listener", getClickListener());
        ml.addMenuOption("Form Layout", getFormLayout());
        ml.addMenuOption("Panel", getPanel());
        ml.addMenuOption("Tabsheet", getTabSheet());

        setContent(ml);
    }

    private Panel getPanel() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 2000; i++) {
            sb.append(" ");
            sb.append(i);
        }

        Label content = new Label(sb.toString());
        Panel panel = new Panel("Panel's caption", content);
        panel.setWidth("200px");
        panel.setHeight("100px");
        panel.setScrollTop(3000);//pixels from top


        return panel;
    }


    private Component getClickListener() {
        VerticalLayout vl = new VerticalLayout();
        vl.setSizeFull();
        vl.addLayoutClickListener(new LayoutEvents.LayoutClickListener() {
            @Override
            public void layoutClick(LayoutEvents.LayoutClickEvent layoutClickEvent) {
                String msg = String.format(
                        "You clicked me; and u did it at %sx : %sy using the %s button",
                        layoutClickEvent.getClientX(),
                        layoutClickEvent.getClientY(),
                        layoutClickEvent.getButtonName()
                );
                Notification.show(msg, Notification.Type.TRAY_NOTIFICATION);
            }
        });

        return vl;
    }

    private Component getAbsoluteLayout() {
        Button button = new Button("I'm whismically located at 42,57");
        AbsoluteLayout absoluteLayout = new AbsoluteLayout();
        absoluteLayout.addComponent(button, "left:42px; top:57px;");

        return absoluteLayout;
    }

    private GridLayout getGridLayout() {
        int rows = 3, columns = 3;
        GridLayout gridLayout = new GridLayout(columns, rows);
        gridLayout.setSizeFull();

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                Button btn = new Button("-_-");

                btn.addClickListener(new Button.ClickListener() {
                    @Override
                    public void buttonClick(Button.ClickEvent clickEvent) {
                        if (clickEvent.getButton().getCaption().equals("-_-")) {
                            clickEvent.getButton().setCaption("°_°");
                        } else {
                            clickEvent.getButton().setCaption("-_-");
                        }
                    }
                });

                gridLayout.addComponent(btn);
            }
        }

        return gridLayout;
    }

    private FormLayout getFormLayout() {
        TextField tf1 = new TextField("TextField");
        TextField tf2 = new TextField("TextField");
        ComboBox cb = new ComboBox("Combobox");
        Button b = new Button("button");

        FormLayout formLayout = new FormLayout(tf1, tf2, cb, b);
        formLayout.setMargin(true);

        return formLayout;
    }


    private TabSheet getTabSheet() {

        TabSheet ts = new TabSheet();
        ts.addTab(new Label("Label 1"), "tab1");
        ts.addTab(new Label("Label 1")).setCaption("tab2");
        ts.addTab(new Label("Label 3"), "tab3").setClosable(true);

        ts.addSelectedTabChangeListener(new TabSheet.SelectedTabChangeListener() {
            @Override
            public void selectedTabChange(TabSheet.SelectedTabChangeEvent selectedTabChangeEvent) {
                Notification.show(String.format("You are watching : " + selectedTabChangeEvent.getTabSheet().getSelectedTab()));
            }
        });
        return ts;
    }

}
