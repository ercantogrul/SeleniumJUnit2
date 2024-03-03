package Selenium_JUnit;

import org.junit.jupiter.api.Test;

public class C46_FilesInfo {

    @Test
    public void test1() {

        // DOSYA YOLUNU AYIRAN KARAKTERi VERiR___\
        System.out.println("1) " + System.getProperty("file.separator"));

        // PROJENiN YUKLU OLDUGU ADRESi VE YUKLU OLAN JAR DOSYALARININ ADRESLERiNi GOSTERiR
        System.out.println("2) " + System.getProperty("java.class.path"));

        // JAVA RUNTiME  ENViROMENT (JRE) iCiN KURULUM DiZiSi___C:\Users\etogr\.jdks\openjdk-21
        System.out.println("3) " + System.getProperty("java.home"));

        // JRE SATICI ADI____Oracle Corporation
        System.out.println("4) " + System.getProperty("java.vendor"));

        // JRE SATICI URL---https://java.oracle.com/
        System.out.println("5) " + System.getProperty("java.vendor.url"));

        // JRE SURUM NUMARASI---21
        System.out.println("6) " + System.getProperty("java.version"));

        // iSLETiM SiSTEMi ADI  __Windows 11
        System.out.println("7) " + System.getProperty("os.name"));

        // iSLETiM SiSTEMi SURUMU---10.0
        System.out.println("8) " + System.getProperty("os.version"));

        // KULLANILAN YOL AYIRICI KARAKTER---;
        System.out.println("9) " + System.getProperty("path.separator"));

        // KULLANICI CALISMA DiZiNi- projenin content rootu---(C:\Users\etogr\IdeaProjects\Selenium2_JUnit)
        System.out.println("10) " + System.getProperty("user.dir"));

        // KULLANICI ANA DiZiNi - windows user C nin altindaki isim____C:\Users\etogr
        System.out.println("11) " + System.getProperty("user.home"));

        // KULLANICI HESABI ADI_____Ercan
        System.out.println("12) " + System.getProperty("user.name"));

        // DOSYA AYIRACI: Windows icin '\' - mac icin '/'
        System.out.println("13) "+ System.getProperty("file.separator"));
    }
}

