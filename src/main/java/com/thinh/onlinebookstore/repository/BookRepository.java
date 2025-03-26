package com.thinh.onlinebookstore.repository;

import com.thinh.onlinebookstore.entity.Book;
import lombok.NonNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Page<Book> findAll(@NonNull Pageable pageable);
    Page<Book> findByCategories_Id(Long id, Pageable pageable);
    Page<Book> findByAuthors_Id(Long id, Pageable pageable);

    @Query("SELECT b FROM Book b JOIN b.authors a WHERE LOWER(b.title) LIKE LOWER(concat('%', :query, '%')) OR LOWER(a.name) LIKE LOWER(concat('%', :query, '%'))")
    Page<Book> findByTitleOrAuthorName(String query, Pageable pageable);
}
