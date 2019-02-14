package com.calculator.service;

import com.calculator.vo.MapLocation;
import com.calculator.manager.VirtualChromeManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/***
 * 百度地图地图查询接口
 */
public class BaiduMapDistanceService {
    VirtualChromeManager virtualChromeManager = new VirtualChromeManager();

    {
        Double result = baiduMapDistance(new MapLocation(100,20),new MapLocation(100,20));
    }

    /**
     * 用百度地图计算两点之间距离
     * @param point1
     * @param point2
     */
    public Double baiduMapDistance(MapLocation point1, MapLocation point2){
        virtualChromeManager.activeBrowser();
        virtualChromeManager.runJSOnPage(new String[]{"calculate("+point1.getLongtitude()+","+point1.getLatitude()+","+point2.getLongtitude()+","+point2.getLatitude()+")"});
        //检查是否已经获得返回值
        WebDriver driver = virtualChromeManager.getWebDriver();
        WebElement element = driver.findElement(By.id("result"));
        String resultStr = element.getAttribute("result").trim();
        Double result = null;
        try {
            result = Double.parseDouble(resultStr);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        if(result == null){
            result = -1d;
        }
        return result;
    }

    public VirtualChromeManager getVirtualChromeManager() {
        return virtualChromeManager;
    }

    public void setVirtualChromeManager(VirtualChromeManager virtualChromeManager) {
        this.virtualChromeManager = virtualChromeManager;
    }



}
