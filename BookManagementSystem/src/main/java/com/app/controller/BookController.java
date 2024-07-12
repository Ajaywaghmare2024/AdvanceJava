package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.Book;
import com.app.entities.Category;
import com.app.services.BookService;

@RestController
@RequestMapping("/book")
public class BookController {
   @Autowired
   private BookService bookService;
   
   @GetMapping("/getAllBook")
   public List<Book> getAllBookList() {
	   return bookService.getAllBooks();
   }
   
   @PostMapping("/addBook")
   public Book addBook(@RequestBody Book book) {
	   return bookService.newAddBook(book);
   }
   @DeleteMapping("/id")
   public void deleteBook(Long id) {
	   bookService.deleteById(id);
   }
   @GetMapping("/{category}")
   public List<Book> getByCat(@PathVariable Category category){
	   return bookService.searchByCategory(category);
   }
   @GetMapping("/sort")
   public List<Book> sortCategory(){
	   return bookService.sortByCategory();
   }
   @PutMapping("/{id}")
   public void updateBook(@PathVariable Long id, @RequestBody Book book) {
	    book.setId(id);
	    bookService.UpdateBook(book);
   }
}
