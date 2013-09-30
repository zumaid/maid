package com.maid.autoCode.bestpricecn

import org.openqa.selenium.Alert
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.Select

/**
 * Created with IntelliJ IDEA.
 * User: xuping
 * Date: 13-9-25
 * Time: 下午9:16
 * To change this template use File | Settings | File Templates.
 */
class AddProduction extends MyWebDriver {
    static main(args) {
        while (1) {
            def runall = """丝袜 美腿|,2,53,|丝袜
时尚气质风衣|,2,17,|风衣
性感秋装|,2,20,|连衣裙
女士性感内裤蕾丝透明|,1,23,|女士内裤
女士性感高帮鞋蕾丝|,4,38,|女士高帮鞋
丁字裤|,1,23,|女士内裤"""
            runall.eachLine {
                try {
                    run(it)
                } catch (Exception e) {
                    quit(driver);
                }
            }
            //f5(driver)
            quit(driver);
            sleep(1000 * 60 * 60 * 5)
        }
    }

    static run(String it) {


        def keys = it.tokenize("|")[0];
        def type = it.tokenize("|")[1]

        WebDriver driver = getDriver();
        login(driver)
        driver.get("http://www.bestpricecn.com/index.php/tadmin/product/search")
        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("${keys}");
        driver.findElement(By.cssSelector("input.button-style2")).click();
        driver.findElement(By.cssSelector("td > input[type=\"checkbox\"]")).click();
        driver.findElement(By.cssSelector("input.button-style")).click();
        sleep(1000)
        new Select(driver.findElement(By.xpath("//select[@id='catalog_id']"))).selectByValue(type);

        driver.findElement(By.xpath("//button[2]")).click();
        sleep(20000)
        Alert alert = driver.switchTo().alert();
        alert.accept();

    }
}
