package de.ndesign.blog.dependencyinjection;

import com.google.inject.Guice;
import com.google.inject.Injector;
import de.ndesign.blog.dependencyinjection.configuration.ConfigurationModule;
import de.ndesign.blog.dependencyinjection.formatter.FormatterModule;
import de.ndesign.blog.dependencyinjection.logging.LoggingModule;
import de.ndesign.blog.dependencyinjection.logging.api.LoggingService;

public class Main {

    public static void main(String[] args) {
        // Injector
        Injector injector = Guice.createInjector(
                new ConfigurationModule(),
                new FormatterModule(),
                new LoggingModule()
        );

        LoggingService loggingService = injector.getInstance(LoggingService.class);
        loggingService.info("Starting {}", "main()");
        loggingService.error(new RuntimeException(), "Unknown Error occured.");
        loggingService.info("Ending {}", "main()");
    }

}
