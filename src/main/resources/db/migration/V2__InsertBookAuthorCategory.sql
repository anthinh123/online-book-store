-- Flyway migration script to insert data into the bookstore database schema

-- Insert data into the authors table
INSERT INTO authors (name, biography) VALUES
    ('J.K. Rowling', 'J.K. Rowling is a British author best known for the Harry Potter series.'),
    ('Stephen King', 'Stephen King is an American author known for his horror novels.'),
    ('Jane Austen', 'Jane Austen was an English novelist known for her romantic fiction.'),
    ('George Orwell', 'George Orwell was an English novelist and essayist.'),
    ('Agatha Christie', 'Agatha Christie was an English writer known for her detective novels.'),
    ('Ernest Hemingway', 'An American novelist and short-story writer.'),
    ('F. Scott Fitzgerald', 'An American novelist known for his works on the Jazz Age.'),
    ('Harper Lee', 'An American novelist known for To Kill a Mockingbird.'),
    ('Mark Twain', 'An American writer, humorist, and entrepreneur.'),
    ('William Faulkner', 'An American writer known for his Southern literature.'),
    ('Virginia Woolf', 'An English writer known for her modernist novels.'),
    ('Gabriel Garcia Marquez', 'A Colombian novelist known for his magical realism.'),
    ('Toni Morrison', 'An American novelist known for her works on African-American identity.'),
    ('Salman Rushdie', 'A British-Indian novelist and essayist.'),
    ('Margaret Atwood', 'A Canadian writer known for her feminist and dystopian fiction.'),
    ('Haruki Murakami', 'A Japanese writer known for his surreal and melancholic works.'),
    ('Chimamanda Ngozi Adichie', 'A Nigerian writer known for her novels and essays on feminism and identity.'),
    ('Colleen Hoover', 'An American author of romance novels.'),
    ('James Patterson', 'An American author known for his thrillers.'),
    ('Danielle Steel', 'An American writer of romance novels.'),
    ('Terry Pratchett', 'An English humorist and fantasy author.'),
    ('Neil Gaiman', 'An English author of science fiction and fantasy.'),
    ('Michael Crichton', 'An American author known for his techno-thrillers.'),
    ('Suzanne Collins', 'An American author known for The Hunger Games series.'),
    ('Veronica Roth', 'An American novelist known for the Divergent trilogy.'),
    ('John Green', 'An American author of young adult fiction.'),
    ('E.L. James', 'A British author known for the Fifty Shades series.'),
    ('Paula Hawkins', 'A British author known for The Girl on the Train.'),
    ('Gillian Flynn', 'An American author known for Gone Girl.'),
    ('Stieg Larsson', 'A Swedish journalist and author known for the Millennium series.'),
    ('Stephen Fry', 'An English actor, writer, and comedian.', 'Stephen Fry is an English actor, writer, and comedian.'),
    ('Hugh Laurie', 'An English actor and musician.', 'Hugh Laurie is an English actor and musician.'),
    ('Douglas Adams', 'An English author and humorist.', 'Douglas Adams was an English author and humorist.'),
    ('Terry Gilliam', 'An American-born British filmmaker.', 'Terry Gilliam is an American-born British filmmaker.'),
    ('Eric Idle', 'An English actor, comedian and writer.', 'Eric Idle is an English actor, comedian and writer.');

-- Insert data into the categories table
INSERT INTO categories (name, description) VALUES
    ('Fiction', 'Fiction books.'),
    ('Horror', 'Horror books.'),
    ('Romance', 'Romance novels.'),
    ('Science Fiction', 'Science Fiction books.'),
    ('Mystery', 'Mystery books.'),
    ('Fantasy', 'Fantasy books.'),
    ('Young Adult', 'Young Adult books.');

