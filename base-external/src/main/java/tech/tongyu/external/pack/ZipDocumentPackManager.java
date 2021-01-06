package tech.tongyu.external.pack;

import org.springframework.stereotype.Component;
import tech.tongyu.core.utils.zip.ZipUtil;

import java.io.File;
import java.io.OutputStream;
import java.util.List;

/**
 * @author kezhenye
 * - mailto: kezhenye@tongyu.tech
 * @description 生成xml
 **/
@Component
public class ZipDocumentPackManager {

    public static void toZip(List<File> srcFiles, OutputStream out) {
        ZipUtil.toZip(srcFiles, out);
    }

    public static void unZip(File srcFile, String destDirPath) {
        ZipUtil.unZip(srcFile, destDirPath);
    }
}
