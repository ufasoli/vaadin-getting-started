package com.trivadis.com.trivadis.ch5.tables.fieldfactory.util;

import com.vaadin.data.Container;
import com.vaadin.ui.*;

/**
 * Created with IntelliJ IDEA.
 * User: Ulises Fasoli
 * Date: 23.10.13
 * Time: 12:56
 */
public class UserFieldFactory implements TableFieldFactory {
    @Override
    public Field<?> createField(Container container, Object itemId, Object propertyId, Component uiContext) {
        if("Password".equals(propertyId)){
            return new PasswordField();
        }

        return new TextField();
    }
}
