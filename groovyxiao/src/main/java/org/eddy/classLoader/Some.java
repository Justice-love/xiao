package org.eddy.classLoader;

/**
 * Created by eddy on 17/1/3.
 */
public class Some {

    public String name(String name) {
        return String.join(": ", "name", name);
    }

    public void other(Some some) {
        System.out.println(some);
    }
}
