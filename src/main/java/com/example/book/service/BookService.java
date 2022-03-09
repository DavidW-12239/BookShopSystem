package com.example.book.service;

import com.example.book.pojo.Book;

import java.util.List;

public interface BookService {
    public void addBook(Book book);

    public void deleteBook(Integer id);

    public void updateBook(Book book);

    public Book queryBookById(Integer id);

    public List<Book> queryBooks();
}
