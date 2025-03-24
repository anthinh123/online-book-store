-- Create the authors table
CREATE TABLE authors (
    id serial not null PRIMARY KEY,
    name VARCHAR(500) NOT NULL,
    biography TEXT
);

-- Create the categories table
CREATE TABLE categories (
    id serial not null PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT
);

-- Create the books table
CREATE TABLE books (
    id serial not null PRIMARY KEY,
    title VARCHAR(500) NOT NULL,
    description TEXT,
    price DECIMAL(10, 2) NOT NULL,
    publication_date TIMESTAMP
);

-- Create the book_author join table to support multiple authors for a book
CREATE TABLE book_author (
    book_id BIGINT NOT NULL,
    author_id BIGINT NOT NULL,
    PRIMARY KEY (book_id, author_id),
    FOREIGN KEY (book_id) REFERENCES books(id),
    FOREIGN KEY (author_id) REFERENCES authors(id)
);

-- Create the book_category join table
CREATE TABLE book_category (
    book_id BIGINT NOT NULL,
    category_id BIGINT NOT NULL,
    PRIMARY KEY (book_id, category_id),
    FOREIGN KEY (book_id) REFERENCES books(id),
    FOREIGN KEY (category_id) REFERENCES categories(id)
);

-- Create the customers table
CREATE TABLE customers (
    id serial not null PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    address VARCHAR(255),
    email VARCHAR(255) UNIQUE NOT NULL,
    phone_number VARCHAR(20),
    password VARCHAR(255) NOT NULL
);

-- Create the orders table
CREATE TABLE orders (
    id serial not null PRIMARY KEY,
    customer_id BIGINT NOT NULL,
    order_date TIMESTAMP NOT NULL,
    total_amount DECIMAL(10, 2) NOT NULL,
    status VARCHAR(20) NOT NULL,  -- Use VARCHAR for the enum
    shipping_address VARCHAR(255),
    FOREIGN KEY (customer_id) REFERENCES customers(id),
    CONSTRAINT status_check CHECK (status IN ('PENDING', 'PROCESSING', 'SHIPPED', 'DELIVERED', 'CANCELLED'))
);

-- Create the order_items join table
CREATE TABLE order_items (
    id serial not null PRIMARY KEY,
    order_id BIGINT NOT NULL,
    book_id BIGINT NOT NULL,
    quantity INT NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (order_id) REFERENCES orders(id),
    FOREIGN KEY (book_id) REFERENCES books(id)
);

CREATE TABLE reviews (
    id serial not null PRIMARY KEY,
    book_id BIGINT NOT NULL,
    comment VARCHAR(500),
    rating INT NOT NULL,
    FOREIGN KEY (book_id) REFERENCES books(id),
    CONSTRAINT rating_check CHECK (rating >= 1 AND rating <= 5)
);
