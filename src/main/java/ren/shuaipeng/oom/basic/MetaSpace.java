package ren.shuaipeng.oom.basic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

/**
 * 元空间 类加载器空间
 *
 * @author niaoshuai
 */
public class MetaSpace {

    public static void main(String[] args) {
        List<ClassLoader> classLoaders = new ArrayList<>();
        while (true) {
            ClassLoader classLoader = new URLClassLoader(new URL[]{});
            Proxy.newProxyInstance(classLoader, new Class<?>[]{IDiaoBao.class},
                    new MetaSpaceInvocationHandler(new DiaoBaoImpl()));
            classLoaders.add(classLoader);
        }
    }


    public interface IDiaoBao {

    }

    public static class DiaoBaoImpl implements IDiaoBao {

    }

    public static class MetaSpaceInvocationHandler implements InvocationHandler {
        private Object impl;

        public MetaSpaceInvocationHandler(Object impl) {
            this.impl = impl;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            return method.invoke(impl, args);
        }
    }

}
