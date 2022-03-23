package ren.shuaipeng.oom.basic;

/**
 * 模拟栈区域 溢出
 * @author niaoshuai
 */
public class Stack {

    public static int index = 0;

    private static void test() {
        index++;
        test();
    }

    public static void main(String[] args) {
        try {
            test();
        } catch (Throwable e) {
            System.out.println("ren.shuaipeng.oom.basic.Stack deep:" + index);
            e.printStackTrace();
        }
    }
}
