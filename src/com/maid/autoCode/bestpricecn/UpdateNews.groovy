package com.maid.autoCode.bestpricecn

/**
 * Created with IntelliJ IDEA.
 * User: xuping
 * Date: 13-9-22
 * Time: 下午8:51
 * To change this template use File | Settings | File Templates.
 */
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.concurrent.TimeUnit;
class UpdateNews {
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    static main(args) {


        try{
            run()
        }catch (Exception e){

        }

        sleep(1000*60*60);

    }
    static  void run(){
        WebDriver driver = new FirefoxDriver( );
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://www.bestpricecn.com/index.php/tadmin/login");
        driver.findElement(By.id("user_name")).sendKeys("zuaa");
        driver.findElement(By.name("password")).sendKeys("zuaa@428");
        driver.findElement(By.cssSelector("input[type=\"image\"]")).click();
        Thread.sleep(10000);
        println ("等待登陆完成")


        rauOneByOne(  driver, "http://www.bestpricecn.com/index.php/tadmin/rule/caiji/10","明星内衣")
        rauOneByOne(  driver, "http://www.bestpricecn.com/index.php/tadmin/rule/caiji/8","明星内衣")
        rauOneByOne(  driver, "http://www.bestpricecn.com/index.php/tadmin/rule/caiji/9","时尚资讯")
        rauOneByOne(  driver, "http://www.bestpricecn.com/index.php/tadmin/rule/caiji/7","时尚资讯")
        rauOneByOne(  driver, "http://www.bestpricecn.com/index.php/tadmin/rule/caiji/6","潮流趋势")
        rauOneByOne(  driver, "http://www.bestpricecn.com/index.php/tadmin/rule/caiji/5","时尚资讯")
        rauOneByOne(  driver, "http://www.bestpricecn.com/index.php/tadmin/rule/caiji/4","潮流趋势")

        println ("抓取完成，刷新静态页面")



        driver.get("http://www.bestpricecn.com/index.php/tadmin/make_html");
        driver.findElement(By.xpath("//input[2]")).click();
        driver.findElement(By.id("sbtn")).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        int ii=0;
        while(ii<60*5){
            try {
                String text=driver.findElement(By.cssSelector("#process > tbody > tr > td")).getText();
                if(!text.equals("本次页面生成完毕")) {
                    println ("本次页面没生成完毕 等待1秒钟")
                    Thread.sleep(1000);
                }
            } catch (Error e) {
                println ("没找到对象 等待1秒钟")
                Thread.sleep(1000);
            }
            ii=ii+1;
        }
        Thread.sleep(3000);
        println("操作完成,等待3秒退出。")
        driver.quit();

    }



    static  void rauOneByOne(def driver,def url,def type){
        driver.get(url);
        driver.findElement(By.name("is_w")).click();
        new Select(driver.findElement(By.id("catalog_id"))).selectByVisibleText(type);
        driver.findElement(By.cssSelector("input.button-style2")).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        int n  = driver.findElements(By.cssSelector("font")).size();
        println "有${n}页数据需要采集"
        int i=0;
        while(i<30*n){
            try {
                String text=driver.findElement(By.cssSelector("#process > tbody > tr > td")).getText();
                if(!text.equals("全部数据采集完毕")) {
                    println ("没抓取完成 等待1秒钟")
                    Thread.sleep(1000);
                }
            } catch (Error e) {
                println ("没找到对象 等待1秒钟")
                Thread.sleep(1000);
            }
            i=i+1;
        }
        Thread.sleep(10000);
        println (" 等待10秒钟，进行下一个操作。")
    }

}
