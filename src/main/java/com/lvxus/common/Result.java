package com.lvxus.common;

import com.lvxus.measurement.MeasureMent;
import com.lvxus.postion.SubmarinePostion;
import com.lvxus.powercomsumption.PowerComsumption;

import java.util.List;

public class Result {

    public static void main(String[] args) {
        sentOutDay1Part1Result();
        sentOutDay1Part2Result();
        sentOutDay2Part1Result();
        sentOutDay2Part2Result();
        sentOutDay3Part1Result();
    }



    private static void sentOutDay1Part1Result() {
        List<Integer> measurements = ReadText.readIntTextFile("E:\\TDDpractise\\adventCodeGame\\src\\test\\java\\measurements.txt", "utf-8");
        MeasureMent measureMent = new MeasureMent();
        measureMent.setMeasureMentsAndSliding("",measurements);
        System.out.println("Day1Part1:"+measureMent.getLargerTimes());
    }
    private static void sentOutDay1Part2Result() {
        List<Integer> measurements = ReadText.readIntTextFile("E:\\TDDpractise\\adventCodeGame\\src\\test\\java\\measurements.txt", "utf-8");
        MeasureMent measureMent = new MeasureMent();
        measureMent.setMeasureMentsAndSliding("sliding",measurements);
        System.out.println("Day1Part2:"+measureMent.getLargerTimes());
    }

    private static void sentOutDay2Part1Result() {
        List<String> measurements = ReadText.readStringTextFile("E:\\TDDpractise\\adventCodeGame\\src\\test\\java\\submarineMove.txt", "utf-8");
        SubmarinePostion submarinePostion = new SubmarinePostion();
        submarinePostion.setDiveActions(measurements);
        System.out.println("DAY2Part1:"+submarinePostion.getTotalHorizontal()*submarinePostion.getAim());
    }
    private static void sentOutDay2Part2Result() {
        List<String> diveActions = ReadText.readStringTextFile("E:\\TDDpractise\\adventCodeGame\\src\\test\\java\\submarineMove.txt", "utf-8");
        SubmarinePostion submarinePostion = new SubmarinePostion();
        submarinePostion.setDiveActions(diveActions);
        System.out.println("DAY2Part2:"+submarinePostion.getTotalDepth()*submarinePostion.getTotalHorizontal());
    }
    private static void sentOutDay3Part1Result() {
        List<String> diagnosticReport = ReadText.readStringTextFile("E:\\TDDpractise\\adventCodeGame\\src\\test\\java\\diagnosticReport.txt", "utf-8");
        PowerComsumption powerComsumption = new PowerComsumption();
        String gammaRate = powerComsumption.getGammaRate(diagnosticReport);
        String epsilonRate = powerComsumption.getEpsilonRate(diagnosticReport);
        System.out.println("DAY3:"+powerComsumption.getComsumption(gammaRate,epsilonRate));
    }
}