-- Insert data into the books table (50 books)
INSERT INTO books (title, description, price, publication_date) VALUES
    ('Harry Potter and the Chamber of Secrets', 'The second book in the Harry Potter series, where a mysterious chamber is opened at Hogwarts.', 25.99, '1998-07-02'),
    ('The Shining', 'A horror novel by Stephen King, set in the isolated Overlook Hotel, where a family descends into madness.', 19.99, '1977-01-28'),
    ('Pride and Prejudice', 'A romance novel by Jane Austen, exploring the societal constraints and love in 19th-century England.', 15.99, '1813-01-28'),
    ('Nineteen Eighty-Four', 'A dystopian novel by George Orwell, depicting a totalitarian society under the control of Big Brother.', 12.99, '1949-06-08'),
    ('Murder on the Orient Express', 'A mystery novel by Agatha Christie, where detective Hercule Poirot investigates a murder on a train.', 10.99, '1934-01-01'),
    ('Harry Potter and the Prisoner of Azkaban', 'The third book in the Harry Potter series, featuring the escape of Sirius Black from Azkaban prison.', 27.99, '1999-07-02'),
    ('It', 'A horror novel by Stephen King, about a group of children who face an evil entity in their town.', 22.99, '1986-09-15'),
    ('Sense and Sensibility', 'A romance novel by Jane Austen, following the Dashwood sisters as they navigate love and societal expectations.', 14.99, '1811-10-30'),
    ('Animal Farm', 'An allegorical novella by George Orwell, satirizing the Russian Revolution and its aftermath.', 9.99, '1945-08-17'),
    ('The ABC Murders', 'A mystery novel by Agatha Christie, where Hercule Poirot investigates a series of murders linked by an alphabetical pattern.', 11.99, '1936-01-06'),
    ('The Sun Also Rises', 'A novel by Ernest Hemingway, portraying a group of American and British expatriates in post-World War I Europe.', 17.99, '1926-10-22'),
    ('The Great Gatsby', 'A novel by F. Scott Fitzgerald, set in the Jazz Age, exploring themes of wealth, love, and the American Dream.', 16.99, '1925-04-10'),
    ('To Kill a Mockingbird', 'A novel by Harper Lee, addressing racial injustice and childhood innocence in the American South.', 18.99, '1960-07-11'),
    ('The Adventures of Huckleberry Finn', 'A novel by Mark Twain, satirizing societal norms and racism through the journey of a young boy and a runaway slave.', 14.99, '1884-12-10'),
    ('As I Lay Dying', 'A novel by William Faulkner, using multiple narrators to tell the story of a family\'s journey to bury their mother.', 12.99, '1930-10-06'),
    ('Mrs Dalloway', 'A novel by Virginia Woolf, detailing a day in the life of a high-society woman in post-World War I England.', 10.99, '1925-05-14'),
    ('One Hundred Years of Solitude', 'A novel by Gabriel Garcia Marquez, chronicling the multi-generational story of the Buendía family in the fictional town of Macondo.', 19.99, '1967-05-30'),
    ('Beloved', 'A novel by Toni Morrison, exploring the legacy of slavery and its impact on a family of former slaves.', 21.99, '1987-10-08'),
    ('Midnight\'s Children', 'A novel by Salman Rushdie, intertwining the history of India with the lives of children born at the stroke of midnight on India\'s independence.', 15.99, '1981-06-10'),
    ('The Handmaid\'s Tale', 'A dystopian novel by Margaret Atwood, set in a totalitarian regime where women are subjugated and used for reproductive purposes.', 13.99, '1985-01-01'),
    ('Norwegian Wood', 'A novel by Haruki Murakami, depicting the life of a college student in Tokyo and his relationships during a time of social upheaval.', 16.99, '1987-09-04'),
    ('Half of a Yellow Sun', 'A novel by Chimamanda Ngozi Adichie, set during the Nigerian Civil War, exploring themes of identity, love, and betrayal.', 18.99, '2006-08-22'),
    ('Verity', 'A thriller romance novel by Colleen Hoover, involving a writer who uncovers dark secrets within a family.', 24.99, '2021-05-07'),
    ('Along Came a Spider', 'A novel by James Patterson, featuring detective Alex Cross as he investigates a series of kidnappings.', 27.99, '1993-01-01'),
    ('Safe Harbour', 'A novel by Danielle Steel, telling a story of resilience, loss, and finding love after tragedy.', 26.99, '2003-09-16'),
    ('The Lord of the Rings: The Fellowship of the Ring', 'The first book in the Lord of the Rings series by J.R.R. Tolkien, chronicling the beginning of the quest to destroy the One Ring.', 29.99, '1954-07-29'),
    ('The Hitchhiker\'s Guide to the Galaxy', 'A science fiction comedy novel by Douglas Adams, following the misadventures of Arthur Dent after Earth\'s destruction.', 11.99, '1979-10-12'),
    ('Jane Eyre', 'A gothic romance novel by Charlotte Brontë, detailing the life of a governess and her relationship with Mr. Rochester.', 14.99, '1847-10-16'),
    ('The Count of Monte Cristo', 'An adventure novel by Alexandre Dumas, telling the story of Edmond Dantès\' wrongful imprisonment and his quest for revenge.', 19.99, '1844-08-28'),
    ('Little Women', 'A coming-of-age novel by Louisa May Alcott, following the lives of the four March sisters during and after the American Civil War.', 12.99, '1868-09-30'),
    ('The Picture of Dorian Gray', 'A gothic and philosophical novel by Oscar Wilde, exploring themes of beauty, morality, and the corrupting influence of hedonism.', 10.99, '1890-07-01'),
    ('Frankenstein', 'A gothic novel by Mary Shelley, telling the story of Victor Frankenstein and the creature he creates.', 11.99, '1818-01-01'),
    ('Dracula', 'A gothic horror novel by Bram Stoker, introducing the character of Count Dracula and his reign of terror.', 12.99, '1897-05-26'),
    ('The War of the Worlds', 'A science fiction novel by H. G. Wells, depicting an alien invasion of Earth and humanity\'s struggle for survival.', 10.99, '1898-01-01'),
    ('Pride and Prejudice and Zombies', 'A parody novel by Seth Grahame-Smith, combining the original Jane Austen novel with elements of zombie horror.', 15.99, '2009-04-01'),
    ('Abraham Lincoln: Vampire Hunter', 'A horror-fantasy novel by Seth Grahame-Smith, portraying President Lincoln as a vampire hunter.', 16.99, '2010-03-02'),
    ('World War Z', 'A zombie apocalyptic horror novel by Max Brooks, told through a series of interviews documenting a global zombie pandemic.', 17.99, '2006-09-12'),
    ('The Martian', 'A science fiction novel by Andy Weir, following an astronaut\'s lone struggle to survive on Mars after being presumed dead.', 19.99, '2011-02-20'),
    ('Ready Player One', 'A science fiction novel by Ernest Cline, set in a virtual reality world called the OASIS, where a teenager competes in a treasure hunt.', 20.99, '2011-08-16'),
    ('Gone Girl', 'A psychological thriller novel by Gillian Flynn, exploring the mystery surrounding a woman\'s disappearance and the secrets within a marriage.', 22.99, '2012-05-22'),
    ('The Girl with the Dragon Tattoo', 'A psychological thriller novel by Stieg Larsson, involving a disgraced journalist and a young female hacker investigating a woman\'s disappearance.', 21.99, '2005-08-16'),
    ('The Silent Patient', 'A psychological thriller novel by Alex Michaelides, centering on a psychotherapist\'s attempt to treat a famous painter who shot her husband.', 23.99, '2019-02-05'),
    ('The Da Vinci Code', 'A mystery thriller novel by Dan Brown, following a symbologist and cryptologist as they unravel a conspiracy related to the Holy Grail.', 18.99, '2003-03-18'),
     ('Angels & Demons', 'A mystery thriller novel by Dan Brown, featuring symbologist Robert Langdon as he investigates a murder and a threat to the Vatican.', 19.99, '2000-05-01'),
    ('Inferno', 'A mystery thriller novel by Dan Brown, with Robert Langdon trying to decipher clues related to a deadly virus and the works of Dante.', 20.99, '2013-05-14'),
    ('Origin', 'A mystery thriller novel by Dan Brown, where Robert Langdon explores questions about humanity\'s origin and future.', 21.99, '2017-10-03'),
    ('Harry Potter and the Cursed Child', 'A play script by J.K. Rowling, Jack Thorne, and John Tiffany, continuing the story of Harry Potter as an adult and his son Albus.', 25.99, '2016-07-31'),
    ('Fantastic Beasts and Where to Find Them', 'A screenplay by J.K. Rowling, set in the wizarding world and following the adventures of Newt Scamander.', 27.99, '2016-11-18'),
    ('The Casual Vacancy', 'A novel by J.K. Rowling, depicting the aftermath of a death in a small English village and the ensuing power struggle.', 20.00, '2012-09-27'),
    ('The Silkworm', 'A crime fiction novel by Robert Galbraith (J.K. Rowling), featuring detective Cormoran Strike as he investigates the disappearance of a writer.', 19.00, '2014-06-19'),
    ('Career of Evil', 'A crime fiction novel by Robert Galbraith (J.K. Rowling), with Cormoran Strike and Robin Ellacott investigating a series of disturbing murders.', 20.00, '2015-10-20');


