package com.example.shoppingmallsystem.bean;

import java.io.Serializable;
import java.util.List;


/**
 *  商家商品信息bean
 */
public class GoodsArrayBean implements Serializable {

    public List<ItemL> itemsLeft;
    public List<ItemR> itemsRight;

    @Override
    public String toString() {
        return "GoodsArrayBean{" +
                "itemsLeft=" + itemsLeft +
                ", itemsRight=" + itemsRight +
                '}';
    }

    public static class ItemL{
        private String title;

        public ItemL(String title) {
            this.title = title;
        }

        public ItemL() {

        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        @Override
        public String toString() {
            return "ItemL{" +
                    "title='" + title + '\'' +
                    '}';
        }
    }


            public static class ItemR  implements Serializable{
                private String title;
                private String picNumb;
                private String name;
                private String price;
                private String content;
                private int number = 0;

                public ItemR() {

                }

                public ItemR(String title, String picNumb, String name, String price, String content, int number) {
                    this.title = title;
                    this.picNumb = picNumb;
                    this.name = name;
                    this.price = price;
                    this.content = content;
                    this.number = number;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getPicNumb() {
                    return picNumb;
                }

                public void setPicNumb(String picNumb) {
                    this.picNumb = picNumb;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getPrice() {
                    return price;
                }

                public void setPrice(String price) {
                    this.price = price;
                }

                public String getContent() {
                    return content;
                }

                public void setContent(String content) {
                    this.content = content;
                }

                public int getNumber() {
                    return number;
                }

                public void setNumber(int number) {
                    this.number = number;
                }

                @Override
                public String toString() {
                    return "ItemR{" +
                            "title='" + title + '\'' +
                            ", picNumb='" + picNumb + '\'' +
                            ", name='" + name + '\'' +
                            ", price='" + price + '\'' +
                            ", content='" + content + '\'' +
                            ", number=" + number +
                            '}';
                }
            }

}
