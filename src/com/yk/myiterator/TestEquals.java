package com.yk.myiterator;

import java.util.HashMap;
import java.util.Objects;

public class TestEquals {

    public static void main(String[] args) {
        HashMap<EqT, String> hm = new HashMap<>();
        hm.put(new EqT("袁铠", 20), "不负青春");
        hm.put(new EqT("哈哈", 100), "欢乐开怀");
        hm.put(new EqT("桀桀", 1), "心狠手辣");
        hm.put(new EqT("桀桀", 1),"逼不得已");
        System.out.println(hm.size());
        System.out.println(hm);
    }

}
class EqT{
    private String name;
    private int age;

    public EqT(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EqT eqT = (EqT) o;
        return age == eqT.age &&
                Objects.equals(name, eqT.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}