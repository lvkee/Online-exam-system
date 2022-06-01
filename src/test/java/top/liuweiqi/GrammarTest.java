package top.liuweiqi;

import org.junit.Test;

import java.util.HashMap;

public class GrammarTest {

    @Test
    public void test01() {
        int score = 996;
        System.out.println(String.format("%.1f", score / 10.0));
    }

    @Test
    public void test02() {
        HashMap<String, String> levelMap = new HashMap<>();
        HashMap<String, String> sexMap = new HashMap<>();
        levelMap.put("1", "一年级");
        levelMap.put("2", "二年级");
        levelMap.put("3", "三年级");
        levelMap.put("4", "四年级");
        levelMap.put("5", "五年级");
        levelMap.put("6", "六年级");
        levelMap.put("7", "初一");
        levelMap.put("8", "初二");
        levelMap.put("9", "初三");
        levelMap.put("10", "高一");
        levelMap.put("11", "高二");
        levelMap.put("12", "高三");
        System.out.println(levelMap.get("1"));
    }
}
