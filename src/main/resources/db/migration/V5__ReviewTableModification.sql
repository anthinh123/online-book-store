-- Flyway migration script to add customer_id to reviews table

-- Add the customer_id column to the reviews table
ALTER TABLE reviews ADD COLUMN customer_id BIGINT;

-- Add a foreign key constraint to link reviews to customers
ALTER TABLE reviews ADD CONSTRAINT fk_customer_id
    FOREIGN KEY (customer_id) REFERENCES customers(id);

-- Optionally, update existing reviews with a default customer_id if needed
-- UPDATE reviews SET customer_id = 1 WHERE customer_id IS NULL;

-- to ensure that all new reviews have a customer_id
ALTER TABLE reviews ALTER COLUMN customer_id SET NOT NULL;
