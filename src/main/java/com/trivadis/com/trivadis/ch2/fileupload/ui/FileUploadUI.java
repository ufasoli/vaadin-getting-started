package com.trivadis.com.trivadis.ch2.fileupload.ui;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.shared.ui.datefield.Resolution;
import com.vaadin.ui.DateField;
import com.vaadin.ui.UI;
import com.vaadin.ui.Upload;
import com.vaadin.ui.VerticalLayout;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created with IntelliJ IDEA.
 * User: Ulises Fasoli
 * Date: 22.10.13
 * Time: 11:07
 */
public class FileUploadUI extends UI implements Upload.Receiver {


    @WebServlet(urlPatterns = {"/ch2/upload/*", "/VAADIN/*"})
    @VaadinServletConfiguration(productionMode = false, ui = FileUploadUI.class, widgetset = "com.trivadis.AppWidgetSet")
    public static class FileUploadServlet extends VaadinServlet {

    }


    @Override
    protected void init(VaadinRequest vaadinRequest) {

        Upload upload = new Upload("select a text file and look at the console", this);

        VerticalLayout vl = new VerticalLayout();
        vl.addComponent(upload);

        setContent(vl);


    }


    @Override
    public OutputStream receiveUpload(String s, String s2) {
        return new OutputStream() {
            @Override
            public void write(int b) throws IOException {
                System.out.println((char) b);
            }
        };
    }

}
