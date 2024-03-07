package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public abstract class TestBaseReport2 {
/*
    TestBase Class: Her test class'ında tekrar tekrar yazdığımız setup ve teardown method'larını tekrar
    yazmaktan kurtulmak için Java OOP konseptini kullanarak oluşturduğumuz bir class'tır.

    - Test Base'i parent olarak kabul eden class'lar hazırlık için oluşturduğumuz driver, setup() ve teardown()
    metodlarını oluşturmak zorunda kalmazlar; kendilerinde olmasa bile parent class'tan kullanılabilir.

    - TestBase genellikle testlerden farklı bir pakette bulunduğundan driver'ı kullanabilmek için public veya
    protected yapmamız gerekir. Biz hep child class'lardan kullanacağımız için protected yapmayı tercih ettik.

    - Bu class sadece child class'lardan inheritance özellikleri ile kullanılsın istediğimizden, bu class'ın
    obje oluşturularak kullanılmasına engel olmak için class'ı abstract YAPABİLİRİZ.

    - Abstract yaparak TestBase Class'ından obje oluşturulmasının önüne geçeriz. TestBase Class'ını sadece
    extends ile inherit ederek kullanacağız. Dolayısıyla oluşturduğumuz driver variable'ı için protected access
    modifier'ı seçiyoruz.
*/

    protected static WebDriver driver;
    protected static ExtentReports extentReports; // Raporlama işlemini gerçekleştirir
    protected static ExtentSparkReporter extentHtmlReporter; // Raporu HTML olarak düzenler
    protected static ExtentTest extentTest; // Testimizin pass veya fail olduğunu saklayan objemiz. Ekran görüntüleri için de kullanılır


    @BeforeAll
    public static void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterAll
    public static void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    public ExtentReports extentReportsSetUp() {

        // Extent report objelerimizi oluşturuyoruz
        extentReports = new ExtentReports();

        // Kaydedeceğimiz dosya için tarih stringi oluşturuldu
        String currentDate = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String filePath = System.getProperty("user.dir") + "/test-output/reports/testReport" + currentDate;

        // HTML raporu oluşturacak obje dosya yoluyla initialize edildi
        extentHtmlReporter = new ExtentSparkReporter(filePath);

        // Raporlama yapan extentreport objemize HTML reporter bağlandı
        extentReports.attachReporter(extentHtmlReporter);

        // Test başlatılıyor
        //extentTest = extentReports.createTest(TestBase.class.getSimpleName() + " - " + Thread.currentThread().getStackTrace()[2].getMethodName());

        // Rapor ile alakalı ekstra opsiyonel bilgiler verildi
        extentReports.setSystemInfo("Environment", "QA");
        extentReports.setSystemInfo("Browser", "Chrome");
        extentReports.setSystemInfo("Tester", "Tester CW");
        extentReports.setSystemInfo("Company", "Clarusway");

        // HTML raporunda görüntülemek istediğimiz konfigürasyonlar yapıldı
        extentHtmlReporter.config().setDocumentTitle("JUnit_Report");
        extentHtmlReporter.config().setReportName("Test run report");

        // extentReports.flush(); --> Test sonu raporun oluştutulması için unutulmamalıdır.

        return extentReports;

    }
}
