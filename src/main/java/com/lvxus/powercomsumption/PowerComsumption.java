package com.lvxus.powercomsumption;

import java.util.List;

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
        String gammaRate = "";
        int bitLength = report.get(0).toCharArray().length;
        for (int i = 0; i < bitLength; i++) {
            for (String commonBits : report) {
                char[] bitChars = commonBits.toCharArray();
                isOne = getIsOne(isOne,String.valueOf(bitChars[i]));
            }
            gammaRate = isOne <= 0?gammaRate+"1":gammaRate+"0";
            isOne = 0;
        }

        return gammaRate;
    }

    public Integer getComsumption(String gammaRate, String epsilonRate) {
        int gammaDecimal = Integer.parseInt(gammaRate,2);
        int epsilonDecimal = Integer.parseInt(epsilonRate,2);
        return gammaDecimal*epsilonDecimal;
    }
}
