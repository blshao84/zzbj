package tech.tongyu.core.utils;

import tech.tongyu.core.exceptions.CustomException;

import java.io.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.*;

public class ZipUtil {

    /** 缓冲器大小 */
    private static final int BUFFER = 512;

    /**
     * 得到源文件路径的所有文件
     * @param dirFile 压缩源文件路径
     * */
    public static List<File> getAllFile(File dirFile){
        List<File> fileList=new ArrayList<>();
        File[] files= dirFile.listFiles();
        for(File file:files){
            if(file.isFile()){
                fileList.add(file);
                System.out.println("add file:"+file.getName());
            }else {
                if(file.listFiles().length!=0){
                    fileList.addAll(getAllFile(file));
                }else {
                    fileList.add(file);
                    System.out.println("add empty dir:"+file.getName());
                }
            }
        }
        return fileList;
    }

    /**
     * 获取相对路径
     * @param dirPath 源文件路径
     * @param file 准备压缩的单个文件
     * */
    public static String getRelativePath(String dirPath,File file){
        File dirFile=new File(dirPath);
        String relativePath=file.getName();

        while (true){
            file=file.getParentFile();
            if(file==null) {
                break;
            }
            if(file.equals(dirFile)){
                break;
            }
            else {
                relativePath=file.getName()+"/"+relativePath;
            }
        }
        return relativePath;
    }

