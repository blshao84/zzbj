package tech.tongyu.entrance.api;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;
import tech.tongyu.core.exceptions.CustomCommonException;
import tech.tongyu.core.exceptions.CustomErrorMessage;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.net.URLEncoder;

/**
 * @author wuyongbin
 * - mailto: wuyongbin@tongyu.tech
 * @description zip文档相关API
 **/
@RestController
@RequestMapping("/zip")
public class ZipApi {

    @GetMapping(value = "generate")
    public void download(@RequestParam("path") String path,
                         @RequestParam("fileName") String fileName,
                       HttpServletResponse response) {
        try {
            Resource file = new FileSystemResource(path);
            if (!file.exists()) {
                throw new CustomCommonException(CustomErrorMessage.Errors.FILE_NOT_FOUND);
            }
            response.reset();
            String contentDisposition = "file;filename*=UTF-8''" + URLEncoder.encode(fileName, "UTF-8");
            response.addHeader("Content-Disposition", contentDisposition);
            response.setContentType("application/octet-stream");
            response.setCharacterEncoding("UTF-8");
            response.setContentLengthLong(file.contentLength());
            byte[] bytes = new byte[4096];
            byte[] result = (byte[]) Array.newInstance(byte.class, new Long(file.contentLength()).intValue());
            int count;
            int counter = 0;
            OutputStream os = response.getOutputStream();
            InputStream inputStream = file.getInputStream();
            while ((count = inputStream.read(bytes)) != -1) {
                System.arraycopy(bytes, 0, result, 4096 * counter, count);
                counter++;
            }
            os.write(result);
            os.flush();
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomCommonException(CustomErrorMessage.Errors.FILE_DOWNLOAD_ERROR);
        }
    }

}
