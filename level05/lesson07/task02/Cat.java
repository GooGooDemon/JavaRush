package com.javarush.test.level05.lesson07.task02;

/* Создать класс Cat
Создать класс Cat (кот) с пятью инициализаторами:
- Имя,
- Имя, вес, возраст
- Имя, возраст (вес стандартный)
- вес, цвет, (имя, адрес и возраст неизвестны, это бездомный кот)
- вес, цвет, адрес ( чужой домашний кот)
Задача инициализатора – сделать объект валидным. Например, если вес неизвестен, то нужно указать какой-нибудь средний вес. Кот не может ничего не весить.
То же касательно возраста. А вот имени может и не быть (null). То же касается адреса: null.
*/

import java.awt.*;

public class Cat
{
    String name;
    int weight;
    int age;
    int color;
    String address;

    public void initialize(String name) {
        this.name = name;
        this.age = 1;
        this.weight = 3;
    }

    public void initialize(String name, int weight, int age) {
        this.name = name;
        this.weight = weight;
        this.age = age;
    }

    public void initialize(String name, int age) {
        this.name = name;
        this.weight = 3;
        this.age = age;
    }

    public void initialize(int weight, int color) {
        this.weight = weight;
        this.age = 1;
        this.color = color;
    }

    public void initialize(int weight, int color, String address) {
        this.weight = weight;
        this.age = 1;
        this.color = color;
        this.address = address;
    }

}
