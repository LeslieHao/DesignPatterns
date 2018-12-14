package com.lesliehao.proxy.dynamicproxy;

import com.sun.beans.WeakCache;
import sun.misc.ProxyGenerator;
import sun.misc.VM;
import sun.reflect.CallerSensitive;
import sun.reflect.Reflection;
import sun.reflect.misc.ReflectUtil;
import sun.security.util.SecurityConstants;

import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.lang.reflect.*;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Arrays;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.BiFunction;

/**
 * JDK 动态代理源码
 *
 * @author HaoHao
 * @date 2018/12/14下午5:25
 */
public class ProxySource implements Serializable {

    private static final long serialVersionUID = -2222568056686623797L;


    /**
     * 代理类缓存
     */
    private static final WeakCache<ClassLoader, Class<?>[], Class<?>>
            proxyClassCache = new WeakCache<>(new Proxy.KeyFactory(), new Proxy.ProxyClassFactory());



    /**
     * 生成代理类方法
     */
    private static Class<?> getProxyClass0(ClassLoader loader, Class<?>... interfaces) {
        // 实现的接口数量限制
        if (interfaces.length > 65535) {
            throw new IllegalArgumentException("interface limit exceeded");
        }

        // 缓存中读取代理类,如果缓存不存在,将由ProxyClassFactory 创建代理类
        return proxyClassCache.get(loader, interfaces);
    }





    /**
     * 根据ClassLoader和Interface来创建代理类的工厂方法
     */
    private static final class ProxyClassFactory
            implements BiFunction<ClassLoader, Class<?>[], Class<?>> {
        // 代理类名前缀
        private static final String proxyClassNamePrefix = "$Proxy";

        // 每个代理类后缀后面都会跟着一个唯一的编号.$Proxy0 $Proxy1
        private static final AtomicLong nextUniqueNumber = new AtomicLong();

        @Override
        public Class<?> apply(ClassLoader loader, Class<?>[] interfaces) {

            Map<Class<?>, Boolean> interfaceSet = new IdentityHashMap<>(interfaces.length);
            for (Class<?> intf : interfaces) {

                Class<?> interfaceClass = null;
                try {
                    interfaceClass = Class.forName(intf.getName(), false, loader);
                } catch (ClassNotFoundException e) {
                }
                if (interfaceClass != intf) {
                    throw new IllegalArgumentException(
                            intf + " is not visible from class loader");
                }

                // 验证这个对象是否是接口
                if (!interfaceClass.isInterface()) {
                    throw new IllegalArgumentException(
                            interfaceClass.getName() + " is not an interface");
                }
                // 接口是否重复
                if (interfaceSet.put(interfaceClass, Boolean.TRUE) != null) {
                    throw new IllegalArgumentException(
                            "repeated interface: " + interfaceClass.getName());
                }
            }

            // 代理类所在的包
            String proxyPkg = null;
            int accessFlags = Modifier.PUBLIC | Modifier.FINAL;

            /*
             * 验证所有非pubLic代理接口都在同一个包.同时记录一个非public代理接口的包
             */
            for (Class<?> intf : interfaces) {
                int flags = intf.getModifiers();
                if (!Modifier.isPublic(flags)) {
                    accessFlags = Modifier.FINAL;
                    String name = intf.getName();
                    int n = name.lastIndexOf('.');
                    String pkg = ((n == -1) ? "" : name.substring(0, n + 1));
                    if (proxyPkg == null) {
                        proxyPkg = pkg;
                    } else if (!pkg.equals(proxyPkg)) {
                        throw new IllegalArgumentException(
                                "non-public interfaces from different packages");
                    }
                }
            }

            if (proxyPkg == null) {
                // 如果全是public 代理接口,那么生成的代理类在 com.sun.proxy 下
                proxyPkg = ReflectUtil.PROXY_PACKAGE + ".";
            }

            /*
             * 生成代理类名
             * 如:com.sun.proxy.$Proxy0.class
             */
            long num = nextUniqueNumber.getAndIncrement();
            String proxyName = proxyPkg + proxyClassNamePrefix + num;

            /*
             * 生成代理类的自节目文件,字节数组
             */
            byte[] proxyClassFile = ProxyGenerator.generateProxyClass(
                    proxyName, interfaces, accessFlags);
            try {
                // 调用native方法生成class 完成代理类的生成
                return defineClass0(loader, proxyName,
                        proxyClassFile, 0, proxyClassFile.length);
            } catch (ClassFormatError e) {
                /*
                 * A ClassFormatError here means that (barring bugs in the
                 * proxy class generation code) there was some other
                 * invalid aspect of the arguments supplied to the proxy
                 * class creation (such as virtual machine limitations
                 * exceeded).
                 */
                throw new IllegalArgumentException(e.toString());
            }
        }
    }


    @CallerSensitive
    public static Object newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h)
            throws IllegalArgumentException {

        // 为空校验
        Objects.requireNonNull(h);

        // 拷贝代理类实现的所有接口的class 数组
        final Class<?>[] intfs = interfaces.clone();

        // 安全检查校验,确保当前系统有对被代理类的代理权限
        final SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            checkProxyAccess(Reflection.getCallerClass(), loader, intfs);
        }

        /*
         * Look up or generate the designated proxy class.
         * 产生代理类
         */
        Class<?> cl = getProxyClass0(loader, intfs);

        /*
         * 根据cls 获取构造,生成代理对象
         */
        try {
            if (sm != null) {
                checkNewProxyPermission(Reflection.getCallerClass(), cl);
            }

            final Constructor<?> cons = cl.getConstructor(constructorParams);
            final InvocationHandler ih = h;
            // 如果不是public,反射 setAccessible
            if (!Modifier.isPublic(cl.getModifiers())) {
                AccessController.doPrivileged(new PrivilegedAction<Void>() {
                    public Void run() {
                        cons.setAccessible(true);
                        return null;
                    }
                });
            }
            // 发射生成对象
            return cons.newInstance(new Object[]{h});
        } catch (IllegalAccessException | InstantiationException e) {
            throw new InternalError(e.toString(), e);
        } catch (InvocationTargetException e) {
            Throwable t = e.getCause();
            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new InternalError(t.toString(), t);
            }
        } catch (NoSuchMethodException e) {
            throw new InternalError(e.toString(), e);
        }
    }




    private static native Class<?> defineClass0(ClassLoader loader, String name,
                                                byte[] b, int off, int len) {
    }
}
