package Svm1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Stack;

public class Svm1 {
    private byte[] code = new byte[256]; //プログラムのコードの領域
    private int codeLength = 0; //プログラムの終了の判定
    private Stack<Byte> operandStack = new Stack<Byte>();
    private Alu alu = new Alu();
    private int pc; //どこまでプログラムを実行したかを記録(プログラムカウンタ)

    public void load(String fileName) throws IOException {
        FileInputStream is = null;
        try {
            is = new FileInputStream(new File(fileName));
            int len = 0;
            while ((len = is.read(code, len, 8)) != -1) {
                codeLength += len;
            }
        } finally {
            if (is != null) {is.close();}
        }
    }
}