    /**
     * 解压zip文件
     *
     * @param zipFile
     * @param unzipFilePath 解压后存放的路径
     * @return 返回解压的路径文件夹
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public static String unzip(File zipFile, String unzipFilePath) throws Exception {
        String unzipPath = "";
        //判断文件是否存在
        if (!zipFile.exists() || zipFile.length() <= 0) {
            unzipPath = "false";
            return unzipPath;
        }
        if (zipFile.length() <= 0) {
            unzipPath = "false";
            return unzipPath;
        }
        //创建解压缩文件保存的路径
        File unzipFileDir = new File(unzipFilePath);
        //的判断文件夹是否存在如果存在则不创建 如果不存在 则创建
        if (!unzipFileDir.exists() || !unzipFileDir.isDirectory()) {
            //创建文件夹
            unzipFileDir.mkdirs();
        }
        //开始解压
        //创建解压对象
        ZipEntry zipEntry = null;
        //文件保存路径路径
        String entryFilePath = null;
        //文件夹路径
        String entryDirPath = null;
        //创建问价对象
        File entryFile = null;
        //创建文件夹对象
        File entryDir = null;
        int index = 0, count = 0, bufferSize = 1024;
        byte[] buffer = new byte[bufferSize];
        //创建输出字符流
        BufferedInputStream bufferedInputStream = null;
        //创建输入字符流
        BufferedOutputStream bufferedOutputStream = null;
        try {
            //创建压缩文件对象
            ZipFile zip = new ZipFile(zipFile);
            Enumeration<ZipEntry> entries = (Enumeration<ZipEntry>) zip.entries();
            //第一步循环创建文件夹 第二步创建文件 第三部写入文件
            while (entries.hasMoreElements()) {
                zipEntry = entries.nextElement();
                boolean isDir = zipEntry.isDirectory();
                //当前文件为文件夹
                if (isDir) {
                    String dir = zipEntry.getName();
                    entryFilePath = unzipFilePath + File.separator + dir + File.separator;
                    //定义文件夹
                    entryDir = new File(entryFilePath);
                    //如果文件夹路径不存在，则创建文件夹
                    if (!entryDir.exists() || !entryDir.isDirectory()) {
                        entryDir.mkdirs();
                    }
                } else {
                    //当前是个文件
                    entryFilePath = unzipFilePath + File.separator + zipEntry.getName();
                    File f = new File(entryFilePath);
                    if (index != -1) {
                        entryDirPath = f.getAbsolutePath().split(f.getName())[0];
                    } else {
                        entryDirPath = "";
                    }
                    unzipPath = entryDirPath;
                    //定义文件夹
                    entryDir = new File(entryDirPath);
                    //如果文件夹路径不存在，则创建文件夹
                    if (!entryDir.exists() || !entryDir.isDirectory()) {
                        entryDir.mkdirs();
                    }
                    //创建解压文件
                    entryFile = new File(entryFilePath);
                    //写入文件
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(entryFile));
                    //读取文件
                    bufferedInputStream = new BufferedInputStream(zip.getInputStream(zipEntry));
                    //文件写入
                    while ((count = bufferedInputStream.read(buffer, 0, bufferSize)) != -1) {
                        bufferedOutputStream.write(buffer, 0, count);
                    }
                    bufferedOutputStream.flush();
                    bufferedOutputStream.close();
                }
            }
        } finally {
            try {
                if (null != bufferedInputStream) {
                    bufferedInputStream.close();
                }
                if (null != bufferedOutputStream) {
                    bufferedOutputStream.close();
                }
            } catch (Exception e2) {
                throw new CustomException("解压异常:" + e2.getMessage());
            }
        }
        return unzipPath;
    }

    /**
     *@param destPath 解压目标路径
     *@param fileName 解压文件的相对路径
     * */
    public static File createFile(String destPath, String fileName){
        String[] dirs = fileName.split("/");
        File file = new File(destPath);
        if (dirs.length > 1) {
            for (int i = 0; i < dirs.length - 1; i++) {
                file = new File(file, dirs[i]);
            }

            if (!file.exists()) {
                file.mkdirs();
                try {
                    System.out.println("mkdirs: " + file.getCanonicalPath());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            file = new File(file, dirs[dirs.length - 1]);
            return file;
        } else {
            if (!file.exists()) {
                file.mkdirs();
                try {
                    System.out.println("mkdirs: " + file.getCanonicalPath());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            file = new File(file, dirs[0]);
            return file;
        }
    }

    /**
     * 没有指定压缩目标路径进行压缩,用默认的路径进行压缩
     * @param dirPath 压缩源文件路径
     * */
    public static void compress(String dirPath){

        int firstIndex= dirPath.indexOf("/");
        int lastIndex= dirPath.lastIndexOf("/");
        String zipFileName=dirPath.substring(0,firstIndex+1)+dirPath.substring(lastIndex+1);
        compress(dirPath,zipFileName);
    }

    /**
     * 压缩文件
     * @param dirPath 压缩源文件路径
     * @param zipFileName 压缩目标文件路径
     * */
    public static void compress(String dirPath,String zipFileName){
        File dirFile=new File(dirPath);
        List<File> fileList= getAllFile(dirFile);
        byte[] buffer=new byte[BUFFER];
        ZipEntry zipEntry = null;
        int readLength= 0 ;
        try {
            CheckedOutputStream cos = new CheckedOutputStream(new FileOutputStream(
                    zipFileName), new CRC32());
            ZipOutputStream zos = new ZipOutputStream(cos);
            for(File file:fileList){
                if(file.isFile()){
                    zipEntry=new ZipEntry(getRelativePath(dirPath,file));
                    zipEntry.setSize(file.length());
                    zipEntry.setTime(file.lastModified());
                    zos.putNextEntry(zipEntry);
                    InputStream is = new BufferedInputStream(new FileInputStream(file));
                    while ((readLength=is.read(buffer,0,BUFFER))!=-1){
                        zos.write(buffer,0,readLength);
                    }
                    is.close();
                    System.out.println("file compress:"+file.getCanonicalPath());
                }else {
                    zipEntry=new ZipEntry(getRelativePath(dirPath,file));
                    zos.putNextEntry(zipEntry);
                    System.out.println("dir compress: " + file.getCanonicalPath()+"/");
                }
            }
            zos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 解压
     * */
    public static void decompress(String zipFileName,String destPath){

        try {
            ZipInputStream zis=new ZipInputStream(new FileInputStream(zipFileName));
            ZipEntry zipEntry = null;
            byte[] buffer = new byte[BUFFER];
            int readLength = 0;
            while ((zipEntry=zis.getNextEntry())!=null){
                if(zipEntry.isDirectory()){
                    File file=new File(destPath+"/"+zipEntry.getName());
                    if(!file.exists()){
                        file.mkdirs();
                        System.out.println("mkdirs:"+file.getCanonicalPath());
                        continue;
                    }
                }
                File file = createFile(destPath,zipEntry.getName());
                System.out.println("file created: " + file.getCanonicalPath());
                OutputStream os=new FileOutputStream(file);
                while ((readLength=zis.read(buffer,0,BUFFER))!=-1){
                    os.write(buffer,0,readLength);
                }
                os.close();
                System.out.println("file uncompressed: " + file.getCanonicalPath());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
