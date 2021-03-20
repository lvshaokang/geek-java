package com.red.geek.week01;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.nio.file.Files;

/**
 * 自定义ClassLoader
 *
 * @author red
 * @class_name CustomClassLoader
 * @date 2021-03-20
 */
public class CustomClassLoader extends ClassLoader {

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            URL resource = CustomClassLoader.class.getClassLoader().getResource("Hello.xlass");
            if (resource != null) {
                String path = resource.getPath();
                File file = new File(path);
                byte[] bytes = Files.readAllBytes(file.toPath());
                byte[] decoding = new byte[bytes.length];
                for (int i = 0; i < bytes.length; i++) {
                    decoding[i] = (byte) (255 - bytes[i]);
                }
                return defineClass(name, decoding, 0, decoding.length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return super.findClass(name);
    }

    public static void main(String[] args)  {
        try {
            CustomClassLoader classLoader = new CustomClassLoader();
            Class<?> clazz = classLoader.findClass("Hello");
            Method method = clazz.getDeclaredMethod("hello");
            method.invoke(clazz.newInstance());
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
