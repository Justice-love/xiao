package org.eddy;

import groovy.lang.Binding;
import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyShell;
import org.eddy.classLoader.MyClassLoader;
import org.junit.Test;

/**
 * Created by eddy on 16/12/30.
 */
public class ScriptTest {

    @Test
    public void test() {
        Binding binding = new Binding();
        GroovyShell shell = new GroovyShell(new MyClassLoader(), binding);
        shell.evaluate("import org.eddy.DBOp\n" +
                "DBOp.print()");
    }
}
