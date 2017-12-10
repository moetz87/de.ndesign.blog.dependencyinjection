package de.ndesign.blog.dependencyinjection.formatter.core;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;
import de.ndesign.blog.dependencyinjection.formatter.api.FormatterService;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

@Singleton
public class MessageWithDateFormatterService implements FormatterService {

    @Inject
    @Named(value = "Logging#DateFormat")
    private String dateFormat;

    @Override
    public String format(String message) {
        return (getTimestamp() + "   " + message);
    }

    private String getTimestamp() {
        GregorianCalendar now = new GregorianCalendar();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
        simpleDateFormat.setCalendar(now);
        String dateFormatted = simpleDateFormat.format(now.getTime());
        return dateFormatted;
    }

}
