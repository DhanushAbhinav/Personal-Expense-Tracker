CREATE TABLE IF NOT EXISTS transactions (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    type VARCHAR(255),
    category VARCHAR(255),
    amount DOUBLE,
    date TIMESTAMP,
    description TEXT
);

CREATE TABLE IF NOT EXISTS categories (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    name VARCHAR(255),
    type VARCHAR(255)
);