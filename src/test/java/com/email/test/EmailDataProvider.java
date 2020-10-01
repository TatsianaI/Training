package com.email.test;

import org.testng.annotations.DataProvider;

public class EmailDataProvider {

    private final String FILE_PATH = "src/test/resources/emails.csv";

    @DataProvider(name = "emailProvider")
    public Object[][] getEmailFromFile() {
    EmailDataReader emailData = new EmailDataReader();
        return emailData.readDataFromCsvFile(FILE_PATH);
    }
}