-- Insert data into the book_author join table
-- 15 books with 2 authors
INSERT INTO book_author (book_id, author_id) VALUES
    (1, 1), (1, 2),  -- Harry Potter and the Chamber of Secrets by J.K. Rowling, Stephen King
    (6, 1), (6, 3),  -- Harry Potter and the Prisoner of Azkaban by J.K. Rowling, Jane Austen
    (11, 6), (11, 7), -- The Sun Also Rises by Ernest Hemingway, F. Scott Fitzgerald
    (16, 11), (16, 12), -- Mrs Dalloway by Virginia Woolf, Gabriel Garcia Marquez
    (21, 16), (21, 17), -- Norwegian Wood by Haruki Murakami, Chimamanda Ngozi Adichie
    (26, 1), (26, 18), -- The Lord of the Rings: The Fellowship of the Ring by J.R.R. Tolkien, Colleen Hoover
    (27, 33), (27, 19), -- The Hitchhiker's Guide to the Galaxy by Douglas Adams, James Patterson
    (28, 22), (28, 20), -- Jane Eyre by Charlotte Brontë, Danielle Steel
    (29, 23), (29, 21),  -- The Count of Monte Cristo by Alexandre Dumas, Terry Pratchett
    (30, 24), (30, 22), -- Little Women by Louisa May Alcott, Neil Gaiman
    (35, 29), (35, 1),  -- Pride and Prejudice and Zombies by Seth Grahame-Smith, J.K. Rowling
    (36, 30), (36, 2),  -- Abraham Lincoln: Vampire Hunter by Seth Grahame-Smith, Stephen King
    (40, 34), (40, 3),  -- Gone Girl by Gillian Flynn, Jane Austen
    (41, 35), (41, 4),  -- The Girl with the Dragon Tattoo by Stieg Larsson, George Orwell
    (47, 1), (47, 31); -- Harry Potter and the Cursed Child by J.K. Rowling, Stephen Fry

