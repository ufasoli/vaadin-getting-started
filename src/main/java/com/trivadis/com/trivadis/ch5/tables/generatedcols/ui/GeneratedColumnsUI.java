package com.trivadis.com.trivadis.ch5.tables.generatedcols.ui;

import com.trivadis.com.trivadis.ch5.tables.fieldfactory.util.UserFieldFactory;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.Property;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Table;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import javax.servlet.annotation.WebServlet;

/**
 * Created with IntelliJ IDEA.
 * User: Ulises Fasoli
 * Date: 23.10.13
 * Time: 10:12
 */
public class GeneratedColumnsUI extends UI {


    @WebServlet(urlPatterns = {"/ch5/tables/generated_columns/*", "/VAADIN/*"})
    @VaadinServletConfiguration(productionMode = false, ui = GeneratedColumnsUI.class, widgetset = "com.trivadis.AppWidgetSet")
    public static class GeneratedColumnsServlet extends VaadinServlet {

    }

    @Override
    protected void init(VaadinRequest vaadinRequest) {
     final VerticalLayout vl = new VerticalLayout();
        vl.setMargin(true);
        setContent(vl);

        Table table = new Table("Addition"){
            @Override
            protected String formatPropertyValue(Object rowId, Object colId, Property<?> property) {
                Integer n = (Integer) property.getValue();

                if(n < 0){
                             return "("+n+")";
                }
                else{
                    return ""+n;
                }
            }
        };
        table.addContainerProperty("A", Integer.class, 0);
        table.addContainerProperty("B", Integer.class, 0);
         table.setColumnReorderingAllowed(true);
        table.setColumnCollapsingAllowed(true);
        table.setColumnCollapsible("A+B", false);


        table.setPageLength(0);
        table.addItem(new Object[]{1,1}, null);
        table.addItem(new Object[]{10,3}, null);
        table.addItem(new Object[]{-5,6}, null);

        table.addGeneratedColumn("A+B", new Table.ColumnGenerator() {
            @Override
            public Object generateCell(Table source, Object itemId, Object columnId) {
                return ((Integer)source.getItem(itemId).getItemProperty("A").getValue() +
                        (Integer)source.getItem(itemId).getItemProperty("B").getValue());
            }
        });

        vl.addComponent(table);
    }
}
