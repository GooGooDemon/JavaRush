package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/
// сделал, но не отправил

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    private static int ENCRYPT_KEY = 0x32;

    public static void main(String[] args) throws Exception {
        if (args.length == 0) return;

        if ("-e".equals(args[0])) {
            EncryptFile(args[1], args[2]);
        }

        if ("-d".equals(args[0])) {
            DecryptFile(args[1], args[2]);
        }
    }

    public static void EncryptFile(String sourceFileName, String destFileName) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(sourceFileName);
        FileOutputStream fileOutputStream = new FileOutputStream(destFileName);

        while (fileInputStream.available() > 0) {
            int oneByte = fileInputStream.read();
            fileOutputStream.write(oneByte ^ ENCRYPT_KEY);
        }

        fileInputStream.close();
        fileOutputStream.close();
    }

    public static void DecryptFile(String sourceFileName, String destFileName) throws IOException {
        FileInputStream encryptedInputStream = new FileInputStream(sourceFileName);
        FileOutputStream decryptedOutputStream = new FileOutputStream(destFileName);

        while (encryptedInputStream.available() > 0) {
            int oneByte = encryptedInputStream.read();
            decryptedOutputStream.write(oneByte ^ ENCRYPT_KEY);
        }

        encryptedInputStream.close();
        decryptedOutputStream.close();
    }

}
