package org.eddy.classLoader;

import org.codehaus.groovy.control.CompilerConfiguration;

import java.io.File;
import java.net.*;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by eddy on 17/1/3.
 */
public class MyUrlClassLoader extends URLClassLoader {
    public MyUrlClassLoader(URL[] urls) {
        super(urls, Thread.currentThread().getContextClassLoader());
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        if (name.contains("eddy")) {
            return findClass(name);
        } else {
            return super.loadClass(name);
        }
//        return super.loadClass(name);
    }

}
