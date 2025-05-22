package oo2.ejercicio2.logger.handler;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class JSONHandler extends Handler {

    private Handler handler;

    public JSONHandler(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void publish(LogRecord record) {
        record.setMessage(record.getMessage() + ",");
        handler.publish(record);
    }

    @Override
    public void flush() {
        this.handler.flush();
    }

    @Override
    public void close() {
        this.handler.close();
    }
}
