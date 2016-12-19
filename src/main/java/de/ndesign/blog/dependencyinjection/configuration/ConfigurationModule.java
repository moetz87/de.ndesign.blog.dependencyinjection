package de.ndesign.blog.dependencyinjection.configuration;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

public class ConfigurationModule extends AbstractModule {

    protected void configure() {
        // Named Annotation + Instance Binding
        bind(String.class)
                .annotatedWith(Names.named("Logging#Placeholder"))
                .toInstance("\\{\\}");
        bind(String.class)
                .annotatedWith(Names.named("Logging#DateFormat"))
                .toInstance("yyyy-MM-dd, HH:mm.ss");
    }

}
