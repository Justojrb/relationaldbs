-- Create users table if it doesn't exist
CREATE TABLE IF NOT EXISTS users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    password VARCHAR(255),
    isVIP BOOLEAN DEFAULT FALSE,
    balance DECIMAL(10, 2) DEFAULT 0.00,
    email VARCHAR(255),
    phone VARCHAR(20),
    address VARCHAR(255),
    role VARCHAR(50),
    age INT
);
