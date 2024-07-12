package com.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entities.Book;
import com.app.entities.Category;
import com.app.repositories.BookRepository;
@Service
@Transactional
public class BookServiceImpl implements BookService {
   @Autowired
   private BookRepository bookRepository;
	@Override
	public List<Book> getAllBooks() {
		
		return bookRepository.findAll();
	}

	@Override
	public Book newAddBook(Book book) {
		
		return bookRepository.save(book);
	}

	@Override
	public void deleteById(Long id) {
		bookRepository.deleteById(id);
		
	}

	@Override
	public void UpdateBook(Book book) {
		Optional<Book> op=bookRepository.findById(book.getId());
		if(op.isPresent()) {
			Book bk=op.get();
			bk.setPrice(book.getPrice());
			bk.setQuantity(book.getQuantity());
			bk.setCategory(book.getCategory());
			bookRepository.save(bk);
		}
		
	}

	@Override
	public List<Book> searchByCategory(Category category) {
		
		return bookRepository.getByCategory(category);
	}

	@Override
	public List<Book> sortByCategory() {
		List<Book> sortList=bookRepository.findAll(Sort.by("category"));
		return sortList;
	}

}
