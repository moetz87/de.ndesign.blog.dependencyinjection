package de.ndesign.blog.dependencyinjection.formatter;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import de.ndesign.blog.dependencyinjection.formatter.api.FormatterService;
import de.ndesign.blog.dependencyinjection.formatter.core.MessageWithDateFormatterService;

public class FormatterModule extends AbstractModule {

    @Override
    protected void configure() {
        // Named Annotation + Constructor Binding
        try {
            bind(FormatterService.class)
                    .annotatedWith(Names.named("DefaultFormatter"))
                    .toConstructor(MessageWithDateFormatterService.class.getConstructor());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

}
