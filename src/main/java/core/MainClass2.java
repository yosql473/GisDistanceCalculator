package core;

import com.calculator.service.BaiduMapDistanceService;
import com.calculator.vo.MapLocation;

public class MainClass2 {
    public static void main(String[] args) {
        BaiduMapDistanceService service = new BaiduMapDistanceService();
        Double result = service.baiduMapDistance(new MapLocation(100,20),new MapLocation(100,20.22));
        System.out.println(result+"米");
    }
}
