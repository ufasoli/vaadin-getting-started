package com.trivadis.com.trivadis.ch2.timeit.ui;

import com.trivadis.com.trivadis.ch2.timeit.biz.TestSet;
import com.trivadis.com.trivadis.ch2.timeit.biz.TestSetExecutor;
import com.trivadis.com.trivadis.ch2.timeit.biz.test.LongVsInt;
import com.trivadis.com.trivadis.ch2.timeit.biz.test.ShortCircuitVsNoShortCircuit;
import com.trivadis.com.trivadis.ch2.timeit.biz.test.StringVsStringBuffer;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.Property;
import com.vaadin.server.UserError;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;
import com.vaadin.ui.Label;

import javax.servlet.annotation.WebServlet;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: Ulises Fasoli
 * Date: 21.10.13
 * Time: 14:52
 */
public class TimeItUI extends UI {

    @WebServlet(value = {"/ch2/timeit/*", "/VAADIN/*"}, asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = TimeItUI.class, widgetset = "com.trivadis.AppWidgetSet")
    public static class TimeItServlet extends VaadinServlet {
    }


    private final static TestSet[] testSets = new TestSet[]{
            new LongVsInt(),
            new StringVsStringBuffer(),
            new ShortCircuitVsNoShortCircuit()
    };

    private VerticalLayout layout = new VerticalLayout();
    private ComboBox combo = new ComboBox("Test");
    private final TextField textField = new TextField("Number of iterations", "1000");
    private CheckBox checkBox = new CheckBox("Keeps previous results");
    private Button button = new Button("Time it!");
    private VerticalLayout resultsLayout = new VerticalLayout();


    @Override
    protected void init(VaadinRequest vaadinRequest) {
        System.out.println("CALLING INIT on class : " + TimeItUI.class);
        initCombo();
        initButton();
        initLayout();
    }


    private void initCombo() {
        for (TestSet testSet : testSets) {
            combo.addItem(testSet);
            combo.setItemCaption(testSet, testSet.getTitle());

        }

        combo.addValueChangeListener(new ComboBox.ValueChangeListener() {

            @Override
            public void valueChange(Property.ValueChangeEvent valueChangeEvent) {

                TestSet testSet = (TestSet) combo.getValue();
                textField.setValue("" + testSet.getDefaultTimes());
                button.setDescription(testSet.getDescription());
            }
        });

        combo.setImmediate(true);

    }

    private void initButton() {

        button.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                if (validate()) {
                    runSelectedTest();
                }
            }
        });

        layout.addComponent(button);
    }

    private void initLayout() {
        layout.setMargin(true);
        layout.setSpacing(true);
        layout.addComponent(combo);
        layout.addComponent(textField);
        layout.addComponent(checkBox);
        layout.addComponent(button);
        layout.addComponent(resultsLayout);
        setContent(layout);
    }

    public boolean validate() {

        combo.setComponentError(null);
        textField.setComponentError(null);

        boolean isValid = true;

        if (combo.getValue() == null) {
            combo.setComponentError(new UserError("Select a test from the list"));
            isValid = false;
        }

        if (textField.getValue().isEmpty()) {
            textField.setComponentError(new UserError("You must introduce the number of iteratons"));
        }

        return isValid;
    }

    public void runSelectedTest() {

        try {

            Long times = Long.parseLong(textField.getValue());

            Collection<String> results = TestSetExecutor.execute((TestSet) combo.getValue(), times);
            showResults(results);
        } catch (NumberFormatException ne) {
            textField.setComponentError(new UserError(
                    String.format("The value of iterations must be a number but was : %s", textField.getValue())));
        }

    }

    private void showResults(Collection<String> results) {

        // if we don't keep previous results, remove all components
        if(!checkBox.getValue()){
           resultsLayout.removeAllComponents();
        }
        else {
            resultsLayout.addComponent(new Label("----"));
        }

        for (String result : results){
            resultsLayout.addComponent(new Label(result));
        }
    }

}
