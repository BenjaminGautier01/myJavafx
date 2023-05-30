package com.example.myjavafx.java16.Interfaces;


import java.util.Map;

public interface IShow {

    void show() throws Exception;

    static void showMap(Map<?, ?> map) {
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            System.out.println(entry.getValue().toString());
        }

    }

}
