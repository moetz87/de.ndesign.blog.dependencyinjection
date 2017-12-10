package de.ndesign.blog.dependencyinjection.logging;

import com.google.inject.AbstractModule;
import de.ndesign.blog.dependencyinjection.logging.api.LoggingService;
import de.ndesign.blog.dependencyinjection.logging.core.MessageFragmentUtility;
import de.ndesign.blog.dependencyinjection.logging.core.SimpleLoggingService;

public class LoggingModule extends AbstractModule {

    protected void configure() {
        // Linked Binding
        bind(LoggingService.class).to(SimpleLoggingService.class);
        // Untargeted Binding
        bind(MessageFragmentUtility.class);
    }

}
