package com.calculator.manager;

import com.calculator.browser.BrowserStatus;
import com.calculator.browser.BrowserConfig;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class VirtualChromeManager{
    /*** 浏览器参数 ***/
    ChromeOptions options;
    /*** 浏览器 ***/
    WebDriver webDriver;
    /*** 浏览器状态 ***/
    BrowserStatus status = BrowserStatus.NOT_INIT;
    /*** 驱动位置 ***/
    String driverLocation = null;
    public ChromeOptions getOptions() {
        return options;
    }

    public void setOptions(ChromeOptions options) {
        this.options = options;
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public BrowserStatus getStatus() {
        return status;
    }

    public void setStatus(BrowserStatus status) {
        this.status = status;
    }

    public String getDriverLocation() {
        return driverLocation;
    }

    public void setDriverLocation(String driverLocation) {
        this.driverLocation = driverLocation;
    }


    public  VirtualChromeManager(){
        options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--headless");
        options.addArguments("user-agent='Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36'");
    }


    /**
     * @param driverLocation 驱动位置
     */
    VirtualChromeManager(String driverLocation){
        options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--headless");
        options.addArguments("user-agent='Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36'");
        this.driverLocation = driverLocation;
    }

    /**
     * @param options
     * @param driverLocation 驱动位置
     */
    VirtualChromeManager(ChromeOptions options,String driverLocation){
        this.options = options;
        this.driverLocation = driverLocation;
    }


    /**
     * 创建driver
     * @return
     */
    public WebDriver createDriver(){
        String tmpDriverLocation = null;
        if(driverLocation==null){
            tmpDriverLocation = BrowserConfig.chromePath;
            System.setProperty("webdriver.chrome.driver",tmpDriverLocation);
        }else{
            System.setProperty("webdriver.chrome.driver",driverLocation);
        }

        this.webDriver = new ChromeDriver(options);
        status = BrowserStatus.ACTIVE;
        return this.webDriver;
    }


    /**
     * 关闭驱动
     */
    public void closeDriver(){
        this.webDriver.close();
        status = BrowserStatus.DEAD;
    }

    /**
     * 激活浏览器
     */
    public void activeBrowser(){
        switch (this.status){
            case NOT_INIT:
            case DEAD:
                this.webDriver = createDriver();
                this.webDriver.get(BrowserConfig.baiduMapApiLocalPagePath);
                break;
        }
    }

    /**
     * GET请求获得页面
     * @param url
     */
    public void get(String url){
        activeBrowser();
        this.webDriver.get(url);
    }

    /**
     * 在页面上跑JS
     * @param javascripts
     */
    public void runJSOnPage(String[] javascripts){
        if(javascripts==null||javascripts.length<1){
            return;
        }
        StringBuffer sb = new StringBuffer(javascripts[0]);
        sb.append(";");
        for(int i=1;i<javascripts.length;i++){
            sb.append(javascripts[i]+";");
        }
        ((JavascriptExecutor)webDriver).executeScript(sb.toString());
    }


}
