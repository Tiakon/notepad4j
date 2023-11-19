package cn.tiakon.notepad4j.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ImagePathUtil {
    public static byte[] getImageFromSystemResource(String image) {
        InputStream inputStream = ClassLoader.getSystemResourceAsStream(image);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024 * 10];
        int n;
        try {
            while (true) {
                assert inputStream != null;
                if (-1 == (n = inputStream.read(buffer))) break;
                byteArrayOutputStream.write(buffer, 0, n);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }
}
