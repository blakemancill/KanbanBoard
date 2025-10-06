CREATE TABLE task_boards(
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO task_boards (name) VALUES
('DEVELOPMENT');

CREATE TABLE item_statuses(
    id SERIAL PRIMARY KEY,
    status_name VARCHAR(50) NOT NULL UNIQUE
);

INSERT INTO item_statuses (status_name) VALUES
('UNASSIGNED'),
('IN PROCESS'),
('COMPLETED'),
('ON HOLD');

CREATE TABLE task_items(
    id SERIAL PRIMARY KEY,
    board_id INT NOT NULL REFERENCES task_boards(id) ON DELETE CASCADE,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    status_id INT NOT NULL REFERENCES item_statuses(id)
);

CREATE TABLE task_item_comments(
    id SERIAL PRIMARY KEY,
    task_item_id INT NOT NULL REFERENCES task_items(id) ON DELETE CASCADE,
    comment TEXT NOT NULL
);

CREATE TABLE task_item_history(
    id SERIAL PRIMARY KEY,
    task_item_id INT NOT NULL REFERENCES task_items(id) ON DELETE CASCADE,
    previous_status_id INT REFERENCES item_statuses(id),
    new_status_id INT REFERENCES item_statuses(id),
    comment_id INT REFERENCES task_item_comments(id),
    changed_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
)