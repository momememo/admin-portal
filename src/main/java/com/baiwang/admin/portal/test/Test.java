package com.baiwang.admin.portal.test;

import com.google.common.base.Charsets;
import com.google.common.io.CharStreams;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Properties;
import javax.sound.midi.Soundbank;
import org.apache.tomcat.util.http.fileupload.IOUtils;

/**
 * @Description:
 * @author: liyunfei
 * @date: 2018/10/26 16:56
 */
public class Test extends T1{

    //public static void main(String[] args) {
    //    Runtime runtime = Runtime.getRuntime();
    //    try {
    //        //Process exec = runtime.exec("javac D:/A.java");
    //        //Process exec1 = runtime.exec("java -cp");
    //        //Process exec2 = runtime.exec("jar -cvf D:/A.jar D:/A.java");
    //        File file = new File("D:/A.java");
    //        FileInputStream fis = new FileInputStream(file);
    //        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fis));
    //        String line;
    //        StringBuffer sb = new StringBuffer();
    //        while ((line = bufferedReader.readLine()) != null) {
    //            sb.append(line).append("\n");
    //        }
    //        //System.out.println(sb.toString());
    //        String s = sb.toString();
    //        String substring = s.substring(0, s.lastIndexOf("\n") - 1);
    //        StringBuffer ahhahahh = new StringBuffer(substring)
    //                .append("\n")
    //                .append("\tpublic String getApiName(){\n")
    //                .append("\t\treturn \"baiwang.invoice.open\";\n")
    //                .append("\t}\n")
    //                .append("}\n");
    //        //System.out.println(ahhahahh);
    //        String s1 = ahhahahh.toString();
    //        System.out.println(s1.substring(s1.indexOf("{")));
    //        String hou = s1.substring(s1.indexOf("{") + 1);
    //        String qian = s1.substring(0, s1.indexOf("{"));
    //        StringBuffer append = new StringBuffer(qian).append("extends AbstractBopRequest {");
    //        StringBuffer append1 = append.append(hou);
    //        System.out.println(append1.toString());
    //        //System.out.println(s1.substring(0, s1.indexOf("{")));
    //        //s1.replaceFirst("\n", "extends AbstractBopRequest {");
    //        //System.out.println(s1);
    //
    //        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("D:/EEE.java"))));
    //        bufferedWriter.write(append1.toString().toCharArray());
    //        bufferedWriter.flush();
    //        bufferedWriter.close();
    //        bufferedWriter.close();;
    //
    //        Runtime.getRuntime().exec("javac D://EEE.java");
    //    } catch (IOException e) {
    //        e.printStackTrace();
    //    }
    //}

    public static void main(String[] args) throws IOException {

        Process exec = Runtime.getRuntime().exec("javac -cp D:/ D:/java1/EEE.java");
        InputStream stream = exec.getErrorStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream, Charset.forName("GB2312")));
        StringWriter writer = new StringWriter();

        char[] chars = new char[256];
        int count = 0;
        while ((count = reader.read(chars)) > 0) {
            writer.write(chars, 0, count);
        }

        System.out.println(writer.toString());

    }
}
