package com.alibou.security.book;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository repository;

    public void save(BookRequest request) {
        var book = Book.builder()
                .author(request.getAuthor())
                .isbn(request.getIsbn())
                .build();
        repository.save(book);
    }

    public List<Book> findAll() {
        return repository.findAll();
    }

    public Book findById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new BookNotFoundException("Book Not Found"));
    }

    public Book updateBook(Integer id, BookRequest request) {
        var book = repository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book Not Found"));

        book.setAuthor(request.getAuthor());
        book.setIsbn(request.getIsbn());

        return repository.save(book);
    }
}