-- 10 books with 3 authors
INSERT INTO book_author (book_id, author_id) VALUES
    (2, 2), (2, 3), (2, 4),  -- The Shining by Stephen King, Jane Austen, George Orwell
    (7, 2), (7, 5), (7, 6),  -- It by Stephen King, Agatha Christie, Ernest Hemingway
    (12, 7), (12, 8), (12, 9), -- The Great Gatsby by F. Scott Fitzgerald, Harper Lee, Mark Twain
    (17, 12), (17, 13), (17, 14), -- One Hundred Years of Solitude by Gabriel Garcia Marquez, Toni Morrison, Salman Rushdie
    (22, 17), (22, 15), (22, 16), -- Half of a Yellow Sun by Chimamanda Ngozi Adichie, Margaret Atwood, Haruki Murakami
    (31, 25), (31, 26), (31, 27),  -- The Picture of Dorian Gray by Oscar Wilde, Mary Shelley, Bram Stoker
    (32, 26), (32, 27), (32, 28),  -- Frankenstein by Mary Shelley, Bram Stoker, H.G. Wells
    (37, 31), (37, 32), (37, 33), -- World War Z by Max Brooks, Andy Weir, Douglas Adams
    (48, 1), (48, 33), (48, 34), -- Fantastic Beasts and Where to Find Them by J.K. Rowling, Douglas Adams, Terry Gilliam
    (49, 1), (49, 21), (49, 22);  -- The Casual Vacancy by J.K. Rowling, Terry Pratchett, Neil Gaiman

-- Remaining books with 1 author
INSERT INTO book_author (book_id, author_id) VALUES
    (3, 3),  -- Pride and Prejudice by Jane Austen
    (4, 4),  -- Nineteen Eighty-Four by George Orwell
    (5, 5),  -- Murder on the Orient Express by Agatha Christie
    (8, 3),  -- Sense and Sensibility by Jane Austen
    (9, 4),  -- Animal Farm by George Orwell
    (10, 5), -- The ABC Murders by Agatha Christie
    (13, 8), -- To Kill a Mockingbird by Harper Lee
    (14, 9), -- The Adventures of Huckleberry Finn by Mark Twain
    (15, 10),-- As I Lay Dying by William Faulkner
    (18, 13),-- Beloved by Toni Morrison
    (19, 14),-- Midnight's Children by Salman Rushdie
    (20, 15),-- The Handmaid's Tale by Margaret Atwood
    (23, 18),-- Verity by Colleen Hoover
    (24, 19), -- Along Came a Spider by James Patterson
    (25, 20), -- Safe Harbour by Danielle Steel
    (33, 27), -- Dracula by Bram Stoker
    (34, 28), -- The War of the Worlds by H. G. Wells
    (38, 32), -- The Martian by Andy Weir
    (39, 33), -- Ready Player One by Ernest Cline
    (42, 36), -- The Silent Patient by Alex Michaelides
    (43, 5),  -- The Da Vinci Code by Dan Brown
    (44, 5),   -- Angels & Demons by Dan Brown
    (45, 5),  -- Inferno by Dan Brown
    (46, 5),  -- Origin by Dan Brown
    (50, 1);  -- The Silkworm by Robert Galbraith (J.K. Rowling)


