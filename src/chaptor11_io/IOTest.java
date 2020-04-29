package chaptor11_io;

import java.io.*;

public class IOTest {
    public static void main(String[] args) {
        copy("/", "haha");
    }

    public static void copy(String src, String sub) {
        File f1 = new File(src);
        FileReader fr = null;
        BufferedReader br = null;

        try {
            fr = new FileReader(f1);
            br = new BufferedReader(fr);

            String line = "";
            int index = 0;
            int count = 0;

            while ((line = br.readLine()) != null) {
                while ((index = line.indexOf(sub, index)) != -1) {
                    count++;
                    index = index + sub.length();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
