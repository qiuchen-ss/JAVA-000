package com.geekbang.les01;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;

public class CustomerClassLoader extends ClassLoader {

    protected Class<?> findClass(String name) throws ClassNotFoundException {

        File file = new File("./Hello/" + name + ".xlass");
        try {
            byte[] content = Files.readAllBytes(file.toPath());
            byte[] fixedContent = new byte[content.length];
            for(int i=0; i<content.length; i++) {
                fixedContent[i] = (byte) (255 - content[i]);
            }
            return defineClass(name, fixedContent, 0, fixedContent.length);
        } catch (Exception e) {
            throw new ClassNotFoundException(name);
        }
    }

    public static void main(String[] args){

        try {
            Class target = new CustomerClassLoader().findClass("Hello");
            Object instance = target.newInstance();
            target.getDeclaredMethod("hello").invoke(instance);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}