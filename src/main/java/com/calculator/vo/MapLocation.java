package com.calculator.vo;

/**
 * 经纬度坐标
 */
public class MapLocation {
    // 经度
    double longtitude;
    // 纬度
    double latitude;

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(double longtitude) {
        this.longtitude = longtitude;
    }

    public MapLocation(double longtitude, double latitude) {
        this.longtitude = longtitude;
        this.latitude = latitude;
    }
}
