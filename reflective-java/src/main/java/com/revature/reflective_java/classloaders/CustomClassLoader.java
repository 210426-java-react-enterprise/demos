package com.revature.reflective_java.classloaders;

import java.io.InputStream;
import java.util.Objects;

public class CustomClassLoader extends ClassLoader {

    @Override
    public Class<?> loadClass(String className) throws ClassNotFoundException {

        if (!className.contains("com.revature")) {
            return super.loadClass(className);
        }

        System.out.printf("Loading %s into memory\n", className);

        try {
            String formattedStr = className.replace('.', '/') + ".class";
            InputStream in = ClassLoader.getSystemResourceAsStream(formattedStr);
            byte[] buffer = new byte[100000];
            int length = Objects.requireNonNull(in).read(buffer);
            return defineClass(className, buffer, 0, length);
        } catch (Exception e) {
            e.printStackTrace();
        }

        throw new ClassNotFoundException();
    }
}
