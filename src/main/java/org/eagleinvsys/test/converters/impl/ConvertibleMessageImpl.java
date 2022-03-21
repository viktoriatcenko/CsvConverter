package org.eagleinvsys.test.converters.impl;

import java.util.Map;
import org.eagleinvsys.test.converters.ConvertibleMessage;

public class ConvertibleMessageImpl implements ConvertibleMessage {

    private Map<String, String> elements;

    public ConvertibleMessageImpl(Map<String, String> elements) {
        this.elements = elements;
    }

    public String getElement(String elementId) {
        return elements.get(elementId);
    }
}
