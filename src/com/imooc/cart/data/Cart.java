package com.imooc.cart.data;

public class Cart {
    private Long Id;
    private String name;
    private Long productId;
    private int count;
    private int price;
    private int totalPrice;

    public Cart(Long Id,String name,Long productId,int count,int price){
        this.Id = Id;
        this.name = name;
        this.productId = productId;
        this.count = count;
        this.price = price;
        this.totalPrice = price*count;
    }

    public void inctProd(){
        count++;
        this.totalPrice = price*count;
    }

    public boolean decProd(){
        count--;
        if(count>0){
            totalPrice = price*count;
            return true;
        }
        return false;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
}
