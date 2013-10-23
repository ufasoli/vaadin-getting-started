package com.trivadis.com.trivadis.ch5.tables.boxword.ui;

import com.google.gwt.thirdparty.guava.common.collect.Tables;
import com.trivadis.com.trivadis.ch5.tables.boxword.model.Game;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.Property;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.*;

import javax.servlet.annotation.WebServlet;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: Ulises Fasoli
 * Date: 23.10.13
 * Time: 10:12
 */
public class BoxwordUI extends UI implements ItemClickEvent.ItemClickListener {
    private Game game = new Game(5);
    private Table table = new Table();
    private VerticalLayout messagesLayout = new VerticalLayout();
    private Label currentLetter = new Label("", ContentMode.HTML);

    @WebServlet(urlPatterns = {"/ch5/tables/boxword/*", "/VAADIN/*"})
    @VaadinServletConfiguration(productionMode = false, ui = BoxwordUI.class, widgetset = "com.trivadis.AppWidgetSet")
    public static class BoxwordServlet extends VaadinServlet {

    }

    @Override
    protected void init(VaadinRequest vaadindRequest) {
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.setMargin(true);
        horizontalLayout.setSpacing(true);

        setContent(horizontalLayout);


        table.setPageLength(0);  // show all the rows with no scrollbar
        table.setColumnHeaderMode(Table.ColumnHeaderMode.HIDDEN);
        table.addItemClickListener(this);

        for (int column = 0; column < game.getSize(); column++) {
            table.addContainerProperty(column, String.class, ".");
        }


        for (int row = 0; row < game.getSize(); row++) {
            table.addItem(row);
        }

        horizontalLayout.addComponent(table);

        messagesLayout.addComponent(currentLetter);
        horizontalLayout.addComponent(messagesLayout);

        nextTurn();
    }

    private void nextTurn() {

        if (game.over()) {
            gameOver();
        } else {
            currentLetter.setValue("Next letter : " + game.nextLetter());
        }
    }

    private void gameOver() {

        Collection<String> words = getWords();

        currentLetter.setValue("You scored :" + game.getScore(words));

        messagesLayout.addComponent(new Label("Words :"));

        for (String word : words) {
            String link = "http://www.merriamwebster.com/dictionary/" + word.toLowerCase();

            // The following is not a good implementation.
            // Next chapter we will see how to get rid of this ugly HTML.
            String anchor = "<a href='" + link
                    + "' target='_blank' style='margin-left: 10px;'>"
                    + word.toLowerCase() + "</a>";
            messagesLayout
                    .addComponent(new Label(anchor, ContentMode.HTML));
        }
    }

    @Override
    public void itemClick(ItemClickEvent event) {

        // for a table cell is the same thing as a property
        // Item --> row
        // Propery --> cell
        Property property = event.getItem().getItemProperty(event.getPropertyId());

        if (".".equals(property.getValue())) {
            property.setValue(game.getCurrentLetter());
            nextTurn();
        } else {
            Notification.show("You Must select an empty cell");
        }
    }

    private Collection<String> getWords() {
        ArrayList<String> words = new ArrayList<String>();

        for (int row = 0; row < game.getSize(); row++) {
            String line = "";

            for (int col = 0; col < game.getSize(); col++) {
                line += table.getItem(row).
                        getItemProperty(col).getValue();
            }

            words.addAll(game.getWords(line));
        }

        for (int column = 0; column < game.getSize(); column++) {
            String line = "";
            for (int row = 0; row < game.getSize(); row++) {
                line += table.getItem(row).getItemProperty(column).getValue();
            }
            words.addAll(game.getWords(line));
        }
        return words;
    }
}



