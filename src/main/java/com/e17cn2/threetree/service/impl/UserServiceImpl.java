package com.e17cn2.threetree.service.impl;

import com.e17cn2.threetree.entity.Player;
import com.e17cn2.threetree.repository.UserRepository;
import com.e17cn2.threetree.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Player addPlayer(Player player) {
        Player created = Player.builder()
                .username(player.getUsername())
                .password(player.getPassword())
                .money(50000)
                .playerStatus(player.getPlayerStatus())
                .build();
        created = userRepository.save(created);
        return created;
    }

    @Override
    public Player editPlayer(Player player) {
        Player updated = findPlayerById(player.getId());
        if (Objects.nonNull(updated)) {
            updated.setUsername(player.getUsername());
            updated.setPassword(player.getPassword());

            userRepository.save(updated);
        }
        return updated;
    }

    @Override
    public Player updateMoney(Player player) {
        Player updated = findPlayerById(player.getId());
        if (Objects.nonNull(updated)) {
            updated.setMoney(player.getMoney());
            userRepository.save(updated);
        }
        return updated;
    }

    @Override
    public Player deletePlayer(String id) {
        Player deleted = findPlayerById(id);
        if (Objects.nonNull(deleted)) {
            userRepository.deleteById(deleted.getId());
            return deleted;
        } else return null;
    }

    @Override
    public Player findPlayerById(String id) {
        Player player = userRepository.findById(id).orElse(null);
        return player;
    }

    @Override
    public List<Player> findAllPlayer() {
        List<Player> playerList = userRepository.findAll();
        List<Player> sortedUsers = playerList.stream().
                sorted(Comparator.comparing(Player::getMoney).reversed())
                .collect(Collectors.toList());
        return sortedUsers;
    }

    @Override
    public Player checkLogin(Player player) {
        Player player1 = userRepository.findByUsername(player.getUsername()).orElse(new Player());
        if (player.getPassword().equals(player1.getPassword())) {
            return player1;
        } else return null;
    }

}
