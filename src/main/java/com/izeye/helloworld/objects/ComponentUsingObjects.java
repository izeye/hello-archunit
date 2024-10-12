package com.izeye.helloworld.objects;

import java.util.Objects;

/**
 * Component using {@link Objects#requireNonNull(Object, String)}.
 *
 * @author Johnny Lim
 */
public class ComponentUsingObjects {

    public void doSomething(Object o) {
        Objects.requireNonNull(o, "o should not be null.");
    }

}
