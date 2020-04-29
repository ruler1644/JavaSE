package chaptor12_socket;

import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class URLTest {
    @Test
    public void test() throws IOException {

        URL url = new URL("https://mini.eastday.com/a/n191107155814096.html?qid=hao123tj");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.connect();

        InputStream is = connection.getInputStream();
        OutputStream os = new FileOutputStream("beauty.html");

        byte[] buff = new byte[512];
        int len = 0;
        while ((len = is.read(buff)) != -1) {
            os.write(buff, 0, len);
        }
        //关闭资源
    }
}
