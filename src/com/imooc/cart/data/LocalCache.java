package com.imooc.cart.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LocalCache {
    private static Map<Long,Product> productMap = new HashMap<>();

    static {
        productMap.put(1l,new Product("html","001","编程","编写静态网页，夯实web基础","A",100));
        productMap.put(2l,new Product("css","002","编程","编写静态网页，夯实web基础","B",200));
        productMap.put(3l,new Product("javascript","003","编程","编写静态网页，夯实web基础","C",300));
        productMap.put(4l,new Product("java","004","编程","编写静态网页，夯实web基础","D",400));
        productMap.put(5l,new Product("C++","005","编程","编写静态网页，夯实web基础","E",500));
        productMap.put(6l,new Product("C","006","编程","编写静态网页，夯实web基础","F",600));
        productMap.put(7l,new Product("Ruby","007","编程","编写静态网页，夯实web基础","G",700));
        productMap.put(8l,new Product("Python","008","编程","编写静态网页，夯实web基础","H",800));
        productMap.put(9l,new Product("iOS","009","编程","编写静态网页，夯实web基础","I",900));
        productMap.put(10l,new Product("Matlab","010","编程","编写静态网页，夯实web基础","J",1000));
        productMap.put(11l,new Product("PHP","011","编程","编写静态网页，夯实web基础","K",1100));
        productMap.put(12l,new Product("Golang","012","编程","编写静态网页，夯实web基础","L",1200));

    }

    public static List<Product> getProduct(){
        return new ArrayList<>(productMap.values());
    }
}
