package com.example.CollectionaDemo.setAndMaps;

import java.util.*;

public class SetAndMaps {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(1,1,2,3,4,4,5,5,6,7));
task2(list);
task4(new ArrayList<>(List.of("один","два","два", "три","три","три")));
    }
/*Выводит только не четные числа*/
    public static void task1(List<Integer> list) {
        for (Integer integer : list) {
            if (integer % 2 != 0) {
                System.out.print(integer+" ");
            }
        }
        System.out.println();
    }
    /*Выводит только четные числа без повторений в порядке возростания*/
    public static void task2(List<Integer> list) {
        Collections.sort(list);
        Set<Integer> set = new HashSet<>();
        for (Integer integer : list) {
            if (integer % 2 == 0 && !set.contains(integer)) {
                System.out.print(integer + " ");
                set.add(integer);
            }
        }
        System.out.println();
    }
    /*Выводит только уникальные слова без повторений*/
    public static void task3(List<String> list) {
       Set<String> strings = new HashSet<>(list);
        System.out.println(strings);
    }
    /*Выводит в консоль количество дублей для каждого уникального слова,
    код работает с любой последовательностью и обьемом списка*/
    public static void task4(List<String> list) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : list) {
            if (map.containsKey(s)) {
                Integer courent = map.get(s);
                map.put(s, courent + 1);
            }else {
                map.put(s, 1);
            }
        }
        System.out.println(map);
    }
}
