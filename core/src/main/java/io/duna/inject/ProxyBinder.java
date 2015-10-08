package io.duna.inject;

import io.duna.hypermedia.Resource;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.reflections.Reflections;

import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class ProxyBinder extends AbstractBinder {

    Reflections reflections;

    public ProxyBinder() {
        reflections = new Reflections();
    }

    @Override
    protected void configure() {
        Set<Class<?>> annotatedIfaces = reflections.getTypesAnnotatedWith(Resource.class);

        annotatedIfaces.forEach((iface) -> {
            //noinspection unchecked
            Set<Class<?>> implClasses = reflections.getSubTypesOf((Class) iface);
            implClasses.removeIf((clazz) -> clazz.isInterface() || Modifier.isAbstract(clazz.getModifiers()));

            if (implClasses.isEmpty()) {
                // Remote interface
            } else {
                if (implClasses.size() > 1) {
                    // Error, more than one implementation
                } else {
                    // OK
                }
            }

        });
    }
}
