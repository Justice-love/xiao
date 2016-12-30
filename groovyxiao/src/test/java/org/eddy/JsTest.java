package org.eddy;

import org.junit.Test;

import javax.script.*;

/**
 * Created by eddy on 16/12/30.
 */
public class JsTest {

    @Test
    public void test() throws ScriptException {
        ScriptEngineManager engineManager = new ScriptEngineManager();
        ScriptEngine scriptEngine = engineManager.getEngineByName("javascript");
        Bindings bindings = scriptEngine.createBindings();
        bindings.put("i", 1L);
        Object object = scriptEngine.eval("function f(){return i + 1}", bindings);
        System.out.println(object);
    }
}
