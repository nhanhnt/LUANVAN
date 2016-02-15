package com.shop.common;


import com.ftl.dictionary.Dictionary;
import com.ftl.dictionary.DictionaryNode;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Configuration {
	 private static final String IDS_PATH = "config.txt";
	    private static Dictionary mdicIDs;

	    static {
	        try {
	            loadIDsConfiguration(IDS_PATH);

	        } catch (Throwable t) {
	            Logger.getLogger("").log(Level.SEVERE, t.getMessage(), t);
	        }
	    }

	    public static void loadIDsConfiguration(String strConfigurationPath) throws IOException {
	        mdicIDs = new Dictionary(strConfigurationPath);
	    }

	    public static String getIDsValue(String strCode) {
	        if (mdicIDs == null) {
	            return null;
	        }
	        return mdicIDs.getString(strCode);
	    }

	   
	    public static void main(String[] args) {
	         String url_banner =Configuration.getIDsValue("username_database");
	         System.out.println(url_banner);
	    }
	}