package repository;

import model.PadelBat;
import model.PadelPlayer;
import database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PadelRepository {

    public List<PadelPlayer> getAllPlayers() throws SQLException {
        String sql = "SELECT * FROM padelplayers ORDER BY id";
        List<PadelPlayer> padelPlayerList = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            {
                try (ResultSet rows = statement.executeQuery()) {
                    while (rows.next()) {
                        padelPlayerList.add(new PadelPlayer(rows.getInt("id"),
                                rows.getString("name"), rows.getInt("age"),
                                rows.getDouble("level"), rows.getString("club"),
                                rows.getInt("padelbat_id")));
                    }
                }
            }
        }
        return padelPlayerList;
    }

    public void addPlayer(String name, Integer age, double level, String club, int batId) throws SQLException {
        String sql = "INSERT INTO padelplayers (name, age, level, club, padelbat_id) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            statement.setInt(2, age);
            statement.setDouble(3, level);
            statement.setString(4, club);
            statement.setInt(5, batId);
            statement.executeUpdate();
        }
    }

    public List<PadelBat> getAllBats() throws SQLException{
        String sql = "SELECT * FROM padelbats ORDER BY id";
        List<PadelBat> padelBatList = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            {
                try (ResultSet rows = statement.executeQuery()) {
                    while (rows.next()) {
                        padelBatList.add(new PadelBat(rows.getInt("id"), rows.getString("brand"), rows.getString("model"), rows.getString("shape"), rows.getInt("weight_grams")));
                    }
                }
            }
        }
        return padelBatList;
    }
}
