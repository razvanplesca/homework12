package org.example;

import java.util.Scanner;


class Test {
    void run() {

        final SecretKeyProvider secretKeyProvider = new SecretKeyProviderImpl();
        final ConnectionProvider connectionProvider = new ConnectionProviderImpl(secretKeyProvider);
        final Scanner scanner = new Scanner(System.in);

        final AccomodationInputReader accomodationInputReader = new AccomodationInputReader(scanner, connectionProvider);
        final Accomodation accomodation = accomodationInputReader.readAccomodation();
        accomodation.save(accomodation);

        final RoomFairInputReader roomFairInputReader = new RoomFairInputReader(scanner, connectionProvider);
        final RoomFair roomFairForSpring = roomFairInputReader.readRoomFairForSpring();
        roomFairForSpring.save(roomFairForSpring);
        final AccomodationRoomFairRelation accomodationRoomFairRelation1 = new AccomodationRoomFairRelation(accomodation.getId(),roomFairForSpring.getId(),connectionProvider);
        accomodationRoomFairRelation1.save();

        final RoomFair roomFairForSummer = roomFairInputReader.readRoomFairForSummer();
        roomFairForSummer.save(roomFairForSummer);
        final AccomodationRoomFairRelation accomodationRoomFairRelation2 = new AccomodationRoomFairRelation(accomodation.getId(),roomFairForSummer.getId(),connectionProvider);
        accomodationRoomFairRelation2.save();

        final RoomFair roomFairForFall = roomFairInputReader.readRoomFairForFall();
        roomFairForFall.save(roomFairForFall);
        final AccomodationRoomFairRelation accomodationRoomFairRelation3 = new AccomodationRoomFairRelation(accomodation.getId(),roomFairForFall.getId(),connectionProvider);
        accomodationRoomFairRelation3.save();

        final RoomFair roomFairForWinter = roomFairInputReader.readRoomFairForWinter();
        roomFairForWinter.save(roomFairForWinter);
        final AccomodationRoomFairRelation accomodationRoomFairRelation4 = new AccomodationRoomFairRelation(accomodation.getId(),roomFairForWinter.getId(),connectionProvider);
        accomodationRoomFairRelation4.save();

    }
}
