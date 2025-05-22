package oo2.ejercicio2.logger.fomatter;

import org.json.simple.JSONObject;

import java.util.logging.Formatter;
import java.util.logging.LogRecord;


public class JSONFormatter extends Formatter {
    @Override
    public String format(LogRecord record) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("message", record.getMessage());
        jsonObject.put("level", ""+record.getLevel()+"");
        return jsonObject.toString();
    }
}
