package utils;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class ParseUtil {

    private static final Logger logger = LogManager.getLogger(ParseUtil.class);

    public static String testParser(String label) {
        JSONParser parser = new JSONParser();
        String result = null;
        try (FileReader reader = new FileReader("src/test/resources/test.json")) {
            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            result = (String) jsonObject.get(label);
        } catch (ParseException e) {
            logger.fatal("ParseException!");
        } catch (IOException i) {
            logger.fatal("IOException!");
        }
        return result;
    }

    public static String settingsParser(String label) {
        JSONParser parser = new JSONParser();
        String result = null;
        try (FileReader reader = new FileReader("src/test/resources/settings.json")) {
            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            result = (String) jsonObject.get(label);
        } catch (ParseException e) {
            logger.fatal("ParseException!");
        } catch (IOException i) {
            logger.fatal("IOException!");
        }
        return result;
    }

    public static int parseStringToInt(String text) {
        return Integer.parseInt(text.replaceAll("[^0-9]", ""));
    }

    public static String getColor(String color) {
        String indicateColor = "";
        switch (color) {
            case ("rgba(63, 81, 181, 1)"):
                indicateColor = "blue";
                break;
            case ("rgba(0, 128, 0, 1)"):
                indicateColor = "green";
                break;
            default: indicateColor = "gray";
            break;
        }
        return indicateColor;
    }
}
