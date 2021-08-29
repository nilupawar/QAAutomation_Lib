package com.nilesh.lib.util;

import com.nilesh.lib.config.TestConfig;
import org.junit.Assert;
import org.junit.Test;

public class TestConfigTest {

    @Test
    public void correctTestConfigValue(){
        String propName = "object.wait.time.macro";
        String propValue = "10";
        Assert.assertEquals(propValue, TestConfig.getConfig(propName));
    }
}
