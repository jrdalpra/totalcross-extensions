package com.wolkenapps.tcunitext.main;

import java.lang.reflect.Method;

import org.reflections.Reflections;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;

import totalcross.MainClass;
import totalcross.unit.TestCase;

public abstract class MainForTests implements MainClass {

    private Class[] testClasses;

    public MainForTests(String[] packages) {
        testClasses = (Class[]) reflectiosBasedOn(packages).getSubTypesOf(TestCase.class).toArray(new Class[] {});
    }

    private Reflections reflectiosBasedOn(String[] packages) {
        ConfigurationBuilder configuration = new ConfigurationBuilder();
        for (int i = 0, size = packages.length; i < size; i++) {
            configuration = configuration.addUrls(ClasspathHelper.forPackage(packages[i], null));
        }
        return new Reflections(configuration);
    }

    public void _onTimerTick(boolean canUpdate) {
    }

    public void _postEvent(int type, int key, int x, int y, int modifiers, int timeStamp) {
    }

    public void appEnding() {
    }

    public void appStarting(int timeAvail) {
        try {
            Object instance = null;
            for (int i = 0; i < testClasses.length; i++) {
                instance = testClasses[i].newInstance();
                Method[] methods = testClasses[i].getMethods();
                for (int x = 0; x < methods.length; x++) {
                    if (methods[x].getName().startsWith("test")) {
                        System.out.println("Executing " + testClasses[i].getName() + " " + methods[x].getName());
                        methods[x].invoke(instance, null);
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
