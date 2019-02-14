package core;

import com.calculator.service.BaiduMapDistanceService;
import com.calculator.vo.MapLocation;

import java.util.Random;

public class MainClass {
    public static void main(String[] args) {
        BaiduMapDistanceService distanceService = new BaiduMapDistanceService();
        long start = System.currentTimeMillis();
        Random rand = new Random();
        for(int i=0;i<100;i++){
            Double result = distanceService.baiduMapDistance(new MapLocation(100+rand.nextFloat(),27.2),new MapLocation(100.13,27.77));
            System.out.println(result);
        }
        long end = System.currentTimeMillis();
        System.out.println("进行100次查询共花费:"+(end-start)+"ms!");
    }
}
