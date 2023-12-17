package com.example.mobileproject.model;

import java.util.ArrayList;

public class CartRepository {

    public ArrayList<Book> cartBooks  = new ArrayList<Book>();

    public void addCartItems(Book book )  {
        int cnt = 0;
        ArrayList<Book> goodsList = cartBooks;
        Book goods = book;
        Book goodsQnt = new Book();

        for (int i = 0; i<goodsList.size();i++) {
            goodsQnt = goodsList.get(i);
            if (goodsQnt.bookid.equals(book.bookid)) {
                cnt++;
                goodsQnt.quantity += 1;
            }
        }

        if (cnt == 0) {
            goods.quantity = 1;
            goods.isCheck = true;
            cartBooks.add(goods);
        }
    }

    public int countCartItems( ){
        int totalQuantity = 0;
        if (cartBooks != null) {
            for (int i=0; i< cartBooks.size(); i++) {
                totalQuantity += cartBooks.get(i).quantity;
            }
        }
        return totalQuantity;
    }

    public int grandTotalCartItems() {
        int totalPrice = 0;

        for (int i=0 ; i< cartBooks.size(); i++) {
            if (cartBooks.get(i).isCheck)
                totalPrice += cartBooks.get(i).price * cartBooks.get(i).quantity;
        }
        return totalPrice;
    }
}
