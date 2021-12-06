package com.lvxus.bingoSystem;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BingoSystem {
    private String fulFillMarkValue = "";
    private String[][] fulFillBingoBoard = new String[5][5];
    private boolean fulFill = false;

    public boolean isFulFill(String[][] markValueBoard) {
        for (int i = 0; i < markValueBoard.length; i++) {
            long count = Arrays.stream(markValueBoard[i]).filter(row -> Strings.isNullOrEmpty(row)).count();
            if (count == 5) {
                this.fulFill = true;
                return true;
            }
        }
        return false;
    }

    public String getFulFillMarkValue() {
        return this.fulFillMarkValue;
    }

    public List<String[][]> transformBingoBoard(List<String[][]> bingoBoards) {
        List<String[][]> bingoBoardAfterTransforms = Lists.newArrayList();
        for (String[][] bingoBoard : bingoBoards) {
            String[][] bingoBoardAfterTransform = new String[5][5];
            for (int i = 0; i < bingoBoard.length; i++) {
                for (int j = 0; j < bingoBoard.length; j++) {
                    bingoBoardAfterTransform[i][j] = bingoBoard[j][i];
                }
            }
            bingoBoardAfterTransforms.add(bingoBoardAfterTransform);
        }
        return bingoBoardAfterTransforms;
    }

    public String[][] getFulFillBingoBoard() {
        return this.fulFillBingoBoard;
    }

    public List<String[][]> getBingoBoardList(List<String> bingoBoardTextList) {
        List<String[][]> bingoBoardList = Lists.newArrayList();
        String[][] bingoBoard = new String[5][5];
        int i = 0;
        for (String row : bingoBoardTextList) {
            if (Strings.isNullOrEmpty(row)) {
                bingoBoardList.add(bingoBoard);
                bingoBoard = new String[5][5];
                i = 0;
            } else {
                bingoBoard[i] = Arrays.stream(row.split(" ")).filter(rowValue -> !Strings.isNullOrEmpty(rowValue)).collect(Collectors.toList()).toArray(new String[5]);
                i++;
            }
        }
        bingoBoardList.add(bingoBoard);
        return bingoBoardList;
    }

    public void markValueToBingoBoard(String[][] bingoBoard, String markValue) {
        for (int i = 0; i < bingoBoard.length; i++) {
            for (int j = 0; j < bingoBoard[i].length; j++) {
                if (bingoBoard[i][j] == null) continue;
                if (bingoBoard[i][j].equals(markValue)) bingoBoard[i][j] = null;
            }
        }
    }

    public void markValueToBingoBoards(List<String[][]> bingoBoardList, String markValue) {
        for (String[][] bingoBoard : bingoBoardList) {
            markValueToBingoBoard(bingoBoard, markValue);
            if (isFulFill(bingoBoard)) {
                this.fulFillMarkValue = markValue;
                this.fulFillBingoBoard = bingoBoard;
                return;
            }
        }
    }

    public int getSumFulFillBingoBoard(String[][] fulFillBingoBoard) {
        int sum = 0;
        for (int i = 0; i < fulFillBingoBoard.length; i++) {
            sum += Arrays.stream(fulFillBingoBoard[i]).filter(gridValue->!Strings.isNullOrEmpty(gridValue)).mapToInt(Integer::parseInt).sum();
        }
        return sum;
    }

    public boolean getFulFill() {
        return this.fulFill;
    }

    public int getMultiplyResult(List<String[][]> bingoBoardList, List<String> markValues) {
        for (String markValue : markValues) {
            markValueToBingoBoards(bingoBoardList, markValue);
            if (getFulFill()) break;
        }
        int multiplyResult = getSumFulFillBingoBoard(getFulFillBingoBoard()) * Integer.parseInt(getFulFillMarkValue());
        return multiplyResult;
    }
}
