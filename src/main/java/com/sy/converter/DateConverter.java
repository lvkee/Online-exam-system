package com.sy.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

/**
 * @author chris
 */
public class DateConverter implements Converter<Date, String> {
    @Override
    public String convert(Date s) {
        // 将日期串转换成日期格式（格式是yyyy-MM-dd）
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("执行到此处");
        //返回上述格式的Date类型对象
        System.out.println(s);
        System.out.println(simpleDateFormat.format(s));
        return simpleDateFormat.format(s);
    }
}
