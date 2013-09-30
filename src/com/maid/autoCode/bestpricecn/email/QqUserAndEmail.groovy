package com.maid.autoCode.bestpricecn.email

import com.maid.autoCode.bestpricecn.MyWebDriver
import org.openqa.selenium.By;/**
 * Created with IntelliJ IDEA.
 * User: xuping
 * Date: 13-9-30
 * Time: 上午10:10
 * To change this template use File | Settings | File Templates.
 */
class QqUserAndEmail extends MyWebDriver{

    static main(args) {
        driver.get("http://zc.qq.com/chs/index.html");
       // assertEquals("QQ注册", driver.getTitle());
        driver.findElement(By.cssSelector("div.box.box_3 > label.item")).click();
        driver.findElement(By.id("nick")).clear();
        driver.findElement(By.id("nick")).sendKeys("zuaa");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("aaaaaaaa");
        driver.findElement(By.id("password_again")).clear();
        driver.findElement(By.id("password_again")).sendKeys("aaaaaaaa");
        driver.findElement(By.id("sex_2")).click();
        driver.findElement(By.id("year_value")).click();
        driver.findElement(By.id("year_32")).click();
        driver.findElement(By.id("month_value")).click();
        driver.findElement(By.id("month_6")).click();
        driver.findElement(By.id("day_value")).click();
        driver.findElement(By.id("day_5")).click();
        driver.findElement(By.id("submit")).click();
// ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=;app_id=;app_param=;type=0;fromId=58030;temp_last_send=0;gurad_phone=;_new_uin=1502382668;last_page=0;phone_flag=0 | ]]
        String aaa = driver.findElement(By.id("newUin")).getText();
        println aaa;
    }


}