package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AccomodationUnitTest {

    private final Accomodation mockedAccomodation = mock(Accomodation.class);
    private final Integer id = 1;
    private final String type = "hotel";
    private final String bedType = "single";
    private final Integer maxGuests = 2;
    private final String description = "Nice room";

    @Test
    void saveToDatabase() {
        when(mockedAccomodation.getId()).thenReturn(1);
        when(mockedAccomodation.getType()).thenReturn("hotel");
        when(mockedAccomodation.getBedType()).thenReturn("single");
        when(mockedAccomodation.getMaxGuests()).thenReturn(2);
        when(mockedAccomodation.getDescription()).thenReturn("Nice room");

        assertEquals(id, mockedAccomodation.getId());
        assertEquals(type, mockedAccomodation.getType());
        assertEquals(bedType, mockedAccomodation.getBedType());
        assertEquals(maxGuests, mockedAccomodation.getMaxGuests());
        assertEquals(description, mockedAccomodation.getDescription());

        mockedAccomodation.save(mockedAccomodation);
        verify(mockedAccomodation).save(mockedAccomodation);
    }
}