package com.learnautomation.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigDataProvider {

    Properties mProporties;
    public ConfigDataProvider() {

        File src = new File("./Config/Config.properties");
        FileInputStream mFileInputStream = null;
        try {
            mFileInputStream = new FileInputStream(src);
            mProporties = new Properties();
            mProporties.load(mFileInputStream);
        } catch (Exception e) {
            System.out.println("Not able to log Config File >> " + e.getMessage());
        }
    }

    public String getDataFromConfig(String keyToSearch){
        return mProporties.getProperty(keyToSearch);
    }

    public String getBrowser(){
        return mProporties.getProperty("Browser");
    }

    public String getStagingURL(){
        return mProporties.getProperty("qaURL");
    }
}
