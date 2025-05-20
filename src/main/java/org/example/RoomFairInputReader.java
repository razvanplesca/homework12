package org.example;

import java.util.Scanner;
import java.util.UUID;

class RoomFairInputReader {
    private final Scanner scanner;
    private final ConnectionProvider connectionProvider;

    public RoomFairInputReader(Scanner scanner, ConnectionProvider connectionProvider) {
        this.scanner = scanner;
        this.connectionProvider = connectionProvider;
    }

    public RoomFair readRoomFair(Season season) {
        System.out.printf("Enter value for %s: ", season.name().toLowerCase());
        final Double value = Double.valueOf(scanner.nextLine());
        return RoomFair.builder()
                .id(generateNewId())
                .value(value)
                .season(season)
                .connectionProvider(connectionProvider)
                .build();
    }

    public RoomFair readRoomFairForSummer() {
        return readRoomFair(Season.SUMMER);
    }

    public RoomFair readRoomFairForFall() {
        return readRoomFair(Season.FALL);
    }

    public RoomFair readRoomFairForWinter() {
        return readRoomFair(Season.WINTER);
    }

    public RoomFair readRoomFairForSpring() {
        return readRoomFair(Season.SPRING);
    }
    private Integer generateNewId() {
        return UUID.randomUUID().hashCode() & Integer.MAX_VALUE;
    }
}
