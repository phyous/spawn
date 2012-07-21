package org.phyous.spawn.generator;

import java.util.Random;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: pyoussef
 * Date: 7/21/12
 * Time: 12:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class Generator {
    // Randomly generate an object of a given primitive type/class
    public static Object generate(Class c) {
        Random gen = new Random();

        if (c == String.class)
            return UUID.randomUUID().toString();
        else if (c == Boolean.class || c.getName() == "boolean")
            return (gen.nextInt(2) < 1);
        else if (c == Character.class || c.getName() == "char")
            return (char)(gen.nextInt(256));
        else if (c == Byte.class || c.getName() == "byte")
            return (byte)(gen.nextInt(256));
        else if (c == Short.class || c.getName() == "short")
            return (short) gen.nextInt(Short.MAX_VALUE);
        else if (c == Integer.class || c.getName() == "int")
            return gen.nextInt();
        else if (c == Long.class || c.getName() == "long")
            return gen.nextLong();
        else if (c == Float.class || c.getName() == "float")
            return gen.nextFloat();
        else if (c == Double.class || c.getName() == "double")
            return gen.nextDouble();
        else
            return null;
    }
}
