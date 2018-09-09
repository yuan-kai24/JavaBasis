package com.yk.myiterator;

public class MyIteratorImp<T> implements MyIterator<T>{
    private MyListImp <T> list = null;
    private int index = 0;//下标

    public MyIteratorImp(MyListImp<T> list){
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return index<list.size();
    }

    @Override
    public T next() {
        return list.get(index++);
    }
}
