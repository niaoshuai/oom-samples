package ren.shuaipeng.oom.basic;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * 模拟无法获取获取物理内存空间 操作系统资源被占尽 系统OOM-killer把程序强制给杀掉
 * @author niaoshuai
 */
public class OomKiller {

    public static void main(String[] args) throws IllegalAccessException {
        Field field = Unsafe.class.getDeclaredFields()[0];
        field.setAccessible(true);

        Unsafe unsafe = (Unsafe) field.get(null);

        while (true) {
            unsafe.allocateMemory(1024 * 1024);
        }
    }
}
