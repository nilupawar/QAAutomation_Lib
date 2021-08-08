package com.nilesh.lib.util;

import com.nilesh.lib.config.TestConfig;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Utility {
    public static <T> boolean isSorted(List<T> items, SortType sortType) {
        List<T> sorted = new ArrayList<>(items);
        if (sortType == SortType.DESC) {
            sorted.sort(Collections.reverseOrder());
        }
        if (sortType == SortType.ASC) {
            sorted = sorted.stream().sorted().collect(Collectors.toList());
        }
        return sorted.equals(items);
    }

    public static String getScreenshotFileName() {
        return "Screenshot_" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + ".PNG";
    }

    public static int parseInt(String intString) {
        return Integer.parseInt(intString);
    }

    public static int parseIntTestConfig(String intString) {
        return parseInt(TestConfig.getConfig(intString));
    }

}
