package org.example;

import java.util.Scanner;
import java.util.UUID;
class AccomodationInputReader {

    private final Scanner scanner;
    private final ConnectionProvider connectionProvider;



    public AccomodationInputReader(final Scanner scanner, ConnectionProvider connectionProvider) {
        this.scanner = scanner;
        this.connectionProvider = connectionProvider;
    }

    public Accomodation readAccomodation() {
        System.out.print("Enter type: ");
        final String type = scanner.nextLine();
        System.out.print("Enter bed type: ");
        final String bedType = scanner.nextLine();
        System.out.print("Enter max guests: ");
        final Integer maxGuests = Integer.valueOf(scanner.nextLine());
        System.out.print("Enter description: ");
        final String description = scanner.nextLine();
        return Accomodation.builder().
                id(generateNewId()).
                type(type).
                bedType(bedType).
                maxGuests(maxGuests).
                description(description).
                connectionProvider(connectionProvider).
                build();
    }
    private Integer generateNewId() {
        return UUID.randomUUID().hashCode() & Integer.MAX_VALUE;
    }


}
