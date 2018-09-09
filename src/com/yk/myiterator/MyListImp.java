package com.yk.myiterator;

public class MyListImp <T> implements MyList<T> {

    private Object [] obj = null;//生命对象数组
    private int index;//下标
    private int size;

    public MyListImp() {
        obj = new Object[10];
        index = 0;
        size = 0;
    }

    @Override
    public void add(T obj) {
        this.obj[index++] = obj;//存储
        size++;

    }

    @SuppressWarnings("unchecked")
    @Override
    public T get(int index) {
        return (T)this.obj[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public MyIteratorImp<T> iterator() {
        return new MyIteratorImp<>(this);
    }
}
