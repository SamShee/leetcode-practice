/**
 * Copyright (C), 2015-2021, XXX有限公司
 * FileName: CircularQueue
 * Author:   Stones
 * Date:     2021/3/10 19:41
 * Description: 循环队列实现
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.kafoon.algo.a09_queue;

/**
 * 〈一句话功能简述〉<br> 
 * 〈循环队列实现：数组空留一个位置的实现〉
 *
 * @author Stones
 * @create 2021/3/10
 * @since 1.0.0
 */
public class CircularQueue {

    private String[] items;
    //队列的首尾指针
    private int head = 0;
    private int tail = 0;

    //队列的容量
    private int n = 0;

    public CircularQueue(int capacity){
        this.items = new String[capacity];
        this.n = capacity;
    }

    /**
     * 入队方法：
     * 首先要判断队列是否已满：(tail + 1) % n == head
     * 队列已满，直接返回false
     * 队列没满，从队尾入队，tail = (tail+1)%n
     * @param item
     */
    public boolean enqueue(String item){
        if((tail + 1) % n == head) return false;

        items[tail] = item;
        tail = (tail+1) % n;
        return true;
    }

    /**
     * 出队方法：
     * 首先判断队列是否为空：tail==head
     * 队列为空返回null
     * 队列不为空，返回head指定位置的元素，head+1 然后对容量n求余，赋值给head
     */
    public String dequeue(){
        if(tail == head) return null;

        String ret = items[head];
        head = (head+1) % n;

        return ret;
    }

}
