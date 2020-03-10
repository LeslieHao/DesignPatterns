package com.lesliehao.iterator;

import com.lesliehao.model.Book;

/**
 * @author HaoHao
 * @date 2020/3/9 5:32 下午
 */
public class BookStore implements Aggregate {

    private Book[] books;

    @Override
    public mIterrator<Book> iterrator() {
        return new BookIterator(this);
    }

    public BookStore(Book[] books) {
        this.books = books;
    }

    public Book getBook(int i) {
        return books[i];
    }

    public int getLength() {
        return books.length;
    }

}
