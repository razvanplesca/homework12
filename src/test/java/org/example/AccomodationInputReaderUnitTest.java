package org.example;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


class AccomodationInputReaderUnitTest {

    private final Scanner scanner = mock(Scanner.class);
    private ConnectionProvider connectionProvider = mock(ConnectionProvider.class);

    private final AccomodationInputReader myInputReader = new AccomodationInputReader(scanner, connectionProvider);

    @Test
    void getInputData() {
        when(scanner.nextLine())
                .thenReturn("hotel")
                .thenReturn("single")
                .thenReturn("2")
                .thenReturn("Nice room");

        Accomodation result = myInputReader.readAccomodation();

        assertEquals("hotel", result.getType());
        assertEquals("single", result.getBedType());
        assertEquals(2, result.getMaxGuests());
        assertEquals("Nice room", result.getDescription());
        verify(scanner, times(4)).nextLine();
    }
}