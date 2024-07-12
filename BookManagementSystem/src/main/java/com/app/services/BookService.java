package com.app.services;

import java.util.List;

import com.app.entities.Book;
import com.app.entities.Category;

public interface BookService {
  List<Book> getAllBooks();
  
  Book newAddBook(Book book);
  
  void deleteById(Long id);
  
  void UpdateBook(Book book);
  
  List<Book> searchByCategory(Category category);
  
  List<Book> sortByCategory();
}
