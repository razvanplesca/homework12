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
class Accomodation {
    private Integer id;
    private String type;
    private String bedType;
    private Integer maxGuests;
    private String description;

    private final ConnectionProvider connectionProvider;
    private static final String INSERT_ACCOMODATION_TEMPLATE = "INSERT INTO accomodation (id, type, bed_type, max_guests, description) VALUES (?, ?, ?, ?, ?)";


    @SneakyThrows
    public void save(final Accomodation accomodation) {
        try (
                final Connection connection = connectionProvider.getConnection();
                final PreparedStatement statement = connection.prepareStatement(INSERT_ACCOMODATION_TEMPLATE);
        ) {
            statement.setInt(1, accomodation.getId());
            statement.setString(2, accomodation.getType());
            statement.setString(3, accomodation.getBedType());
            statement.setInt(4, accomodation.getMaxGuests());
            statement.setString(5, accomodation.getDescription());
            int affectedRows = statement.executeUpdate();
            System.out.println("Affected rows = " + affectedRows);
        }
    }
}
