package Chpt2.item9.try_finally;

import java.io.*;

public class Copy {
    private static final int BUFFER_SIZE = 8 * 1024;

    static void copy(String src, String dst) throws IOException {
        InputStream in = new FileInputStream(src);
        try { 
            // 사용하고자 하는 자원이 2개 이상이라면 코드는 굉장히 지저분해진다.
            //이와 같은 상황에서는 예외 정보를 확실하게 파악하기도 어렵다.
            OutputStream out = new FileOutputStream(dst);
            try {
                byte[] buf = new byte[BUFFER_SIZE];
                int n;
                while ((n = in.read(buf)) >= 0)
                    out.write(buf, 0, n);
            } finally {
                out.close();
            }
        } finally {
            in.close();
        }
    }

    public static void main(String[] args) throws IOException {
        String src = args[0];
        String dst = args[1];
        copy(src, dst);
    }
}
