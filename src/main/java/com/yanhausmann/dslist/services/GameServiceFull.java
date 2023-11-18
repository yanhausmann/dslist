package com.yanhausmann.dslist.services;

import com.yanhausmann.dslist.dto.GameDTO;
import com.yanhausmann.dslist.entities.Game;
import com.yanhausmann.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameServiceFull {

    @Autowired
    private GameRepository gameRepository;

    public List<GameDTO> findAll(){
        List<Game> result = gameRepository.findAll();
        return result.stream().map(x -> new GameDTO(x)).toList();
    }

    public Game salvarGame(Game game) {
        return gameRepository.save(game);
    }

}
