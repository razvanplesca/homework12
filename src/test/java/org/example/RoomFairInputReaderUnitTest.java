package org.example;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RoomFairInputReaderUnitTest {

    private final Scanner scanner = mock(Scanner.class);
    private ConnectionProvider connectionProvider = mock(ConnectionProvider.class);

    private final RoomFairInputReader myInputReader = new RoomFairInputReader(scanner, connectionProvider);


    @Test
    void readFromInput() {
        when(scanner.nextLine()).
                thenReturn("100.0").
                thenReturn(Season.SPRING.name());

        RoomFair result = myInputReader.readRoomFair(Season.SPRING);

        assertEquals(100.0,result.getValue());
        verify(scanner, times(2));
    }
}