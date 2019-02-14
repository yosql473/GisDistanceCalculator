package com.calculator.browser;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BrowserConfig {
    /*** chrome浏览器位置 ***/
    public static String chromePath;
    /*** 百度地图API的HTML页面 ***/
    public static String baiduMapApiLocalPagePath;

    static{
        InputStream is = ClassLoader.getSystemResourceAsStream("constants.properties");
        Properties properties = new Properties();
        try {
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        chromePath = (String) properties.get("selenium.chrome.path");
        baiduMapApiLocalPagePath = (String) properties.get("baidumapapi.localPage.url");
        System.out.println(chromePath);
        System.out.println(baiduMapApiLocalPagePath);
    }

}
