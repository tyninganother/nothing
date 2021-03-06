package gui.ava.html.link;

import javax.swing.*;
import javax.swing.text.*;
import javax.swing.text.html.HTML;
import java.awt.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * @author Yoav Aharoni
 */
public class LinkHarvester {
    private final JTextComponent textComponent;
    private final List<LinkInfo> links = new ArrayList<LinkInfo>();

    public LinkHarvester(JEditorPane textComponent) {
        this.textComponent = textComponent;
        harvestElement(textComponent.getDocument().getDefaultRootElement());
    }

    public List<LinkInfo> getLinks() {
        return links;
    }

    private void harvestElement(Element element) {
        if (element == null) {
            return;
        }

        final AttributeSet attributes = element.getAttributes();
        final Enumeration<?> attributeNames = attributes.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            final Object key = attributeNames.nextElement();
            if (HTML.Tag.A.equals(key)) {
                final Object value = attributes.getAttribute(key);
                if (value instanceof SimpleAttributeSet) {
                    final SimpleAttributeSet attributeSet = (SimpleAttributeSet) value;
                    final String href = (String) attributeSet.getAttribute(HTML.Attribute.HREF);
                    final String title = (String) attributeSet.getAttribute(HTML.Attribute.TITLE);
                    final List<Rectangle> bounds = elementBounds(element);
                    links.add(new LinkInfo(href, title, bounds));
                }
            }
        }

        for (int i = 0; i < element.getElementCount(); i++) {
            final Element child = element.getElement(i);
            harvestElement(child);
        }
    }

    private List<Rectangle> elementBounds(Element element) {
        final List<Rectangle> bounds = new ArrayList<Rectangle>();
        try {
            final int startOffset = element.getStartOffset();
            final int endOffset = element.getEndOffset();
            Rectangle rectangle = textComponent.modelToView(startOffset);
            for (int i = startOffset + 1; i <= endOffset; i++) {
                final Rectangle temp = textComponent.modelToView(i);
                if (temp.getY() == rectangle.getY()) {
                    rectangle = rectangle.union(temp);
                } else {
                    bounds.add(rectangle);
                    rectangle = null;
                }
            }
            if (rectangle != null) {
                bounds.add(rectangle);
            }
            return bounds;
        } catch (BadLocationException e) {
            throw new RuntimeException("Got BadLocationException", e);
        }
    }
}
