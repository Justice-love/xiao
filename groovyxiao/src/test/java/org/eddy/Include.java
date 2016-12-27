package org.eddy;

import groovy.lang.Binding;
import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyShell;
import org.junit.Test;

import java.util.Date;

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

    /**
     * 简单脚本执行
     * @throws Exception
     */
    @Test
    public void evalScriptText() throws Exception{
        //groovy.lang.Binding
        Binding binding = new Binding();
        GroovyShell shell = new GroovyShell(binding);

        binding.setVariable("name", "justice-love");
        shell.evaluate("println 'Hello World! I am ' + name;");
        //在script中,声明变量,不能使用def,否则scrope不一致.
        shell.evaluate("date = new Date();");
        Date date = (Date)binding.getVariable("date");
        System.out.println("Date:" + date.getTime());
        //以返回值的方式,获取script内部变量值,或者执行结果
        //一个shell实例中,所有变量值,将会在此"session"中传递下去."date"可以在此后的script中获取
        Long time = (Long)shell.evaluate("def time = date.getTime(); return time;");
        System.out.println("Time:" + time);
        binding.setVariable("list", new String[]{"A","B","C"});
        //invoke method
        String joinString = (String)shell.evaluate("def call(){return list.join(' - ')};call();");
        System.out.println("Array join:" + joinString);
        shell = null;
        binding = null;
    }
}
