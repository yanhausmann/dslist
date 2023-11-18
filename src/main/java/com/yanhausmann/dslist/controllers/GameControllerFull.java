package com.yanhausmann.dslist.controllers;


import com.yanhausmann.dslist.dto.GameDTO;
import com.yanhausmann.dslist.entities.Game;
import com.yanhausmann.dslist.services.GameServiceFull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/games/full")
public class GameControllerFull {

    @Autowired
    private GameServiceFull gameServiceFull;

    @GetMapping
    public List<GameDTO> findAll(){
        List<GameDTO> result = gameServiceFull.findAll();
        return result;
    }

    @PostMapping
    public ResponseEntity<GameDTO> salvarJogoFull(@RequestBody GameDTO gameDTO) {
        Game game = new Game();
        game.setNome(gameDTO.getNome());
        game.setGenre(gameDTO.getNome());
        game.setYear(gameDTO.getYear());
        game.setPlatform(gameDTO.getPlatform());
        game.setShortDescription(gameDTO.getShortDescription());
        game.setLongDescription((gameDTO.getLongDescription()));
        game.setImgUrl(gameDTO.getImgUrl());

        Game savedGame = gameServiceFull.salvarGame(game);
        GameDTO savedGameDTO = new GameDTO(savedGame);

        return new ResponseEntity<>(savedGameDTO, HttpStatus.CREATED);
    }
}
