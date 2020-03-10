package com.lesliehao.iterator;

import com.lesliehao.model.Book;

/**
 * @author HaoHao
 * @date 2020/3/9 5:50 下午
 */
public class Main {

    public static void main(String[] args) {
        Book[] books = {new Book("代码大全"), new Book("算法"), new Book("素数之恋")};
        BookStore store = new BookStore(books);
        mIterrator<Book> iterrator = store.iterrator();
        while (iterrator.hasNext()) {
            System.out.println(iterrator.next().getName());
        }
    }
}
