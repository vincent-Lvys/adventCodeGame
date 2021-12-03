package com.lvxus.common;

import com.google.common.collect.Lists;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.List;

public class ReadText {

    public static List<Integer> readIntTextFile(String path, String encoding) {

        List<Integer> result = Lists.newArrayList();
        File file = new File(path);
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        try {
            if (file.isFile() && file.exists()) {
                inputStreamReader = new InputStreamReader(new FileInputStream(file), encoding);
                bufferedReader = new BufferedReader(inputStreamReader);
                String textLine = null;
                while ((textLine = bufferedReader.readLine()) != null) {
                    result.add(Integer.parseInt(String.valueOf(textLine.split("\t")[0])));
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
                inputStreamReader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return result;
    }

    public static List<String> readStringTextFile(String path, String encoding) {
        List<String> result = Lists.newArrayList();
        File file = new File(path);
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        try {
            if (file.isFile() && file.exists()) {
                inputStreamReader = new InputStreamReader(new FileInputStream(file), encoding);
                bufferedReader = new BufferedReader(inputStreamReader);
                String textLine = null;
                while ((textLine = bufferedReader.readLine()) != null) {
                    result.add(textLine.split("\t")[0]);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
                inputStreamReader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return result;
    }
}
