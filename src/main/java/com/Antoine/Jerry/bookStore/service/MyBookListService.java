package com.Antoine.Jerry.bookStore.service;

import com.Antoine.Jerry.bookStore.entity.MyBookList;
import com.Antoine.Jerry.bookStore.repository.MyBookListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyBookListService {

    @Autowired
    private MyBookListRepository myBook;

    public void saveMyBook(MyBookList book){
        myBook.save(book);
    }

    public List<MyBookList> getAllMyBooks(){
        return myBook.findAll();
    }

    public void deleteById(int id){
        myBook.deleteById(id);
    }



}
