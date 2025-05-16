package org.example;

import java.sql.Connection;
import java.sql.SQLException;

interface ConnectionProvider {
    Connection getConnection() throws SQLException;
}
