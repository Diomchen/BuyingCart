package com.imooc.cart.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LocalCache {
    private static Map<Long,Product> productMap = new HashMap<>();

    private static Map<Long,Cart> productCart = new HashMap<>();

    private static Map<Long,Product> productFavorite = new HashMap<>();

    private static Map<Long,Product> productBrowseLog = new HashMap<>();

    static {
        productMap.put(1l,new Product("html",1l,"编程","编写静态网页，夯实web基础","A",100));
        productMap.put(2l,new Product("css",2l,"编程","编写静态网页，夯实web基础","B",200));
        productMap.put(3l,new Product("javascript",3l,"编程","编写静态网页，夯实web基础","C",300));
        productMap.put(4l,new Product("java",4l,"编程","编写静态网页，夯实web基础","D",400));
        productMap.put(5l,new Product("C++",5l,"编程","编写静态网页，夯实web基础","E",500));
        productMap.put(6l,new Product("C",6l,"编程","编写静态网页，夯实web基础","F",600));
        productMap.put(7l,new Product("Ruby",7l,"编程","编写静态网页，夯实web基础","G",700));
        productMap.put(8l,new Product("Python",8l,"编程","编写静态网页，夯实web基础","H",800));
        productMap.put(9l,new Product("iOS",9l,"编程","编写静态网页，夯实web基础","I",900));
        productMap.put(10l,new Product("Matlab",10l,"编程","编写静态网页，夯实web基础","J",1000));
        productMap.put(11l,new Product("PHP",11l,"编程","编写静态网页，夯实web基础","K",1100));
        productMap.put(12l,new Product("Golang",12l,"编程","编写静态网页，夯实web基础","L",1200));
        productMap.put(13l,new Product("Golang",13l,"编程","编写静态网页，夯实web基础","L",1200));
    }

    public static List<Cart> getCart(){
        return new ArrayList<>(productCart.values());
    }

    public static List<Product> getProduct(){
        return new ArrayList<>(productMap.values());
    }

    public static List<Product> getBrowse(){
        return new ArrayList<>(productBrowseLog.values());
    }

    public static Product getProducts(Long id){
        return productMap.get(id);
    }

    public static void addCart(Product product){
        if(!productCart.containsKey(product.getId())){
            System.out.println(product.getId()+" "+product.getName());
            productCart.put(product.getId(), new Cart(product.getId(),product.getName(),product.getId(),1,product.getPrice()));
        }
        else{
            inctProd(product.getId());
        }
    }

    public static void inctProd(Long productId){
        productCart.get(productId).inctProd();
    }

    public static void decCart(Long productId){
        productCart.remove(productId);
    }

    public static void decProd(Long productId){
         boolean result =  productCart.get(productId).decProd();
         if(result){
             productCart.remove(productId);
         }
    }

    public static Cart getCarts(Long productId){
        return productCart.get(productId);
    }

    public static void addFavorite(Product product){
        if(!productFavorite.containsKey(product.getId())){
            productFavorite.put(product.getId(),product);
        }
    }

    public static void delFavorite(Product product){
        if(productFavorite.containsKey(product.getId())){
            productFavorite.remove(product.getId());
        }
    }

    public static List<Product> getFavorites(){
        return new ArrayList<>(productFavorite.values());
    }

    public static void addBrowseLog(Product product){
        productBrowseLog.put(product.getId(),product);
    }

    public static void delBrowseLog(Product product){
        productBrowseLog.remove(product.getId());
    }

    public static List<Product> getProduct(int page,int size){
        List<Product> midProduct = new ArrayList<>(productMap.values());
        int start = (page-1)*size;
        int end = page*size>productMap.size()?midProduct.size() : page*size;
        return midProduct.subList(start,end);
    }

}
