package org.eddy;

import org.assertj.core.util.Lists;
import org.eddy.classLoader.Some;
import org.junit.Test;

import javax.script.*;
import java.util.*;

/**
 * Created by eddy on 16/12/30.
 */
public class JsTest {

    @Test
    public void test() throws ScriptException {
        ScriptEngineManager engineManager = new ScriptEngineManager();
        ScriptEngine scriptEngine = engineManager.getEngineByName("javascript");
        Bindings bindings = scriptEngine.createBindings();
        List<Some> arg = new ArrayList<>();
        arg.add(new Some());
        Map<String, List<Some>> maps = new HashMap<>();
        maps.put("key", arg);
        bindings.put("i", 1L);
        bindings.put("arr", arg);
        bindings.put("map", maps);
//        Object object = scriptEngine.eval("function f(){return i + 1} function fx(){return arr[0]} f(); fx();", bindings);
        //function f(){for(var s in map.keySet()){return s;}}
//        Object object2 = scriptEngine.eval("function f(){return map.get('key')[0]} f(); ", bindings);
//        Object object2 = scriptEngine.eval("function f(){return map.keySet().toArray()[0]} f(); ", bindings);
//        Object object2 = scriptEngine.eval("function f(){var m = new org.eddy.classLoader.Some();return map.keySet().toArray()[0]} f(); ", bindings);
//        Object object2 = scriptEngine.eval("function f(){var m = new org.eddy.classLoader.Some();return m;} f(); ", bindings);
        //
        Object object2 = scriptEngine.eval("function f(){org.eddy.DBOp.print(); var m = new org.eddy.classLoader.Some();return m;} f(); ", bindings);
        System.out.println(object2);
    }
}
