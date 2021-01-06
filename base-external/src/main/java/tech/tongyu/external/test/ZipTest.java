package tech.tongyu.external.test;

import org.junit.jupiter.api.Test;
import tech.tongyu.external.pack.ZipDocumentPackManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ZipTest {
    @Test
    public void zipTest() throws FileNotFoundException {
        List<File> fileList = new ArrayList<>();
        fileList.add(new File("test.xml"));
        //fileList.add(new File("test2.xml"));
        FileOutputStream fos = new FileOutputStream(new File("mytest.zip"));

        ZipDocumentPackManager.toZip(fileList, fos);
    }

    @Test
    public void unzipTest() {
        ZipDocumentPackManager.unZip(new File("mytest.zip"), "./xml");
    }
}
