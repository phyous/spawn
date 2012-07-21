package org.phyous.spawn;

import org.phyous.spawn.generator.Generator;

import java.lang.reflect.Constructor;

/**
 * Created with IntelliJ IDEA.
 * User: pyoussef
 * Date: 7/21/12
 * Time: 10:52 AM
 * To change this template use File | Settings | File Templates.
 */
public class Spawn {
    public static <T> T createObject(Class c){
        Constructor []constructors = c.getConstructors();
        // If the object has no constructors, return null
        if(constructors.length == 0) return null;

        // Take the first constructor and iterate over parameters
        Constructor con = constructors[0];
        Class []paramClasses = con.getParameterTypes();
        Object []args = new Object[paramClasses.length];

        for(int i = 0; i < paramClasses.length;i++){

            Object o = Generator.generate(paramClasses[i]);
            if(o != null) // Check if this parameter is a primitive type
                args[i] = o;
            else // If it isn't, recurse
                // If the object has itself as a constructor parameter, return null
                if(paramClasses[i].equals(c))
                    args[i] = null;
                else
                    args[i] = createObject(paramClasses[i]);
        }

        T ret = null;
        try{
            ret = (T)con.newInstance(args);
        } catch (Exception e){
            // We did our best, return null object if we fail
            return null;
        }
        return ret;
    }
}
