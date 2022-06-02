package com.sy.entity.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chris
 */

public enum  UserLevelEnum {

    One(1, "一年级"),
    Two(2, "二年级"),
    Three(3, "三年级"),
    Four(4, "四年级"),
    Five(5, "五年级"),
    Six(6, "六年级"),
    Seven(7, "初一"),
    Eight(8, "初二"),
    Nine(9, "初三"),
    Ten(10, "高一"),
    Eleven(11, "高二"),
    Twelve(12, "高三");

    int code;
    String level;

    UserLevelEnum(int code, String level) {
        this.code = code;
        this.level = level;
    }

    private static final Map<Integer, UserLevelEnum> keyMap = new HashMap<>();

    static {
        for (UserLevelEnum item : UserLevelEnum.values()) {
            keyMap.put(item.getCode(), item);
        }
    }

    public static UserLevelEnum fromCode(Integer code) {
        return keyMap.get(code);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
