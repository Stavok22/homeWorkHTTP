package homeworkhttp;

import java.io.*;
import java.net.URL;
import java.util.Objects;

public class HttpStatusImageDownloader {

    private static final String PATH_FOR_WRITING = "downloadedImages/";

    public void downloadStatusImage(int code) {
        String nameOfImage = code + ".jpg";
        URL url = null;
        try {
            url = new URL(new HttpStatusChecker().getStatusImage(code));
            new File(PATH_FOR_WRITING).mkdirs();
        } catch (Exception exc) {
            return;
        }

        try (InputStream in = new BufferedInputStream(Objects.requireNonNull(url).openStream());
             ByteArrayOutputStream out = new ByteArrayOutputStream();
             FileOutputStream fos = new FileOutputStream(PATH_FOR_WRITING + nameOfImage)) {


            byte[] buf = new byte[1024];
            int n;
            while (-1 != (n = in.read(buf))) {
                out.write(buf, 0, n);
            }

            byte[] response = out.toByteArray();
            System.out.println("Download started...");

            fos.write(response);
            System.out.println("Download finished.\n");
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}
