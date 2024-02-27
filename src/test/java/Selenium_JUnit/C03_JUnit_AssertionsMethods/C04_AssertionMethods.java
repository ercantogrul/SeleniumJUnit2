package Selenium_JUnit.C03_JUnit_AssertionsMethods;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class C04_AssertionMethods {

    @Test
    public void assertEqualsTest(){
        //2 parametre alirsa parametreler karsilastirilir ve esitlerse test PASSED olur,
        // esit degilse AssertionError firlatir


        Assertions.assertEquals(10,10); //passed
        Assertions.assertEquals("Ercan","Ercan"); //passed
        Assertions.assertEquals(new String("Ercan"),"Ercan");//passed
    }
    @Test
    public void assertTrueTest(){
        //1 parametre alir ve gonderilen parametrenin true olmasi durumunda testimiz PASSED,
        // false olmasi durumunda da FAILED olur

        assertTrue(5==5); // passed (iceriden cikacak degerin True olmasi sarti ile test yapiliyor. bu test true olmaz ise test gecemez)
       // assertTrue(5==4); // failed
       // assertTrue(false); // failed
    }

    @Test
    public void assertFalseTest(){
        //1 parametre alir ve gonderilen parametrenin false olmasi durumunda testimiz PASSED,
        // true olmasi durumunda da FAILED olur

        assertFalse(5==3); // passed
    }

    @Test
    public void assertNullTest(){
        //1 parametre alir, Parametre null ise test PASSED,
        // null degil ise test FAILED olur

       assertNull(null);  //passed
    }

    @Test
    public void assertNotNullTest(){
        //1 parametre alir, Parametre null degil ise test PASSED,
        // null ise test FAILED olur
      assertNotNull(5294);// passed
    }

    @Test
    public void assertSameTest(){
        //bu method iki nesnenin esit olup olmadigini dogrulamak icin dahili olarak == operatorunu kullanir
        //assertSame referans degerlerini de karsilastirir..
        //obje kontrolunde deger ve referanslar ayni olmalidir...

      assertSame("Nuray","Nuray");//passed
      //assertSame(new String("Nuray"),"Nuray");//Failed
      //assertSame(new String("Nuray"),new String("Nuray"));//Failed
    }

    @Test
    public void assertNotSameTest(){
        //obje kontrolunde deger ve referanslar ayni olmayanlar icin gecerlidir

      assertNotSame(new String("Nuray"),new String("Nuray"));  //passed
    }

    @Test
    public void assertArrayEqualsTest(){
        //2 parametre alir ve verilen arraylerin uzunluklari ve ayni indexdeki elemanlari ayni olmalidir

        int [] arr1 = {0,1,6,3,4}, arr2= {0,1,2,3,4},arr3= {0,1,2,3,4};;
       // assertArrayEquals(arr1,arr2);
        assertArrayEquals(arr2,arr3);




        char[] actualArr = {'h','o', 'm', 'e'};
        char[] expectedArr = {'H','O', 'M', 'E'};
       // assertArrayEquals(actualArr,expectedArr);//failed


    }


}
 /*
    import org.junit.jupiter.api.Assertions;

    import static org.junit.Assert.assertSame;

     Assertions sınıfı için statik içe aktarmanın avantajı şudur:

        Assertions sınıf adının gereksiz kullanımını Assert yöntemleriyle ortadan kaldırmak için.
        Zaman kazandırır.
        Yazmayı daha iyi hale getirir ve
        Kodun okunabilirliğini artırır.
     */