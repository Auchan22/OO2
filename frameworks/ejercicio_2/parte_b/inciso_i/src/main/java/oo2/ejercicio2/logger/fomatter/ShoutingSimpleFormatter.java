package oo2.ejercicio2.logger.fomatter;

import java.util.logging.LogRecord;
import java.util.logging.SimpleFormatter;

public class ShoutingSimpleFormatter extends SimpleFormatter {
    @Override
    public String format(LogRecord record) {
        return super.format(record).toUpperCase();
    }
}
