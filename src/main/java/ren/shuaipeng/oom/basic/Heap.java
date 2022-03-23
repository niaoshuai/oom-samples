package ren.shuaipeng.oom.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 主要模拟堆内存溢出 （Java heap space）
 * @author niaoshuai
 */
public class Heap {
    public static void main(String[] args) throws InterruptedException {

        Map<String, List<Object>> parent = new HashMap<>();
        for (int j= 0; j < 8; j++) {
            List<Object> oom = new ArrayList<>();
            // 计划构建8G内存
            int length = 1 * 1024;

            for (int i = 0; i < length; i++) {
                // 构建一个byte 数组 大概占用空间是1M
                byte[] bytes = new byte[1024 * 1024];
                oom.add(bytes);
                Thread.sleep(5);
            }

            parent.put("oom"+j,oom);
        }

    }
}
