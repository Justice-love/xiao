package org.eddy;

import groovy.lang.GroovyClassLoader;
import org.junit.Test;

/**
 * Created by eddy on 2016/12/27.
 */
public class Include {

    @Test
    public void test() {
        A a = new A();
        System.out.println(a.getName());
        System.out.println(a.a());
    }

    @Test
    public void test2() {
        String groovyClass = "class A {" +
                "def a() {" +
                "'a'" +
                "}" +
                "}";
        GroovyClassLoader groovyClassLoader = new GroovyClassLoader(Include.class.getClassLoader());
        Class glass = groovyClassLoader.parseClass(groovyClass);
        System.out.println(glass.getName());
    }
}
