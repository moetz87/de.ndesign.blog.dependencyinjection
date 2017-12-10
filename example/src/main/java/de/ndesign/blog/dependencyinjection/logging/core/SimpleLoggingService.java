package de.ndesign.blog.dependencyinjection.logging.core;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;
import de.ndesign.blog.dependencyinjection.formatter.api.FormatterService;
import de.ndesign.blog.dependencyinjection.logging.api.LoggingService;

import java.io.PrintWriter;
import java.io.StringWriter;

@Singleton
public class SimpleLoggingService implements LoggingService {

    @Inject
    private MessageFragmentUtility messageFragmentUtility;
    @Inject
    @Named(value = "DefaultFormatter")
    private FormatterService formatter;

    public void info(String message, Object... messageFragments) {
        System.out.println(prepare(message, messageFragments));
    }

    public void error(String message, Object... messageFragments) {
        System.err.println(prepare(message, messageFragments));
    }

    public void error(Throwable cause, String message, Object... messageFragments) {
        System.err.println(prepare(message, messageFragments));
        StringWriter stringWriter = new StringWriter();
        new Throwable().printStackTrace(new PrintWriter(stringWriter));
        System.err.println(stringWriter.toString());
    }

    private String prepare(String message, Object... fragments) {
        message = this.messageFragmentUtility.replace(message, fragments);
        message = this.formatter.format(message);
        return message;
    }

}
