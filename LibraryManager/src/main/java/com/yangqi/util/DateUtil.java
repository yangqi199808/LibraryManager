package com.yangqi.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author xiaoer
 * @date 2019/12/21 16:17
 */
public class DateUtil {
    /**
     * 获取当前时间
     *
     * @return 当前时间的时间戳格式
     */
    public static Timestamp getNowDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        Date resultDate = calendar.getTime();
        return Timestamp.valueOf(dateFormat.format(resultDate));
    }

    /**
     * 获取当前时间向后30的时间
     *
     * @return 30天后的时间的时间戳格式
     */
    public static Timestamp afterThirtyDays() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE, 30);
        Date resultDate = calendar.getTime();
        return Timestamp.valueOf(dateFormat.format(resultDate));
    }
}
