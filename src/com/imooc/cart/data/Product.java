package com.imooc.cart.data;

public class Product {
    private String name;
    private Long id;
    private String tag;
    private String desc;
    private String level;
    private int price;

    public Product(String name,Long id,String tag,String desc,String level,int price){
        this.name = name;
        this.id = id;
        this.tag = tag;
        this.desc = desc;
        this.level = level;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
