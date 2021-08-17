package com.nilesh.lib.util;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UtilityTest {

    @Test
    public void isSortedAscTrue() {
        List<Integer> list = Arrays.asList(1, 2, 5, 8, 10);
        assertTrue("List not in ascending order", Utility.isSorted(list, SortType.ASC));
    }

    @Test
    public void isSortedAscFalse() {
        List<Integer> list = Arrays.asList(1, 6, 3, 8, 5);
        assertFalse("List in ascending order", Utility.isSorted(list, SortType.ASC));
    }

    @Test
    public void isSortedDecTrue() {
        List<Integer> list = Arrays.asList(100, 66, 7, 6, 1);
        assertTrue("List not in descending order", Utility.isSorted(list, SortType.DESC));
    }

    @Test
    public void isSortedDecFalse() {
        List<Integer> list = Arrays.asList(1, 6, 3, 8, 5);
        assertFalse("List in descending order", Utility.isSorted(list, SortType.DESC));
    }

    @Test
    public void validScreenShotFileName() {
        String screenshotFileName = Utility.getScreenshotFileName();
        Pattern pattern = Pattern.compile("^Screenshot_[0-9]{14}.PNG$");
        assertTrue("File name does not match defined pattern", pattern.matcher(screenshotFileName).matches());
    }
}