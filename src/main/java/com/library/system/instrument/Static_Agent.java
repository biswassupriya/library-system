package com.library.system.instrument;

import java.lang.instrument.Instrumentation;

public class Static_Agent {

    public static void premain(String agentArgs, Instrumentation inst) {
        String[] tokens = agentArgs.split(";");
        String className = tokens[0];
        String methodName = tokens[1];

        System.out.println(">> "+className);
        System.out.println(">> "+methodName);
        transformClass(className, methodName, inst);
    }



    public static void transformClass(String className, String methodName, Instrumentation instrumentation) {
        Class<?> targetCls = null;
        ClassLoader targetClassLoader = null;
        // see if we can get the class using forName
        try {
            targetCls = Class.forName(className);
            targetClassLoader = targetCls.getClassLoader();
            transform(targetCls, methodName, targetClassLoader, instrumentation);
            return;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        // otherwise iterate all loaded classes and find what we want
        for(Class<?> clazz: instrumentation.getAllLoadedClasses()) {
            if(clazz.getName().equals(className)) {
                targetCls = clazz;
                targetClassLoader = targetCls.getClassLoader();
                transform(targetCls, methodName, targetClassLoader, instrumentation);
                return;
            }
        }
        throw new RuntimeException("Failed to find class [" + className + "]");
    }


    public static void transform(Class<?> clazz, String methodName, ClassLoader classLoader, Instrumentation instrumentation) {
        Transformer dt = new Transformer(clazz.getName(), methodName, classLoader);
        instrumentation.addTransformer(dt, true);
        try {
            instrumentation.retransformClasses(clazz);
        } catch (Exception ex) {
            throw new RuntimeException("Transform failed for class: [" + clazz.getName() + "]", ex);
        }
    }



}