package cn.com.zv2.client;

import cn.com.zv2.stub.translation.ArrayOfString;
import cn.com.zv2.stub.translation.EnglishChinese;
import cn.com.zv2.stub.translation.EnglishChineseSoap;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * @author lb
 * @description
 * @date 2020/5/13
 */
public class TranslationClient {
    private EnglishChineseSoap englishChineseSoap = new EnglishChinese().getEnglishChineseSoap();

    public List<String> translate(String word) {
        ArrayOfString arrayOfString = englishChineseSoap.translatorString(word);
        return arrayOfString.getString();
    }

    public byte[] getMp3By(String mp3Name) {
        return englishChineseSoap.getMp3(mp3Name);
    }

    public static void main(String[] args) {
        TranslationClient client = new TranslationClient();
        List<String> stringList = client.translate("USA");
        for (String s : stringList) {
            System.out.println(s);
            if (s.endsWith(".mp3")) {
                byte[] mp3 = client.getMp3By(s);
                try {
                    final String resourcesPath = new File("src/main/resources").getCanonicalPath();
                    OutputStream out = new FileOutputStream(new File(resourcesPath, s));
                    out.write(mp3);
                    out.flush();
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