-- Insert data into the book_category join table
INSERT INTO book_category (book_id, category_id) VALUES
    (1, 1),  -- Harry Potter and the Chamber of Secrets is Fiction
    (1, 6),
    (2, 2),  -- The Shining is Horror
    (3, 3),  -- Pride and Prejudice is Romance
    (4, 1),  -- Nineteen Eighty-Four is Fiction
    (4, 4),  -- Nineteen Eighty-Four is Science Fiction
    (5, 5),  -- Murder on the Orient Express is Mystery
    (6, 1),  -- Harry Potter and the Prisoner of Azkaban is Fiction
    (6, 6),
    (7, 2),  -- It is Horror
    (8, 3),  -- Sense and Sensibility is Romance
    (9, 1),  -- Animal Farm is Fiction
    (9, 7),
    (10, 5), -- The ABC Murders is Mystery
    (11, 1), -- The Sun Also Rises is Fiction
    (12, 1), -- The Great Gatsby is Fiction
    (12, 3),
    (13, 1), -- To Kill a Mockingbird is Fiction
    (13, 7),
    (14, 1), -- The Adventures of Huckleberry Finn is Fiction
    (14, 7),
    (15, 1), -- As I Lay Dying is Fiction
    (15, 10),
    (16, 1), -- Mrs Dalloway is Fiction
    (17, 1), -- One Hundred Years of Solitude is Fiction
    (18, 1), -- Beloved is Fiction
    (19, 1), -- Midnight's Children is Fiction
    (20, 1), -- The Handmaid's Tale is Fiction
    (21, 1), -- Norwegian Wood is Fiction
    (22, 1), -- Half of a Yellow Sun is Fiction
    (23, 3), -- Verity is Romance
    (24, 2), -- Along Came a Spider is Horror
    (25, 3), -- Safe Harbour is Romance
    (26, 1),  -- The Lord of the Rings: The Fellowship of the Ring is Fiction
    (26, 6),
    (27, 4),  -- The Hitchhiker's Guide to the Galaxy is Science Fiction
    (27, 1),
    (28, 3),  -- Jane Eyre is Romance
    (28, 1),
    (29, 1),  -- The Count of Monte Cristo is Fiction
    (29, 10),
    (30, 1),  -- Little Women is Fiction
    (30, 7),
    (31, 1),  -- The Picture of Dorian Gray is Fiction
    (31, 5),
    (32, 2),  -- Frankenstein is Horror
    (32, 4),
    (33, 2),  -- Dracula is Horror
    (33, 5),
    (34, 4),  -- The War of the Worlds is Science Fiction
    (34, 2),
    (35, 1),  -- Pride and Prejudice and Zombies is Fiction
    (35, 2),
    (36, 2),  -- Abraham Lincoln: Vampire Hunter is Horror
    (36, 7),
    (37, 2),  -- World War Z is Horror
    (37, 4),
    (38, 4),  -- The Martian is Science Fiction
    (38, 1),
    (39, 4),  -- Ready Player One is Science Fiction
    (39, 1),
    (40, 5),  -- Gone Girl is Mystery
    (40, 3),
    (41, 5),  -- The Girl with the Dragon Tattoo is Mystery
    (41, 1),
    (42, 5),  -- The Silent Patient is Mystery
    (42, 1),
    (43, 5),  -- The Da Vinci Code is Mystery
    (43, 1),
    (44, 5),   -- Angels & Demons is Mystery
    (44, 2),
    (45, 5),  -- Inferno is Mystery
     (45, 3),
     (46, 5),  -- Origin is Mystery
     (46, 4),
    (47, 1),   -- Harry Potter and the Cursed Child is Fiction
    (47, 6),
    (48, 1),  -- Fantastic Beasts and Where to Find Them is Fiction
    (48, 6),
    (49, 1),   -- The Casual Vacancy is Fiction
    (49, 7),
    (50, 1);  -- The Silkworm is Fiction
