# GisDistanceCaculator - master
@Au yosql473

本程序利用百度地图JS SDK 计算两地之间的直线距离，调用简单即插即用。

## 快速开始

### 0/下载Chromedriver

可以从这个镜像站下载: https://npm.taobao.org/mirrors/chromedriver/

### 1/配置constants.properties:

selenium.chrome.path=C:/Program Files (x86)/Google/Chrome/Application/chromedriver.exe
baidumapapi.localPage.url=C:/Users/yosql473/Desktop/distance-data-get.html

* 第一个参数表示chromedriver的绝对路径
* 第二个参数表示distance-data-get.html这个本地页面的地址
* 以上两个文件在resources中都有

### 2/配置百度地图开发平台的AK

在distance-data-get.html这个本地页面中`你的AK`处替换成你的AK。

### 3/调用方式:
可以参考 core.MainClass 和 coreMainClass2;

    BaiduMapDistanceService service = new BaiduMapDistanceService();
    Double result = service.baiduMapDistance(new MapLocation(100,20),new MapLocation(100,20.22));
    System.out.println(result+"米");
    
就是这么简单。

结果： 24462.87米

测试效率: 大约是100次计算1700ms上下。