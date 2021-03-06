package com.e17cn2.threetree.service;

import com.e17cn2.threetree.entity.Player;

import java.util.List;

public interface UserService {
    Player addPlayer(Player player);

    Player editPlayer(Player player);

    Player updateMoney(Player player);

    Player deletePlayer(String id);

    Player findPlayerById(String id);

    List<Player> findAllPlayer();

    Player checkLogin(Player player);
}
