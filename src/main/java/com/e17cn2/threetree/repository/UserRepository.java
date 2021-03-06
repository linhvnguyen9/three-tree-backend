package com.e17cn2.threetree.repository;

import com.e17cn2.threetree.entity.Player;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<Player, String> {
    Optional<Player> findById(String id);

    Player save(Player player);

    List<Player> findAll();

    void deleteById(String id);

//    @Query("{ 'username': ?0}")
    Optional<Player> findByUsername(String username);

}
