package org.eagleinvsys.test.converters.impl;

import com.opencsv.CSVWriter;
import org.eagleinvsys.test.converters.Converter;
import org.eagleinvsys.test.converters.ConvertibleCollection;
import org.eagleinvsys.test.converters.ConvertibleMessage;

import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class CsvConverter implements Converter {

    /**
     * Converts given {@link ConvertibleCollection} to CSV and outputs result as a text to the provided {@link OutputStream}
     *
     * @param collectionToConvert collection to convert to CSV format
     * @param outputStream        output stream to write CSV conversion result as text to
     */
    @Override
    public void convert(ConvertibleCollection collectionToConvert, OutputStream outputStream) {
        try {
            // Using OpenCSV lib
            CSVWriter writer = new CSVWriter(new OutputStreamWriter(outputStream));

            // Making headers array and writing it down as a first CSV file line
            String[] headers = collectionToConvert.getHeaders().toArray(new String[0]);
            writer.writeNext(headers);

            // Writing down other lines
            for (ConvertibleMessage message : collectionToConvert.getRecords()) {

                String[] elements = new String[headers.length];
                for (int i = 0; i < headers.length; i++) {
                    elements[i] = message.getElement(headers[i]);
                }
                writer.writeNext(elements);
            }

            writer.close();
        } catch (Exception e) {
            System.out.println("Error occured while converting to CSV..." + e);
        }
    }

}