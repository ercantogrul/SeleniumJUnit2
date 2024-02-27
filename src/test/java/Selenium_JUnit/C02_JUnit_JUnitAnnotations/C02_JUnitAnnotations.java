package Selenium_JUnit.C02_JUnit_JUnitAnnotations;

import org.junit.jupiter.api.*;


public class C02_JUnitAnnotations {
    /*
       * JUnit i nicin kullaniriz ihtiyacimiz var
* ANNOTATIONS lari ve Assertions lari kullanmak icin
* bunlar testlerimize öncelik verilmesi ve raporlar sunulmasini saglar
*
* *****COMMON ANNOTATIONS******
* @Test: Bu annotasyon, bir test metodu olduğunu belirtmek için kullanılır. Herhangi bir metodu test metodu
olarak işaretlemek için bu annotasyonu kullanabilirsiniz. Return type -> void

* @BeforeEach: Bu annotasyon, bir test metodu başlamadan önce çalıştırılacak bir metod belirtmek için kullanılır.
Her test metodu başlamadan önce çalıştırılacak ortak hazırlık işlemlerini bu metod içine yerleştirebilirsiniz.

* @AfterEach: Bu annotasyon, bir test metodu tamamlandıktan sonra çalıştırılacak bir metod belirtmek için kullanılır.
Her test metodu tamamlandıktan sonra yapılacak temizlik işlemlerini bu metod içine yerleştirebilirsiniz.

* @BeforeAll: Bu annotasyon, test sınıfındaki tüm test metodları başlamadan önce yalnızca bir kez çalıştırılacak
bir metodu belirtmek için kullanılır. Genellikle test sınıfının genel başlangıç işlemleri bu metoda yerleştirilir.

* @AfterAll: Bu annotasyon, test sınıfındaki tüm test metodları tamamlandıktan sonra yalnızca bir kez çalıştırılacak
bir metodu belirtmek için kullanılır. Genellikle test sınıfının genel temizlik işlemleri bu metoda yerleştirilir.

* @Disabled: Bu annotasyon, bir test metodu veya test sınıfının geçici olarak devre dışı bırakılmasını sağlar. Bu, bir testi
geçici olarak atlamak istediğinizde veya geçici olarak kullanılamayan bir test metodunu belirtmek istediğinizde kullanışlıdır.

* @RepeatedTest: Bu annotasyon, bir test metodu belirli bir sayıda tekrarlanacak şekilde işaretlenmesini sağlar.
Bir testi birkaç kez çalıştırmak istediğinizde bu annotasyonu kullanabilirsiniz.

* @ParameterizedTest: Bu annotasyon, bir test metodunun birden çok parametre setiyle tekrarlanmasını sağlar.
Farklı parametrelerle aynı testi birkaç kez çalıştırmak istediğinizde bu annotasyonu kullanabilirsiniz.

* @TestFactory: Bu annotasyon, testlerin dinamik olarak oluşturulmasını sağlar. Farklı test durumlarına veya senaryolarına
dayalı olarak testlerin oluşturulmasını istediğinizde bu annotasyonu kullanabilirsiniz.

* @Nested: Bu annotasyon, iç içe geçmiş test sınıflarını tanımlamak için kullanılır. Bir test sınıfı içinde başka test
sınıfları oluşturarak testlerinizi daha düzenli bir şekilde organize etmek istediğinizde bu annotasyonu kullanabilirsiniz.
*/
    @BeforeEach
    public void before(){
        System.out.println("BeforeEach metodu çalıştı");
    }

    @Test
    public void test2(){
        System.out.println("test2 çalıştı");
    }

    @Test
    public void test1(){
        System.out.println("test1 çalıştı");
    }

    @Test @Disabled("istenirse bu sekilde aciklama yazilarak methodun test edilmesini istemedigimizi belirtebiliriz")
    public void test3(){
        System.out.println("test3 çalıştı");
    }

    @Test
    public void test4(){
        System.out.println("test4 çalıştı");
    }

    @AfterEach
    public void tearDown(){
        System.out.println("afterEach method çalıştı");
    }

    @BeforeAll
    public static void beforeAll(){
        System.out.println("beforeAll metodu çalıştı.");
    }
    @AfterAll
    public static void afterAll(){
        System.out.println("afterAll metyodu çalıştı.");
    }
}
