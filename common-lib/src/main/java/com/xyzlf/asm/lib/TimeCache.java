package com.xyzlf.asm.lib;

import java.util.HashMap;
import java.util.Map;

public class TimeCache {

    public static Map<String, Long> sStartTime = new HashMap<>();
    public static Map<String, Long> sEndTime = new HashMap<>();

    public static void setStartTime(String methodName, long time) {
        sStartTime.put(methodName, time);
    }

    public static void setEndTime(String methodName, long time) {
        sEndTime.put(methodName, time);
    }

    public static String getCostTime(String methodName) {
        long start = sStartTime.get(methodName);
        long end = sEndTime.get(methodName);
        return "[cost] " + methodName + " cost " + ((end - start) / 1000) + " microsecond";
    }

    public static void clear() {
        sStartTime.clear();
        sEndTime.clear();
    }

}
