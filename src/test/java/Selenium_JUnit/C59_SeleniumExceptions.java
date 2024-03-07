package Selenium_JUnit;

public class C59_SeleniumExceptions {
    /*
https://www.selenium.dev/selenium/docs/api/py/common/selenium.common.exceptions.html

En Yaygın Selenium Exceptionlar
    *NoSuchWindowException
    *NoSuchFrameException
    *NoSuchElementException
    *NoAlertPresentException
    *InvalidSelectorException
    *TimeoutException
    *ElementNotVisibleException
    *ElementNotSelectableException
    *NoSuchSessionException
    *StaleElementReferenceException

NoSuchElementException
 Locator yanlış, WebElement gizli, yükleme ve senkronizasyon sorunu.
 Iframe, pop-up veya new window nedeniyle WebElement sayfada bulunamadı.

TimeOutException
 Selenium beklemelerini uyguladıktan ve bir süre geçtikten sonra eleman hala görünmüyorsa, TimeOutException'ı görürüz.
 Basitçe söylemek gerekirse, bekleme süresi bitti ama task step tamamlanmadı ise karşılaşırız.

StaleElementReferenceException
 Etkileşimde olduğunuz öğeye yapılan başvuru artık bayat olduğunda Selenium bir StaleElementReferenceException atar .
 Bu, öğenin artık web sayfasının gerçek DOM'sine bağlı olmadığı anlamına gelir.

WebDriverException
 Driver ve browserların sürümleri uyumlu olmadığı durumlarda karşılaşırız.

NullPointerException
 Bir değişken oluşturulduğunda ancak başlatılamadığında veya işaretçi herhangi bir değer göstermediğinde NullPointerException alırız.
 Genelde driver başlatıldığında sık karşılaşılır.

 */
}
