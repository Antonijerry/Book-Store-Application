package com.Antoine.Jerry.bookStore.controller;

import com.Antoine.Jerry.bookStore.entity.Book;
import com.Antoine.Jerry.bookStore.entity.MyBookList;
import com.Antoine.Jerry.bookStore.service.BookService;
import com.Antoine.Jerry.bookStore.service.MyBookListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private MyBookListService myBookListService;


    @GetMapping("/")
    public String home() {
        return "Home";
    }


    @GetMapping("/book_register")
    public String bookRegister() {
        return "bookRegister";
    }

    //to get all the books added
    @GetMapping("/available_books")
    public ModelAndView getAllBooks(){
        List<Book> list = bookService.getAllBook();
//        ModelAndView m = new ModelAndView();
//        m.setViewName("bookList");
//        m.addObject("book", list);
        return new ModelAndView("bookList","book",list);
    }

    //to save new book
    @PostMapping("/save")
    public String addBook(@ModelAttribute Book book){
        bookService.save(book);
        return "redirect:/available_books";
    }

    @GetMapping("/my_books")
    public String getMyBooks(Model model){
        List<MyBookList> list=myBookListService.getAllMyBooks();
        model.addAttribute("book", list);
        return "myBooks";
    }

    @RequestMapping("/mylist/{id}")
    public String getMyList(@PathVariable("id") int id){
        Book b=bookService.getBookById(id);
        MyBookList mb = new MyBookList(b.getId(), b.getName(), b.getAuthor(), b.getPrice());
        myBookListService.saveMyBook((mb));
        return "redirect:/my_books";
    }

    @RequestMapping("/editBook/{id}")
    public String editBook(@PathVariable("id") int id, Model model){
        Book b=bookService.getBookById(id);
        model.addAttribute("book",b);
        return "bookEdit";
    }

    @RequestMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id")int id){
        bookService.deleteById(id);
        return "redirect:/available_books";
    }
}