package com.tyning.nothing.velocity;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.apache.velocity.exception.VelocityException;
import org.apache.velocity.runtime.resource.loader.StringResourceLoader;
import org.apache.velocity.runtime.resource.util.StringResourceRepository;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class VelocityUtil {

    public static void main(String[] args) throws IOException {
        VelocityEngine velocityEngine = new VelocityEngine();
        velocityEngine.setProperty(Velocity.RESOURCE_LOADER, "string");
        velocityEngine.addProperty("string.resource.loader.class", StringResourceLoader.class.getName());
        velocityEngine.addProperty("string.resource.loader.repository.static", "false");
        velocityEngine.init();
        StringResourceRepository repository = (StringResourceRepository) velocityEngine.getApplicationAttribute(StringResourceLoader.REPOSITORY_NAME_DEFAULT);
        String myTemplateName = "goodsStoragePrint";

        String myTemplate = "$name";
        repository.putStringResource(myTemplateName, myTemplate);
        try {
            Map<String, Object> model = new HashMap<>();
            model.put("name", "dsafdsafdas");
            System.out.println(mergeTemplateIntoString(velocityEngine, "21", "UTF-8", model));
        } catch (ResourceNotFoundException rnfe) {
            System.out.println("cannot find template ");
        } catch (ParseErrorException pee) {
            System.out.println("Example : Syntax error in template " + ":" + pee);
        } catch (Exception e) {
            System.out.println("Example : Syntax error in template " + ":dfsafdasfdsa");
        }
    }

    public static void mergeTemplate(VelocityEngine velocityEngine, String templateLocation, String encoding, Map<String, Object> model, Writer writer) throws VelocityException {
        VelocityContext velocityContext = new VelocityContext(model);
        velocityEngine.mergeTemplate(templateLocation, encoding, velocityContext, writer);
    }


    public static String mergeTemplateIntoString(VelocityEngine velocityEngine, String templateLocation, String encoding, Map<String, Object> model) throws VelocityException {
        StringWriter result = new StringWriter();
        mergeTemplate(velocityEngine, templateLocation, encoding, model, result);
        return result.toString();
    }


}
