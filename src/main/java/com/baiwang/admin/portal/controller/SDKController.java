package com.baiwang.admin.portal.controller;

import com.baiwang.admin.portal.bean.result.Result;
import com.baiwang.admin.portal.bean.result.ResultBuilder;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.zip.ZipFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Description:
 * @author: liyunfei
 * @date: 2018/10/26 21:35
 */
@Controller
@RequestMapping("sdk")
public class SDKController {

    private static Logger log = LoggerFactory.getLogger(SDKController.class);

    /**
     * 1. 上传请求响应bean
     * 2. 生成sdk
     */

    @Value("${spring.http.multipart.location}")
    private String tempLocation;

    @ResponseBody
    @RequestMapping("/upload")
    public Result uploadFile(@RequestParam(value = "requestId", required = false) String requestId,
                             @RequestBody MultipartFile file) throws IOException {

        ZipFile zipFile = multipartFileToZipFile(file);

        zipFile.stream().forEach(entry -> {
            StringBuffer sb = new StringBuffer();
            System.out.println(entry.getName());
            System.out.println(entry.getComment());
            sb
                    .append(entry.getName()).append("\t")
                    .append(entry.getComment())
                    .append("\n");
            try {
                InputStream inputStream = zipFile.getInputStream(entry);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    sb.append(line);
                }
                System.out.println(sb.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        return ResultBuilder.newResult().build();
    }

    private ZipFile multipartFileToZipFile(MultipartFile file) throws IOException {
        InputStream ins = file.getInputStream();
        File f = new File(file.getOriginalFilename());
        inputStreamToFile(ins, f);
        ZipFile zipFile = new ZipFile(f);
        return zipFile;
    }

    private void inputStreamToFile(InputStream ins, File file) {
        try {
            OutputStream os = new FileOutputStream(file);
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.close();
            ins.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public static void unzip(String zipFile) throws Exception {
        FileSystem fs = FileSystems.newFileSystem(Paths.get(zipFile), null);
        final String currentPath = System.getProperty("user.dir");
        System.out.println("current directory:" + currentPath);

        Files.walkFileTree(fs.getPath("/"), new SimpleFileVisitor<Path>() {
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                Path destPath = Paths.get(currentPath, file.toString());
                Files.deleteIfExists(destPath);
                Files.createDirectories(destPath.getParent());
                Files.move(file, destPath);
                return FileVisitResult.CONTINUE;
            }
        });
    }

}
