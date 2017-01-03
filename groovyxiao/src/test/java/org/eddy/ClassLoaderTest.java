package org.eddy;

import org.eddy.classLoader.MyUrlClassLoader;
import org.eddy.classLoader.Some;
import org.junit.Test;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Arrays;

/**
 * Created by eddy on 17/1/3.
 */
public class ClassLoaderTest {

    @Test
    public void test() throws Exception {
        MyUrlClassLoader urlClassLoader = new MyUrlClassLoader(new URL[]{new File("/Users/eddy/xiao/groovyxiao/target/groovy.xiao-1.0-SNAPSHOT.jar").toURI().toURL()});
        Class some1 = urlClassLoader.loadClass("org.eddy.classLoader.Some");
        System.out.println(some1.getClassLoader());
//        test2((Some) some1.newInstance()); //  child 转成 parent

        //parent 转成 child
        Method method = Arrays.stream(some1.getDeclaredMethods()).filter(s -> s.getName().equals("other")).findFirst().get();
        method.invoke(some1.newInstance(), new Some());
    }

    public void test2(Some some) {
        System.out.println(some.name("test"));
    }


}
