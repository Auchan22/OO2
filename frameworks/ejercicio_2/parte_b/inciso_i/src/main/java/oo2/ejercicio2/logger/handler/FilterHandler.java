package oo2.ejercicio2.logger.handler;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class FilterHandler extends Handler {
    private Handler handler;
    private List<String> wordsToHide;

    public FilterHandler(Handler handler, List<String> wordsToHide) {
        this.handler = handler;
        this.wordsToHide = wordsToHide;
    }

    public FilterHandler(Handler handler) {
        this.handler = handler;
        this.wordsToHide = new ArrayList<String>();
    }

    public void addWord (String word) {
        this.wordsToHide.add(word);
    }

    private String censorWords(String msg) {
        for (String word: wordsToHide) {
            if (msg.contains(word)) {
                msg = msg.replaceAll(word, "***");
            }
        }
        return msg;
    }


    @Override
    public void publish(LogRecord record) {
        record.setMessage(censorWords(record.getMessage()));
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
