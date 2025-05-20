package org.example;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.PreparedStatement;

@Data
@Builder
@AllArgsConstructor

class RoomFair {
    private Integer id;
    private double value;
    private Season season;

    private final ConnectionProvider connectionProvider;
    private static final String INSERT_ROOM_FAIR_TEMPLATE = "INSERT INTO room_fair (id, value, season) VALUES (?, ?, ?)";

    @SneakyThrows
    public void save(final RoomFair roomFair) {
        try (
                final Connection connection = connectionProvider.getConnection();
                final PreparedStatement statement = connection.prepareStatement(INSERT_ROOM_FAIR_TEMPLATE);
        ) {
            statement.setInt(1, roomFair.getId());
            statement.setDouble(2, roomFair.getValue());
            statement.setString(3, roomFair.getSeason().name());
            int affectedRows = statement.executeUpdate();
            System.out.println("Affected rows = " + affectedRows);
        }
    }
}
