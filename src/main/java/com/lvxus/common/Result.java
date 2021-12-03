package com.lvxus.common;

import com.lvxus.measurement.MeasureMent;
import com.lvxus.postion.SubmarinePostion;

import java.util.List;

public class Result {

    public static void main(String[] args) {
        sentOutDay1Part1Result();
        sentOutDay1Part2Result();
        sentOutDay2Result();
    }

    private static void sentOutDay1Part1Result() {
        List<Integer> measurements = ReadText.readIntTextFile("G:\\TDDpractise\\length-java\\src\\test\\java\\measurements.txt", "utf-8");
        MeasureMent measureMent = new MeasureMent();
        measureMent.setMeasureMentsAndSliding("",measurements);
        System.out.println("Day1Part1:"+measureMent.getLargerTimes());
    }
    private static void sentOutDay1Part2Result() {
        List<Integer> measurements = ReadText.readIntTextFile("G:\\TDDpractise\\length-java\\src\\test\\java\\measurements.txt", "utf-8");
        MeasureMent measureMent = new MeasureMent();
        measureMent.setMeasureMentsAndSliding("sliding",measurements);
        System.out.println("Day1Part2:"+measureMent.getLargerTimes());
    }

    private static void sentOutDay2Result() {
        List<String> measurements = ReadText.readStringTextFile("G:\\TDDpractise\\length-java\\src\\test\\java\\submarineMove.txt", "utf-8");
        SubmarinePostion submarinePostion = new SubmarinePostion();
        submarinePostion.setDiveDistances(measurements);
        System.out.println("DAY2:"+submarinePostion.getTotalHorizontal()*submarinePostion.getTotalDepth());
    }
}