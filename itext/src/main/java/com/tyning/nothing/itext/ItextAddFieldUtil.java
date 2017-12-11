package com.tyning.nothing.itext;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.*;

import java.io.FileOutputStream;
import java.io.IOException;

public class ItextAddFieldUtil {

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
