package org.eddy;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import org.junit.Test;

/**
 * Created by eddy on 16/12/30.
 */
public class ScriptTest {

    @Test
    public void test() {
        Binding binding = new Binding();
        GroovyShell shell = new GroovyShell(binding);
        shell.evaluate("import org.eddy.DBOp\n" +
                "DBOp.print()");
    }
}
