package com.izeye.helloworld.noobjects;

import java.util.Objects;

/**
 * Component not using {@link Objects#requireNonNull(Object, String)}.
 *
 * @author Johnny Lim
 */
public class ComponentNotUsingObjects {

    public void doSomething(Object o) {
    }

}
