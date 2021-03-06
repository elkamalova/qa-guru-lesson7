package tests;


import net.lingala.zip4j.exception.ZipException;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static utils.Files.readTextFromPath;
import static utils.Zip.unzip;

public class ZipFileTests {
    @Test
    void zipWithPasswordTest() throws IOException, ZipException {
        String zipFilePath = "./src/test/resources/files/1_withPass.zip";
        String unzipFolderPath = "./src/test/resources/files/unzipWithPass";
        String zipPassword = "password";
        String unzipTxtFilePath = "./src/test/resources/files/unzipWithPass/1.txt";
        String expectedData = "Lesson_7";

        unzip(zipFilePath, unzipFolderPath, zipPassword);

        String actualData = readTextFromPath(unzipTxtFilePath);

        assertThat(actualData, containsString(expectedData));
    }

    @Test
    void zipTest() throws IOException, ZipException {
        String zipFilePath = "./src/test/resources/files/1_withoutPass.zip";
        String unzipFolderPath = "./src/test/resources/files/unzipWithoutPass";
        String unzipTxtFilePath = "./src/test/resources/files/unzipWithoutPass/1.txt";
        String expectedData =  "Lesson";

        unzip(zipFilePath, unzipFolderPath);

        String actualData = readTextFromPath(unzipTxtFilePath);

        assertThat(actualData, containsString(expectedData));
    }

}
