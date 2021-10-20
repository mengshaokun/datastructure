package com.msk.structure;

import java.util.Objects;

/**
 * 栈
 * 使用数组模拟栈
 */
public class StackDemo {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>(4);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.print();

        Integer pop = stack.pop();
        System.out.println(pop);
        stack.print();
    }

}

class Stack<T> {

    /**
     * 栈的最大深度
     */
    private int maxSize;

    /**
     * 栈中的数据 使用数组表示
     */
    private T[] values;

    /**
     * 栈顶 初始值为-1
     */
    private int top = -1;

    public Stack(int maxSize) {
        this.maxSize = maxSize;
        this.values = (T[]) new Object[maxSize];
    }

    /**
     * 栈是否已满方法
     * @return
     */
    public boolean isFull() {
        return this.top == maxSize - 1;
    }

    /**
     * 栈是否是空
     * @return
     */
    public boolean isEmpty() {
        return this.top == -1;
    }

    /**
     * 入栈
     * @param data
     */
    public void push(T data) {
        if (isFull()) {
            System.out.println("栈已满");
            return;
        }
        top++;
        values[top] = data;
    }

    /**
     * 出栈
     */
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("空栈");
        }
        T value = values[top];
        top--;
        return value;
    }

    /**
     * 打印栈数据
     */
    public void print() {
        for (int i = 0; i <= top; i++) {
            System.out.printf("元素 %d = %s\n", i, values[i]);;
        }
    }
}
