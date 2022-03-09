package com.example.book.dao;

import com.example.book.dao.impl.BookDaoImpl;
import com.example.book.pojo.Book;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class BookDaoTest {

    private BookDao bookDao = new BookDaoImpl();

    @Test
    void addBook() {
        bookDao.addBook(new Book(null, "hhh", "12345", new BigDecimal(999), 100000, 0, null));
    }

    @Test
    void deleteBookById() {
    }

    @Test
    void updateBook() {
        bookDao.updateBook(new Book(21, "aaa", "1245", new BigDecimal(99), 10000, 0, null));
    }

    @Test
    void queryBookById() {
        System.out.println(bookDao.queryBookById(21));
    }

    @Test
    void queryBooks() {
        for (Book queryBook : bookDao.queryBooks()){
            System.out.println(queryBook);
        }
    }
}