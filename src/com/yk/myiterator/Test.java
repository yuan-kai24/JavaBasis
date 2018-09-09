package com.yk.myiterator;

public class Test {
    public static void main(String[] args) {
        MyListImp<String> nameList = new MyListImp<>();
        nameList.add("张三");
        nameList.add("lisi");
        nameList.add("wangwu");
        MyIteratorImp it = nameList.iterator();
        while(it.hasNext())
        {
            System.out.println(it.next());
        }
    }
}
