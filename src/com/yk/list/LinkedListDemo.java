package com.yk.list;

import sun.org.mozilla.javascript.internal.ast.StringLiteral;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListDemo {
    public static void main(String[] args) {
        MyStack<String> myStack = new MyStack<>();
        myStack.push("哈哈");
        myStack.push("嘿嘿");
        myStack.push("哼哼");
        myStack.push("嘻嘻");
        myStack.push("桀桀");
        myStack.push("霍霍");
        myStack.pop();
        myStack.pop();
        Iterator<String> iterator = myStack.iterator();
        while(iterator.hasNext())
        {
            System.out.println(iterator.next());
        }
        System.out.println("------------------------------------------");
        MyQueue<String> myQueue = new MyQueue<>();
        myQueue.push("小明");
        myQueue.push("小红");
        myQueue.push("小黄");
        myQueue.push("小绿");
        myQueue.push("小蓝");
        myQueue.pop();
        myQueue.pop();
        Iterator<String> it = myQueue.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println("------------------------------------------");

    }
}

class MyStack<T>{
    private LinkedList<T> data = null;
    public MyStack(){
        data = new LinkedList<>();
    }

    //压栈
    public void push(T obj){
        data.addFirst(obj);
    }

    //出栈
    public T pop()
    {
        return data.removeFirst();
    }

    public Iterator<T> iterator(){
        return data.iterator();
    }
}

class MyQueue<T>{
    private LinkedList<T> data = null;

    public MyQueue() {
        data = new LinkedList<>();
    }

    public void push(T obj){
        data.addLast(obj);
    }

    public T pop(){
        return data.removeFirst();
    }

    public Iterator<T> iterator(){
        return data.iterator();
    }
}
