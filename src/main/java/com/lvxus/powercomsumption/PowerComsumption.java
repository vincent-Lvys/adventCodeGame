package com.lvxus.powercomsumption;

import java.util.List;
import java.util.stream.Collectors;

public class PowerComsumption {


    public String getGammaRate(List<String> report) {
        int isOne = 0;
        String gammaRate = "";
        int bitLength = report.get(0).toCharArray().length;
        for (int i = 0; i < bitLength; i++) {
            for (String commonBits : report) {
                char[] bitChars = commonBits.toCharArray();
                isOne = getIsOne(isOne,String.valueOf(bitChars[i]));
            }
            gammaRate = isOne >= 0?gammaRate+"1":gammaRate+"0";
            isOne = 0;
        }

        return gammaRate;
    }

    private int getIsOne(int isOne, String commonBit) {
        if ("1".equals(commonBit)){
            isOne++;
        }else {
            isOne--;
        }
        return isOne;
    }

    public String getEpsilonRate(List<String> report) {
        int isOne = 0;
        String epsilonRate = "";
        int bitLength = report.get(0).toCharArray().length;
        for (int i = 0; i < bitLength; i++) {
            for (String commonBits : report) {
                char[] bitChars = commonBits.toCharArray();
                isOne = getIsOne(isOne,String.valueOf(bitChars[i]));
            }
            epsilonRate = isOne >= 0?epsilonRate+"0":epsilonRate+"1";
            isOne = 0;
        }

        return epsilonRate;
    }

    public Integer getComsumption(String gammaRate, String epsilonRate) {
        int gammaDecimal = Integer.parseInt(gammaRate,2);
        int epsilonDecimal = Integer.parseInt(epsilonRate,2);
        return gammaDecimal*epsilonDecimal;
    }

    public String getOxygenGeneratorRating(List<String> report) {
        String oxygenGeneratorRating = "";
        int bitLength = report.get(0).toCharArray().length;
        for (int i = 0; i < bitLength; i++) {
            int indexed = i;
            List<String> oneList = report.stream().filter(commonBit -> "1".equals(String.valueOf(commonBit.toCharArray()[indexed]))).collect(Collectors.toList());
            List<String> zeroList = report.stream().filter(commonBit -> "0".equals(String.valueOf(commonBit.toCharArray()[indexed]))).collect(Collectors.toList());
            report = oneList.size()>=zeroList.size()?oneList:zeroList;
            if (report.size() == 1){
                oxygenGeneratorRating = report.get(0);
            }
        }
        return oxygenGeneratorRating;
    }

    public String getCO2ScrubberRating(List<String> report) {
        String co2ScrubberRating = "";
        int bitLength = report.get(0).toCharArray().length;
        for (int i = 0; i < bitLength; i++) {
            int indexed = i;
            List<String> oneList = report.stream().filter(commonBit -> "1".equals(String.valueOf(commonBit.toCharArray()[indexed]))).collect(Collectors.toList());
            List<String> zeroList = report.stream().filter(commonBit -> "0".equals(String.valueOf(commonBit.toCharArray()[indexed]))).collect(Collectors.toList());
            report = zeroList.size()<=oneList.size()?zeroList:oneList;
            if (report.size() == 1){
                co2ScrubberRating = report.get(0);
            }
        }
        return co2ScrubberRating;
    }
}
