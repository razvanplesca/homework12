package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RoomFairUnitTest {

    private final RoomFair mockedRoomFair = mock(RoomFair.class);
    private final Integer id = 1;
    private final double value = 100.0;
    private final Season season = Season.SPRING;


    @Test
    void saveToDatabase() {
        when(mockedRoomFair.getId()).thenReturn(1);
        when(mockedRoomFair.getValue()).thenReturn(100.0);
        when(mockedRoomFair.getSeason()).thenReturn(Season.SPRING);

        assertEquals(id, mockedRoomFair.getId());
        assertEquals(value, mockedRoomFair.getValue());
        assertEquals(season, mockedRoomFair.getSeason());

        mockedRoomFair.save(mockedRoomFair);
        verify(mockedRoomFair).save(mockedRoomFair);
    }

}