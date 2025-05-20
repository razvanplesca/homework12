package org.example;

public class SecretKeyProviderImpl implements SecretKeyProvider {

    private final String url = "jdbc:postgresql://localhost:5432/postgres";
    private final String user = "postgres";
    private final String password = "password";

    @Override
    public String getDatabaseUrl() {
        return url;
    }

    @Override
    public String getDatabaseUser() {
        return user;
    }

    @Override
    public String getDatabasePassword() {
        return password;
    }
}
