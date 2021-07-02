package tests;

import org.junit.jupiter.api.Test;

import java.io.IOException;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static utils.Files.*;

public class DocFileTests {
    @Test
    void docTest() throws IOException {
        String docFilePath = "./src/test/resources/files/1.doc";
        String expectedData = "Lesson_7";
        String actualData = readDocFile(docFilePath);
        assertThat(actualData, containsString(expectedData));
    }

    @Test
    void docxTest() throws IOException {
        String docxFilePath = "./src/test/resources/files/1.docx";
        String expectedData = "Lesson_7";
        String actualData = readDocxFile(docxFilePath);
        assertThat(actualData, containsString(expectedData));

    }
}
