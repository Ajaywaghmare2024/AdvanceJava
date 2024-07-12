package com.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Book;
import com.app.entities.Category;

public interface BookRepository extends JpaRepository<Book, Long> {
  List<Book> getByCategory(Category category);
}
