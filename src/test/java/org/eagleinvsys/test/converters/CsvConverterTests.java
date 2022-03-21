package org.eagleinvsys.test.converters;

import org.eagleinvsys.test.converters.impl.ConvertibleCollectionImpl;
import org.eagleinvsys.test.converters.impl.ConvertibleMessageImpl;
import org.eagleinvsys.test.converters.impl.CsvConverter;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class CsvConverterTests {

    CsvConverter converter = new CsvConverter();

    @Test
    public void testCsvConverter() throws IOException {

        // Test ouputStream
        FileOutputStream outputStream = new FileOutputStream("csvConverterTest.csv");

        // Writing test data to file
        converter.convert(this.getCollection1(), outputStream);

        outputStream.close();

        byte[] fileContent = Files.readAllBytes(Paths.get("csvConverterTest.csv"));

        Assert.assertArrayEquals(fileContent, this.getCollection1Bytes());
    }

    // Тестовые данные
    private ConvertibleCollection getCollection1() {
        List<String> headers = Arrays.asList("age", "name", "surname");
        List<ConvertibleMessage> records = new ArrayList<>();
        ConvertibleMessage message1 = new ConvertibleMessageImpl(new HashMap<String, String>() {{
            put("age", "45");
            put("name", "John");
            put("surname", "Galt");
        }});
        records.add(message1);
        ConvertibleMessage message2 = new ConvertibleMessageImpl(new HashMap<String, String>() {{
            put("age", "35");
            put("name", "Dagny");
            put("surname", "Taggart");
        }});
        records.add(message2);
        return new ConvertibleCollectionImpl(headers, records);
    }

    private byte[] getCollection1Bytes() {
        return new byte[] {34, 97, 103, 101, 34, 44, 34, 110, 97, 109, 101, 34, 44, 34, 115, 117, 114, 110, 97, 109, 101, 34, 10, 34, 52, 53, 34, 44, 34, 74, 111, 104, 110, 34, 44, 34, 71, 97, 108, 116, 34, 10, 34, 51, 53, 34, 44, 34, 68, 97, 103, 110, 121, 34, 44, 34, 84, 97, 103, 103, 97, 114, 116, 34, 10};
    }
}