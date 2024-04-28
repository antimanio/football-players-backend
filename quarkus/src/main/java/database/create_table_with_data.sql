-- Create table for players
CREATE TABLE players (
    id VARCHAR(255) PRIMARY KEY,
    name VARCHAR(255),
    height INTEGER,
    weight INTEGER,
    birth_date DATE,
    league VARCHAR(255),
    main_foot INTEGER,
    weak_foot INTEGER,
    skill_moves INTEGER,
    value INTEGER
);

INSERT INTO players (id, name, height, weight, birth_date, league, main_foot, weak_foot, skill_moves, value)
VALUES 
('1', 'Player 1', 180, 75, '1990-01-01', 'Premier League', 1, 3, 4, 50000000),
('2', 'Player 2', 175, 70, '1992-05-15', 'La Liga', 2, 4, 5, 70000000),
('3', 'Player 3', 185, 80, '1988-11-30', 'Serie A', 1, 5, 4, 60000000)