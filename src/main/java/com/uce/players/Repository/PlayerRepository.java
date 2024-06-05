package com.uce.players.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uce.players.Entity.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer>{
    
}
