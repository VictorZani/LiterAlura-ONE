package com.literalura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.literalura.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
