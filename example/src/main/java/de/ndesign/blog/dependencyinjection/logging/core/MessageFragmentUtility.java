package de.ndesign.blog.dependencyinjection.logging.core;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

@Singleton
public class MessageFragmentUtility {

    @Inject
    @Named(value = "Logging#Placeholder")
    private String placeholder;

    public String replace(String message, Object... fragments) {
        for (Object fragment : fragments) {
            String replacement = (fragment == null) ? "NULL" : fragment.toString();
            message = message.replaceFirst(this.placeholder, replacement);
        }
        return message;
    }

}
