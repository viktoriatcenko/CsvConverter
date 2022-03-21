package org.eagleinvsys.test.converters.impl;

import org.eagleinvsys.test.converters.ConvertibleMessage;
import org.eagleinvsys.test.converters.ConvertibleCollection;
import java.util.Collection;

public class ConvertibleCollectionImpl implements ConvertibleCollection {

    private Collection<String> headers;
    private Iterable<ConvertibleMessage> records;

    public ConvertibleCollectionImpl(Collection<String> headers, Iterable<ConvertibleMessage> records) {
        this.headers = headers;
        this.records = records;
    }

    public Collection<String> getHeaders() {
        return headers;
    }

    public Iterable<ConvertibleMessage> getRecords() {
        return records;
    }
}
