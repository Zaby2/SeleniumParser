package Parse;

import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Source {
    private int deep = 0;
     public String getSource() {
         WebDriver wb = new ChromeDriver();
         wb.get("https://animego.org/anime");
         JavascriptExecutor js = (JavascriptExecutor) wb;
         while (deep < 10000) {
             js.executeScript("window.scrollBy(0, 1000)");
             deep++;
         }
         return wb.getPageSource();
     }
}
