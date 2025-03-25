** Use case
- Retrieve a list of all books available in the bookstore.
- Retrieve detailed information about a specific book
- Retrieve a list of all book categories
- Retrieve a list of all authors
- Retrieve a list of books within a specific category
- Retrieve a list of books by a specific author.
- Search for books based on title or author keywords
- Add a review (comment and rating) for a book.
- Update an existing review (comment and rating)
- Allow an authenticated user to place an order for one or more books
  
** Technology Stack:
- Spring Boot, Spring Data JPA, Spring Security, Spring Validation, SpringDoc (Swagger), Postgres Database, JWT library, Jackson.

** Database  
- books : id, title, desciption, price, publicationDate
- authors : id, name, biography
- categories : id, name, desciption
- reviews : id, bookId, comment, rating
- orders : id, customer_id, order_date, total_amount, status, shipping_address
- customers : id, name, password, address, email, phone_number

  * JOIN tables
- book_author: book_id, author_id
- book_category: book_id, category_id
- order_item: id, order_id, book_id, quantity, price

  * Relationship
- book author: 1 book can have many of authors. One Author can have many of books
- book category: 1 book can have many of categories. One category can have many of books
- order_item: One oder can have many of book
- 1 customer can have many orders
- 1 customer can have many reviews






