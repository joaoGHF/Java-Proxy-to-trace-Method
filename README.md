# Java-Proxy-to-trace-Method
A Java project to use proxies when tracing a method. This project has a class <a href="ProxyTest/src/org.proxy/ProxyTest.java">ProxyTest</a> with the `ProxyTest` and the `TraceHandler` classes.

## One possible output

Using this main method to trace the binary serch, one possible output is:

```
500.compareTo(249)
250.compareTo(249)
125.compareTo(249)
187.compareTo(249)
218.compareTo(249)
234.compareTo(249)
242.compareTo(249)
246.compareTo(249)
248.compareTo(249)
249.compareTo(249)
249.toString()
249
```