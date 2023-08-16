package org.proxy;

import java.lang.reflect.*;
import java.util.*;

/**
 * This program demonstrates the use of proxies.
 * Implementing the listing 6.10 of the book Core Java I, by Cay Horstmann
 * @version 1.00 2023-08-15
 * @author joaoGHF
 */
class ProxiTest {
    public static void main(String[] args) {
        Object[] elements = new Object[1000];

        for (int i = 0; i < elements.length; i++) {
            Integer value = i + 1;
            InvocationHandler handler = new TraceHandler(value);
            Object proxy = Proxy.newProxyInstance(null, new Class[] { Comparable.class}, handler);

            elements[i] = proxy;
        }

        Integer key = new Random().nextInt(elements.length) + 1;

        int result = Arrays.binarySearch(elements, key);

        if (result >= 0) {
            System.out.println(elements[result]);
        }
    }
}

/**
 * An invocation handler that prints out the method name and parameters,
 * then invokes the original method
 */
class TraceHandler implements InvocationHandler {
    private Object target;

    /**
     * Contructor that receives a Object to be inside in the proxy
     * @param target
     */
    public TraceHandler(Object target) {
        this.target = target;
    }

    /**
     * The {@code invoke} method run a method with his parameters 
     */
    public Object invoke(Object proxy, Method m, Object[] args) throws Throwable {
        System.out.print(target);
        System.out.print("." + m.getName() + "(");

        if (args != null) {
            for (int i = 0; i < args.length; i++) {
                System.out.print(args[i]);
                if (i < args.length - 1) {
                    System.out.println(", ");
                }
            }
        }

        System.out.println(")");

        return m.invoke(target, args);
    }
}