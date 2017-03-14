package com.seleniumautomationproject.utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.io.File;

/**
 * Created by adityag on 3/12/17.
 */
public class ProjectUtilities {

    private final static String testProperties = "test.props";
    private static String userDirectoryPath = System.getProperty("user.dir");
    private static String seperator = File.separator;
    private static String testpropsFilePath = new File(userDirectoryPath).getAbsolutePath() + seperator + testProperties;
    private static Properties props;

    public static void loadProperties() {
        try {
            FileReader reader = new FileReader(testpropsFilePath);
            props = new Properties();
            props.load(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static String getBrowserName() {
        if (props == null) {
            loadProperties();
    }
        return props.getProperty("browserName");
    }


    public static String getURLName() {
        if (props == null) {
            loadProperties();
        }

        return props.getProperty("URL");
    }


    public static String getHostName(){
        if(props == null){
            loadProperties();
        }
        return props.getProperty("hostName");
    }
}
