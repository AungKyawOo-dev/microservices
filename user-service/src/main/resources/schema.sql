-- ==============================
-- USERS TABLE
-- ==============================
CREATE TABLE users (
    id            CHAR(36) NOT NULL,             -- UUID (string format)
    email         VARCHAR(255) NOT NULL UNIQUE,  -- Unique user email
    name     VARCHAR(255) NOT NULL,
    phone_number  VARCHAR(20) DEFAULT NULL,
    created_at    TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at    TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


-- ==============================
-- ADDRESSES TABLE
-- ==============================
CREATE TABLE addresses (
    id           CHAR(36) NOT NULL,         -- UUID
    user_id      CHAR(36) NOT NULL,         -- FK to users.id
    line1        VARCHAR(255) NOT NULL,
    line2        VARCHAR(255) DEFAULT NULL,
    city         VARCHAR(100) NOT NULL,
    state        VARCHAR(100) DEFAULT NULL,
    postal_code  VARCHAR(20) DEFAULT NULL,
    country      VARCHAR(100) NOT NULL,
    is_default   BOOLEAN DEFAULT FALSE,
    created_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    CONSTRAINT fk_user_address FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


-- ==============================
-- INDEXES
-- ==============================
CREATE INDEX idx_users_email ON users(email);
CREATE INDEX idx_addresses_user ON addresses(user_id);
