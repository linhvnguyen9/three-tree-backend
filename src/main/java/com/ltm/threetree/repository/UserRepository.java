package com.ltm.threetree.repository;

import com.ltm.threetree.entity.Player;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<Player, String> {
    Optional<Player> findById(String id);

    Player save(Player player);

    List<Player> findAllById(String id);

    void deleteById(String id);

}
