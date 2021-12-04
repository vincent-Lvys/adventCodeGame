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
        sentOutDay3Part2Result();
    }



    private static void sentOutDay1Part1Result() {
        List<Integer> measurements = ReadText.readIntTextFile("E:\\TDDpractise\\adventCodeGame\\src\\test\\java\\measurements.txt", "utf-8");
        MeasureMent measureMent = new MeasureMent();
        measureMent.setMeasureMentsAndSliding("",measurements);
        System.out.println("DAY1PART1:"+measureMent.getLargerTimes());
    }
    private static void sentOutDay1Part2Result() {
        List<Integer> measurements = ReadText.readIntTextFile("E:\\TDDpractise\\adventCodeGame\\src\\test\\java\\measurements.txt", "utf-8");
        MeasureMent measureMent = new MeasureMent();
        measureMent.setMeasureMentsAndSliding("sliding",measurements);
        System.out.println("DAY1PART2:"+measureMent.getLargerTimes());
    }

    private static void sentOutDay2Part1Result() {
        List<String> measurements = ReadText.readStringTextFile("E:\\TDDpractise\\adventCodeGame\\src\\test\\java\\submarineMove.txt", "utf-8");
        SubmarinePostion submarinePostion = new SubmarinePostion();
        submarinePostion.setDiveActions(measurements);
        System.out.println("DAY2PART1:"+submarinePostion.getTotalHorizontal()*submarinePostion.getAim());
    }
    private static void sentOutDay2Part2Result() {
        List<String> diveActions = ReadText.readStringTextFile("E:\\TDDpractise\\adventCodeGame\\src\\test\\java\\submarineMove.txt", "utf-8");
        SubmarinePostion submarinePostion = new SubmarinePostion();
        submarinePostion.setDiveActions(diveActions);
        System.out.println("DAY2PART2:"+submarinePostion.getTotalDepth()*submarinePostion.getTotalHorizontal());
    }
    private static void sentOutDay3Part1Result() {
        List<String> diagnosticReport = ReadText.readStringTextFile("E:\\TDDpractise\\adventCodeGame\\src\\test\\java\\diagnosticReport.txt", "utf-8");
        PowerComsumption powerComsumption = new PowerComsumption();
        String gammaRate = powerComsumption.getGammaRate(diagnosticReport);
        String epsilonRate = powerComsumption.getEpsilonRate(diagnosticReport);
        System.out.println("DAY3PART1:"+powerComsumption.getComsumption(gammaRate,epsilonRate));
    }
    private static void sentOutDay3Part2Result() {
        List<String> diagnosticReport = ReadText.readStringTextFile("E:\\TDDpractise\\adventCodeGame\\src\\test\\java\\diagnosticReport.txt", "utf-8");
        PowerComsumption powerComsumption = new PowerComsumption();
        String oxygenGeneratorRating = powerComsumption.getOxygenGeneratorRating(diagnosticReport);
        String co2ScrubberRating = powerComsumption.getCO2ScrubberRating(diagnosticReport);
        System.out.println("DAY3PART2:"+powerComsumption.getComsumption(oxygenGeneratorRating,co2ScrubberRating));
    }

}
