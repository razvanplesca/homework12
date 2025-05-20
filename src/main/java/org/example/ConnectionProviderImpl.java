package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class ConnectionProviderImpl implements ConnectionProvider {

    private final SecretKeyProvider secretKeyProvider;

    public ConnectionProviderImpl(final SecretKeyProvider secretKeyProvider) {
        this.secretKeyProvider = secretKeyProvider;
    }

    @Override
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                secretKeyProvider.getDatabaseUrl(),
                secretKeyProvider.getDatabaseUser(),
                secretKeyProvider.getDatabasePassword()
        );
    }
}
