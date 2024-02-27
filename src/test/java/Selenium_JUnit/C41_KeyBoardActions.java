
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.TestBase;

public class C41_KeyBoardActions extends TestBase {
    //sendKeys (): Metin kutusuna, text yazmak için kullanılır.
    //keyDown (): Bir tuşu basılı tutmak için kullanılır.
    // Tuşlar Shift, Ctrl ve Alt anlamına gelir.
    //keyUp (): keyDown() yönteminden sonra zaten basılmış olan bir tuşu serbest bırakmak için kullanılır
    // yani hedefe odaklandıktan sonra tuşu serbest bırakır
    //Keyboard actions 2 parametre alır.

    //Go to URL: https://demoqa.com/auto-complete
    //In the Type single color name section, print "Exceptional" by using the action methods.

    @Test
    public void testKeyboardActions() {
        driver.get("https://demoqa.com/auto-complete");

    }
}
