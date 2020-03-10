package com.lesliehao.iterator;


import com.lesliehao.model.Book;

/**
 * @author HaoHao
 * @date 2020/3/9 5:42 下午
 */
public class BookIterator implements mIterrator<Book> {

    private BookStore bookStore;

    private int index;

    public BookIterator(BookStore bookStore) {
        this.bookStore = bookStore;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < bookStore.getLength();
    }

    @Override
    public Book next() {
        return bookStore.getBook(index++);
    }
}
