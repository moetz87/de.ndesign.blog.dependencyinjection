package de.ndesign.blog.dependencyinjection.logging.api;

public interface LoggingService {

    public void info(String message, Object... messageFragments);

    public void error(String message, Object... messageFragments);

    public void error(Throwable cause, String message, Object... messageFragments);

}
