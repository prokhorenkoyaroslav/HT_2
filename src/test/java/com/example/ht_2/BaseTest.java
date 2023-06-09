package com.example.ht_2;

import com.example.ht_2.config.Driver;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    protected Logger logger;

    @BeforeClass
    public void setUp() {
        Driver.initDriver();

        logger = LogManager.getLogger("My Logger");

        PropertyConfigurator.configure("src/test/resources/log4j.properties");
    }

    @AfterMethod
    public void clearCookies() {
        Driver.clearCookies();
    }

    @AfterClass
    public void close() {
        Driver.close();
    }
}
