package service;

import model.PadelBat;
import model.PadelPlayer;
import repository.PadelRepository;

import java.sql.SQLException;
import java.util.List;

public class PadelService {
    private final PadelRepository repository;

    public PadelService(PadelRepository repository) {
        this.repository = repository;
    }

    public List<PadelPlayer> findAllPlayers() throws SQLException {
        return repository.getAllPlayers();
    }

    public void addPlayer(String name, Integer age, Double level, String club, Integer batId) throws SQLException {
        if (name == null||name.isBlank()||name.length()>100) {
            throw new IllegalArgumentException("Name should be between 1 and 100 characters");
        }
        if (age==null || age < 0) {
            throw new IllegalArgumentException("Age should be positive");
        }
        if (level==null||level<1||level>7) {
            throw new IllegalArgumentException("Level should be positive");
        }
        if (batId<0) {
            throw new IllegalArgumentException("Bat id should be positive");
        }
        repository.addPlayer(name, age, level, club, batId);
    }

    public List<PadelBat> findAllBats() throws SQLException {
        return repository.getAllBats();
    }
}
