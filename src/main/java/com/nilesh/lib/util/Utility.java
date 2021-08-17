package com.nilesh.lib.util;

import com.nilesh.lib.config.TestConfig;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import static com.nilesh.lib.util.SortType.ASC;
import static com.nilesh.lib.util.SortType.DESC;

public final class Utility {
    private Utility() {
    }

    public static <T extends Comparable<? super T>> boolean isSorted(List<T> items, SortType sortType) {
        List<T> sorted = new ArrayList<>(items);
        if (sortType == DESC) {
            sorted.sort(Comparator.reverseOrder());
        }
        if (sortType == ASC) {
            sorted.sort(Comparator.naturalOrder());
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
        return parseInt(TestConfig.getConfig(intString.trim()));
    }

}
