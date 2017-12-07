package com.tyning.nothing.itext;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.*;

import java.io.FileOutputStream;
import java.io.IOException;

public class ItextAddFieldUtil {

    public static void manipulatePdfPushbuttonField(byte[] srcbytes, String dest) throws DocumentException, IOException, NullPointerException {
        PdfReader reader = new PdfReader(srcbytes);
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
        PushbuttonField button = new PushbuttonField(
                stamper.getWriter(), new Rectangle(36, 700, 72, 730), "post");
        button.setText("POST");
        button.setBackgroundColor(new GrayColor(0.7f));
        button.setVisibility(PushbuttonField.VISIBLE_BUT_DOES_NOT_PRINT);
        PdfFormField submit = button.getField();
        submit.setAction(PdfAction.createSubmitForm(
                "http://itextpdf.com:8180/book/request", null,
                PdfAction.SUBMIT_HTML_FORMAT | PdfAction.SUBMIT_COORDINATES));
        stamper.addAnnotation(submit, 1);
        stamper.close();

    }

    public static void manipulatePdfText(byte[] srcbytes, String dest) throws IOException, DocumentException, NullPointerException {
        PdfReader reader = new PdfReader(srcbytes);
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
        PdfWriter writer = stamper.getWriter();
        PdfFormField personal = PdfFormField.createEmpty(writer);
        personal.setFieldName("personal");
        TextField name = new TextField(writer, new Rectangle(36, 760, 144, 790), "name");
        PdfFormField personal_name = name.getTextField();
        personal.addKid(personal_name);
        TextField password = new TextField(writer, new Rectangle(150, 760, 450, 790), "password");
        PdfFormField personal_password = password.getTextField();
        personal.addKid(personal_password);
        stamper.addAnnotation(personal, 1);
        stamper.close();
        reader.close();
    }

}
