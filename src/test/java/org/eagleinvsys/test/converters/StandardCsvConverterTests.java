package org.eagleinvsys.test.converters;

import org.eagleinvsys.test.converters.impl.CsvConverter;
import org.eagleinvsys.test.converters.impl.StandardCsvConverter;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import static org.junit.Assert.assertEquals;

public class StandardCsvConverterTests {

    CsvConverter csvConverter = new CsvConverter();
    StandardCsvConverter standardCsvConverter = new StandardCsvConverter(csvConverter);

    @Test
    public void testStandardCsvConverter() throws IOException {

        // Тest ouputStream
        FileOutputStream outputStream = new FileOutputStream("standardCsvConverterTest.csv");

        // Writing test data to file
        standardCsvConverter.convert(this.getCollection1(), outputStream);

        outputStream.close();

        byte[] fileContent = Files.readAllBytes(Paths.get("standardCsvConverterTest.csv"));

        Assert.assertArrayEquals(fileContent, this.getCollection1Bytes());
    }

    // Тестовые данные
    private List<Map<String, String>> getCollection1() {
        List<Map<String, String>> records = new ArrayList<>();
        Map<String, String> message1 = new TreeMap<String, String>() {{
            put("age", "45");
            put("name", "John");
            put("surname", "Galt");
        }};
        records.add(message1);
        Map<String, String> message2 = new TreeMap<String, String>() {{
            put("age", "35");
            put("name", "Dagny");
            put("surname", "Taggart");
        }};
        records.add(message2);
        return records;
    }

    private byte[] getCollection1Bytes() {
        return new byte[] {34, 97, 103, 101, 34, 44, 34, 110, 97, 109, 101, 34, 44, 34, 115, 117, 114, 110, 97, 109, 101, 34, 10, 34, 52, 53, 34, 44, 34, 74, 111, 104, 110, 34, 44, 34, 71, 97, 108, 116, 34, 10, 34, 51, 53, 34, 44, 34, 68, 97, 103, 110, 121, 34, 44, 34, 84, 97, 103, 103, 97, 114, 116, 34, 10};
    }
}