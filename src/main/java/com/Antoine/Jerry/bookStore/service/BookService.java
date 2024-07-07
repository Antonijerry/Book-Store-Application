package com.Antoine.Jerry.bookStore.service;

import com.Antoine.Jerry.bookStore.entity.Book;
import com.Antoine.Jerry.bookStore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    //to add new book
    public void save(Book book){
        bookRepository.save(book);
    }

    //to get list of all books
    public List<Book> getAllBook(){
        return bookRepository.findAll();
    }

    public Book getBookById(int id){
        return bookRepository.findById(id).get();
    }

    public void deleteById(int id){
        bookRepository.deleteById(id);
    }




}
