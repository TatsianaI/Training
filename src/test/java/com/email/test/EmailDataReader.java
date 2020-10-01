package com.email.test;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class EmailDataReader {

    public Object[][] readDataFromCsvFile(String path) {
        try {
            return parseCsvAndConvertToArray(path);
        } catch (IOException e) {
            e.printStackTrace();
            return new Object[0][0];
        }
    }

    private Object[][] parseCsvAndConvertToArray(String path) throws IOException {
        Reader in = new FileReader(path);
        List<CSVRecord> records =
                CSVFormat.DEFAULT
                        .parse(in)
                        .getRecords();

        Object[][] result = new Object[records.size()][];
        for (int i = 0; i < records.size(); i++) {
            CSVRecord r = records.get(i);
            result[i] = recordToArray(r);
        }

        return result;
    }

    private Object[] recordToArray(CSVRecord r) {
        Object[] result = new Object[r.size()];
        for (int i = 0; i < r.size(); i++) {
            result[i] = r.get(i);
        }
        return result;
    }
}
