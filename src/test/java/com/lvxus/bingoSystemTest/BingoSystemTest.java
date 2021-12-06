package com.lvxus.bingoSystemTest;

import com.google.common.base.Strings;
import com.lvxus.bingoSystem.BingoSystem;
import com.lvxus.common.ReadText;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BingoSystemTest {

    @Test
    public void should_return_null_as_index_is_0_1_given_bingo_board_and_mark_value_8() {
        BingoSystem bingoSystem = new BingoSystem();
        String markValue = "8";
        String bingoBoardText = "90  8  2 34 41\n" +
                "11 67 74 71 62\n" +
                "47 42 44  1 17\n" +
                "21 55 12 91  6\n" +
                "60 69 75 92 56";
        String[] rowList = bingoBoardText.split("\n");
        String[][] bingoBoard = new String[5][5];
        for (int i = 0; i < rowList.length; i++) {
            bingoBoard[i] = Arrays.stream(rowList[i].split(" ")).filter(row -> !Strings.isNullOrEmpty(row)).collect(Collectors.toList()).toArray(new String[5]);
        }
        bingoSystem.markValueToBingoBoard(bingoBoard, markValue);
        assertNull(bingoBoard[0][1]);
    }

    @Test
    public void should_return_full_fill_given_5_row_mark_value() {
        String[][] markValueBoard = new String[][]{{"90", "8", "2", "34", "41"}, {"11", "67", "74", "71", "62"}, {null, null, null, null, null}, {"21", "55", "12", "91", "6"}, {"60", "69", "75", "92", "56"}};
        BingoSystem bingoSystem = new BingoSystem();
        boolean isFulFill = bingoSystem.isFulFill(markValueBoard);
        assertTrue(isFulFill);
    }

    @Test
    public void should_return_mark_value_boards_given_bingo_boards_and_mark_value() {
        BingoSystem bingoSystem = new BingoSystem();
        String markValue = "42";
        String bingoBoardText = "90  8  2 34 41\n" +
                "11 67 74 71 62\n" +
                "47 42 44  1 17\n" +
                "21 55 12 91  6\n" +
                "60 69 75 92 56\n" +
                "\n" +
                "49 29 60 45 31\n" +
                "94 51 73 33 67\n" +
                "21 92 53 95 96\n" +
                " 2 55 52  8 87\n" +
                " 4 36 76 83 42\n" +
                "\n" +
                "23 66 50 84 58\n" +
                "62 98 81 76 57\n" +
                "24  2 56 79  6\n" +
                "55  0 16 64 38\n" +
                "12 67  5 97 60";
        List<String> bingoBoardTextList = Arrays.stream(bingoBoardText.split("\n")).collect(Collectors.toList());
        List<String[][]> bingoBoardList = bingoSystem.getBingoBoardList(bingoBoardTextList);
        bingoSystem.markValueToBingoBoards(bingoBoardList, markValue);
        assertThat(bingoBoardList.get(0)[0][0], is("90"));
        assertNull(bingoBoardList.get(0)[2][1]);
        assertNull(bingoBoardList.get(1)[4][4]);

    }


    @Test
    public void should_return_mark_value_index_and_mark_value_given_mark_values_when_full_fill() {
        List<String> bingoBoardTextList = ReadText.readBingoBoardTextFile("G:\\TDDpractise\\adventCodeGame\\src\\test\\java\\bingoBoardText.txt", "utf-8");
        List<String> markValueList = ReadText.readBingoBoardTextFile("G:\\TDDpractise\\adventCodeGame\\src\\test\\java\\markValueText.txt", "utf-8");
        String sMarkValue = markValueList.get(0);
        List<String> markValues = Arrays.stream(sMarkValue.split(",")).collect(Collectors.toList());
        BingoSystem bingoSystem = new BingoSystem();
        List<String[][]> bingoBoardList = bingoSystem.getBingoBoardList(bingoBoardTextList);
        int multiplyResult = bingoSystem.getMultiplyResult(bingoBoardList, markValues);
        assertThat(bingoSystem.getFulFillMarkValue(), is("49"));
        assertThat(bingoSystem.getSumFulFillBingoBoard(bingoSystem.getFulFillBingoBoard()), is(473));
        assertThat(multiplyResult, is(23177));
    }


    @Test
    public void should_return_mark_value_index_and_mark_value_given_mark_values_when_full_fill_and_transform_bingo_board() {
        List<String> bingoBoardTextList = ReadText.readBingoBoardTextFile("G:\\TDDpractise\\adventCodeGame\\src\\test\\java\\bingoBoardText.txt", "utf-8");
        List<String> markValueList = ReadText.readBingoBoardTextFile("G:\\TDDpractise\\adventCodeGame\\src\\test\\java\\markValueText.txt", "utf-8");
        String sMarkValue = markValueList.get(0);
        List<String> markValues = Arrays.stream(sMarkValue.split(",")).collect(Collectors.toList());
        BingoSystem bingoSystem = new BingoSystem();
        List<String[][]> bingoBoardList = bingoSystem.getBingoBoardList(bingoBoardTextList);
        List<String[][]> transformBingoBoard = bingoSystem.transformBingoBoard(bingoBoardList);
        int multiplyResult = bingoSystem.getMultiplyResult(transformBingoBoard, markValues);
        assertThat(bingoSystem.getFulFillMarkValue(), is("80"));
        assertThat(bingoSystem.getSumFulFillBingoBoard(bingoSystem.getFulFillBingoBoard()), is(644));
        assertThat(multiplyResult, is(51520));
    }
}
