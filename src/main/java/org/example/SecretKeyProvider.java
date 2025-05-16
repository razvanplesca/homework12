package org.example;

interface SecretKeyProvider {
    String getDatabaseUrl();
    String getDatabaseUser();
    String getDatabasePassword();
}
