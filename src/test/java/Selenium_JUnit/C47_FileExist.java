package Selenium_JUnit;

import org.junit.jupiter.api.Test;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class C47_FileExist {
    /*
    Bilgisayarimizdaki bir dosyanin varligini test etmek icin once o dosyaya ulasmamiz gerekir
    Java da dosyay erismek icin dosya yoluna -pathine ihitiyacimiz vardir
    Her bilgisayarin kullanici adi farkli olacagindan masaustu dosya yolu da birbirinden farkl, olacaktir..
    Testlerimizin tum bilgisayarda calismasi icin dosya yolunu DİNAMİK yapmak zorundayiz..

    Files.exists (Paths.get (filePath)); Bilgisayarınızda dosyanın olup olmadığını kontrol eder.
     */

    @Test
    public void fileExist() {
        System.out.println(System.getProperty("user.dir"));// projemizin pathini getirir.

        // 1.yol
        String path1 = System.getProperty("user.dir")+"\\FileExist"; // manually creating path (yolu manuel olarak oluşturma)
        System.out.println(path1);

        // 2.yol
        String path2 = System.getProperty("user.dir") + System.getProperty("file.separator") + "FileExist";  // yukardaki ile ayni "\" bunun yerine System.getProperty("file.separator") yazdik
        System.out.println(path2);

        assertTrue(Files.exists(Paths.get(path1))); // bu dosya var mi
        assertTrue(Files.exists(Paths.get(path2))); // bu dosya var mi
    }
}

