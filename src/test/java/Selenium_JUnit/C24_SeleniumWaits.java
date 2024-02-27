package Selenium_JUnit;

public class C24_SeleniumWaits {
       /* İnterview Sorusu :  Implicit ve Explicit

    Implicit : Bütün elemanlar için kullanılır.bir kere tanımlanır.
    Explicit : Tek bir eleman özel Kriter olarak tanımlanır sadece ilgili elemanda geçerli olur

    ExpectedConditions
            .titleIs -> title bu olana kadar bekle
            .titleContains -> title ın da bu kelime geçene kadar bekle
            .visibilityOfTheElement -> eleman gözükene kadar bekle
            .elementToBeClickable -> eleman tıklanabilir olana kadar bekle
            .elementToBeSelected -> eleman seçilebilir olana kadar bekle
            .alertIsPresent()  -> alert çıkana kadar bekle.
            .textToBe -> elemanda verilen txt gözükene kadar bekle.
            .InvisibilityOfTheElement -> eleman kaybolana kadar bekle

    Her ikisi tanımlı ise : önce Implicit kullanılır, ve üzerine Explicit in süresi eklenerek
    toplam hata sınır süresi ortaya çıkmış olur.
    Selenium waits, (senkronizasyon) : Kodlarimizla, internet ve bilgisayarin calismasini uyumlu hale
    getirmek icin bazen kodlarimizi bekletmemiz gerekir.
            Thread.sleep() : Java’dan gelir ve kodlari durdurur. Kendisine verilen surenin tamamini bekler.
    Dinamik degil statiktir.

            implicitlyWait : Selenium’dan gelir. Sayfanin yuklenmesi ve herbir webElementin locate edilmesi
    icin beklenecek max. sureyi belirler. Esnektir. Esas olan beklemek degil, kodun calismasini
    saglamaktir. Kod calisirsa beklemeden devam, kod calismazsa max.sure doluncaya bekler ve
    sonra hata mesaji verir(Exception).

    ExplicitlyWait : Selenium’dan gelir, spesifik bir islem icin beklenecek max. sureyi belirler.
    ExplicitlyWait kullanabilmek icin wait objesi olusturmamiz gerekir.
            wait.until(expectedConditions….. Istedigimiz fonk.) seklinde kullanilir.
    Genellikle wait.until() method’u locate ile birlikte kullanilir.
 */
}
