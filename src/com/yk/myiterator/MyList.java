package com.yk.myiterator;

public interface MyList<T> {
    public void add(T obj);
    public T get(int index);
    public int size();
    public MyIteratorImp<T> iterator();
}
