-- Create table for players
CREATE TABLE players (
    id INTEGER(255) PRIMARY KEY,
    name VARCHAR(255),
    height INTEGER,
    weight INTEGER,
    birth_date DATE,
    league VARCHAR(255),
    foot VARCHAR(255),
    weak_foot INTEGER,
    skill_moves INTEGER,
    market_price INTEGER
);
