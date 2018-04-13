package com.example.administrator.mifei.bean;

/**
 * Created by Administrator on 2018/4/13 0013.
 */

public class PayMenu {
    public static class Menu_item{
        private String left_item_name;
        private String right_item_name;

        public Menu_item(String left_item_name, String right_item_name) {
            this.left_item_name = left_item_name;
            this.right_item_name = right_item_name;
        }

        public String getLeft_item_name() {
            return left_item_name;
        }

        public String getRight_item_name() {
            return right_item_name;
        }
    }
}