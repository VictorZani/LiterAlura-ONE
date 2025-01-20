package com.literalura.repository;

import com.literalura.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    // Derived query to find authors alive in a specific year
    List<Author> findByBirthYearLessThanEqualAndDeathYearGreaterThanEqual(int year1, int year2);
}
