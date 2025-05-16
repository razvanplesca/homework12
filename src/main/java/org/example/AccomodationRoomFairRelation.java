package org.example;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

class AccomodationRoomFairRelation {
    private Integer id;
    private Accomodation accomodation;
    private RoomFair roomFair;

    private final ConnectionProvider connectionProvider;
    private static final String INSERT_ACCOMODATION_ROOM_FAIR_RELATION_TEMPLATE = "INSERT INTO accomodation_room_fair_relation (accomodation_id, room_fair_id) VALUES (?, ?)";
    private static final String FIND_ALL_ACCOMODATION_SEASON_FAIR =
            "SELECT a.type, r.season, r.value\n" +
                    "FROM accomodation a\n" +
                    "JOIN public.accomodation_room_fair_relation arfr on a.id = arfr.accomodation_id\n" +
                    "JOIN public.room_fair r on r.id = arfr.room_fair_id;";

    public AccomodationRoomFairRelation(Integer accomodation_id, Integer roomFair_id, ConnectionProvider connectionProvider) {
        this.accomodation = Accomodation.builder().id(accomodation_id).build();
        this.roomFair = RoomFair.builder().id(roomFair_id).build();
        this.connectionProvider = connectionProvider;
    }

    @SneakyThrows
    public void save() {

        try(final Connection connection = connectionProvider.getConnection();
            final PreparedStatement statement = connection.prepareStatement(INSERT_ACCOMODATION_ROOM_FAIR_RELATION_TEMPLATE)) {
            statement.setInt(1, accomodation.getId());
            statement.setInt(2, roomFair.getId());
            int affectedRows = statement.executeUpdate();
            System.out.println("Affected rows = " + affectedRows);
        }

    }
    @SneakyThrows
    public List<AccomodationRoomFairRelation> getSeasonFairForEachAccomodation() {
        try (
                final Connection connection = connectionProvider.getConnection();
                final Statement statement = connection.createStatement();
                final ResultSet resultSet = statement.executeQuery(FIND_ALL_ACCOMODATION_SEASON_FAIR)
        ) {
            final List<AccomodationRoomFairRelation> accomodations = new ArrayList<>();
            while (resultSet.next()) {
                Accomodation accomodation = Accomodation.builder()
                        .type(resultSet.getString("type"))
                        .build();

                RoomFair roomFair = RoomFair.builder()
                        .season(Season.valueOf(resultSet.getString("season")))
                        .value(resultSet.getDouble("value"))
                        .build();

                final AccomodationRoomFairRelation relation = new AccomodationRoomFairRelation(
                        accomodation.getId(),
                        roomFair.getId(),
                        connectionProvider
                );
                relation.accomodation = accomodation;
                relation.roomFair = roomFair;

                accomodations.add(relation);
            }
            for(AccomodationRoomFairRelation relation : accomodations){
                System.out.println(relation.accomodation.getType() + " " +
                        relation.roomFair.getSeason() + " " +
                        relation.roomFair.getValue());
            }
            return accomodations;
        }
    }

}
