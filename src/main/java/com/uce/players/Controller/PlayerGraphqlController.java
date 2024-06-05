package com.uce.players.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;

import org.springframework.stereotype.Controller;


import com.uce.players.Entity.Player;
import com.uce.players.Repository.PlayerRepository;

@Controller
public class PlayerGraphqlController {
    @Autowired
    private PlayerRepository playerRepository;

    // Use for operation as select find etc
    @QueryMapping
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    @QueryMapping
    public Player findById(@Argument Integer id) {
        return playerRepository.findById(id).orElseThrow(
                () -> new RuntimeException(String.format("Player not found %s", id)));

    }

    @MutationMapping
    public Player savePlayer(@Argument Player player) {
        return playerRepository.save(player);
    }

    @MutationMapping
    public Player updatePlayer(@Argument Integer id, @Argument Player player) {
        Player existingPlayer = playerRepository.findById(id).orElse(null);
        if (existingPlayer != null) {
            if (player.getName() != null) {
                existingPlayer.setName(player.getName());
            }
            if (player.getUrlImg() != null) {
                existingPlayer.setUrlImg(player.getUrlImg());
            }
            if (player.getTeam() != null) {
                existingPlayer.setTeam(player.getTeam());
            }
            if (player.getAge() > 0) {
                existingPlayer.setAge(player.getAge());
            }
            return playerRepository.save(existingPlayer);
        } else {
            throw new RuntimeException("Player not found");
        }
    }

    @MutationMapping
    public void deletePlayer(@Argument Integer id) {
        playerRepository.deleteById(id);
    }
}
