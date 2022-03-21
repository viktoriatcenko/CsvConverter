package org.eagleinvsys.test.converters.impl;

import org.eagleinvsys.test.converters.ConvertibleCollection;
import org.eagleinvsys.test.converters.ConvertibleMessage;
import org.eagleinvsys.test.converters.StandardConverter;

import java.io.OutputStream;
import java.util.*;

public class StandardCsvConverter implements StandardConverter {

    private final CsvConverter csvConverter;

    public StandardCsvConverter(CsvConverter csvConverter) {
        this.csvConverter = csvConverter;
    }

    /**
     * Converts given {@link List<Map>} to CSV and outputs result as a text to the provided {@link OutputStream}
     *
     * @param collectionToConvert collection to convert to CSV format. All maps must have the same set of keys
     * @param outputStream        output stream to write CSV conversion result as text to
     */
    @Override
    public void convert(List<Map<String, String>> collectionToConvert, OutputStream outputStream) {

        // Making ConvertibleCollection from first method arg
        Set<String> headers = new HashSet<>();

        // Transforming Map into ConvertibleMessage collection
        List<ConvertibleMessage> records = new ArrayList<>();

        int iterator = 0;
        for (Map<String, String> rawMessage : collectionToConvert) {

            // Using iterator to fetch headers just once
            if (iterator == 0) {
                headers = rawMessage.keySet();
            }

            ConvertibleMessage message = new ConvertibleMessageImpl(rawMessage);
            records.add(message);
            iterator++;
        }

        // Creating ConvertibleCollection object
        ConvertibleCollection collection = new ConvertibleCollectionImpl(headers, records);

        // Converting
        this.csvConverter.convert(collection, outputStream);
    }

}