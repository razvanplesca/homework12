package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AccomodationRoomFairRelationUnitTest {

    private final ConnectionProvider connectionProvider = mock(ConnectionProvider.class);
    AccomodationRoomFairRelation mockedRelation = mock(AccomodationRoomFairRelation.class);

    private final Accomodation accomodation = new Accomodation(1,"house","double",4,"seaview",null);
    List<Accomodation> accomodations = new ArrayList<>();

    private final RoomFair roomFair1 = new RoomFair(1,23.45,Season.SUMMER,null);
    private final RoomFair roomFair2 = new RoomFair(2,28.00,Season.SPRING,null);
    private final RoomFair roomFair3 = new RoomFair(3,17.25,Season.SUMMER,null);
    private final RoomFair roomFair4 = new RoomFair(4,30.00,Season.SUMMER,null);
    List<RoomFair> roomFairs = new ArrayList<>();

    @Test
    void getSeasonFairForEachAccomodation() {
        accomodations.add(accomodation);
        roomFairs.add(roomFair1);
        roomFairs.add(roomFair2);
        roomFairs.add(roomFair3);
        roomFairs.add(roomFair4);

        List<AccomodationRoomFairRelation> relations = new ArrayList<>();
        relations.add(new AccomodationRoomFairRelation(accomodation.getId(), roomFair1.getId(), connectionProvider));
        relations.add(new AccomodationRoomFairRelation(accomodation.getId(), roomFair2.getId(), connectionProvider));
        relations.add(new AccomodationRoomFairRelation(accomodation.getId(), roomFair3.getId(), connectionProvider));
        relations.add(new AccomodationRoomFairRelation(accomodation.getId(), roomFair4.getId(), connectionProvider));

        assertEquals(relations.size(), roomFairs.size());
        assertEquals(1, accomodation.getId());
        assertEquals(4, roomFair4.getId());

        when(mockedRelation.getSeasonFairForEachAccomodation()).thenReturn(relations);

        List<AccomodationRoomFairRelation> result = mockedRelation.getSeasonFairForEachAccomodation();
        assertEquals(relations, result);

        verify(mockedRelation, times(1)).getSeasonFairForEachAccomodation();
    }
}