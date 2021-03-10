/**
 * Copyright (C), 2015-2021, XXX有限公司
 * FileName: ArrayQueue
 * Author:   Stones
 * Date:     2021/2/28 10:59
 * Description: 基于数组生成的队列
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.kafoon.algo.a09_queue;

/**
 * 〈一句话功能简述〉<br> 
 * 〈基于数组生成的队列〉
 *
 * @author Stones
 * @create 2021/2/28
 * @since 1.0.0
 */
public class ArrayQueue {

    private String[] items;

    private int n = 0;

    private int head = 0;
    private int tail = 0;

    public ArrayQueue(int capacity) {
        this.items = new String[capacity];
        this.n = capacity;
    }

    /**
     * 入队方法：
     * 1、判断队列是否已满，如果已满则反馈false；
     * 2、队列没满，直接在尾部添加元素，并将队列tail指针+1；
     * @param item
     * @return
     */
    public boolean enqueue(String item){
        if (tail == n) {
            return false;
        }

        items[tail] = item;
        ++tail;
        return true;
    }

    /**
     * 入队优化：解决head=tail=n的问题
     * 1、如果tail=n，需要判断head=0？，如果为0，表示队列已满，不为0那么需要将数据迁移，是head从0开始
     * 2、如果tail！=n 直接将数据入队
     * @param item
     * @return
     */
    public boolean enqueue2(String item){
        if(tail == n){
            //表示队列已满
            if(head == 0){
                return false;
            }
            //tail == n，需要搬迁数据
            for(int i = head; i < n; i++){
                items[i-head] = items[head];
            }

            //搬迁完后需要将head和tail的指针重新赋值
            tail -= head;
            head = 0;
        }

        items[tail] = item;
        ++tail;
        return true;
    }

    /**
     * 出队：
     * 1、如果队列为空，返回null；
     * 2、直接从队列头部返回元素，将head指针+1；
     * @return
     */
    public String dequeue(){
        if(head == tail) return null;

        String res = items[head];
        ++head;

        return res;
    }

}
