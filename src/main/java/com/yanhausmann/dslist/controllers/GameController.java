package com.yanhausmann.dslist.controllers;

import com.yanhausmann.dslist.dto.GameMinDTO;
import com.yanhausmann.dslist.entities.Game;
import com.yanhausmann.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameMinDTO> findAll(){
        List<GameMinDTO> result = gameService.findAll();
        return result;
    }

    @PostMapping
    public ResponseEntity<GameMinDTO> salvarJogo(@RequestBody GameMinDTO gameMinDTO) {
        Game game = new Game();
        game.setTitle(gameMinDTO.getTitle());
        game.setGenre(gameMinDTO.getTitle());

        Game savedGame = gameService.salvarGame(game);

        // Usando o construtor do GameMinDTO que obtém valores diretamente do Game
        GameMinDTO savedGameDTO = new GameMinDTO(savedGame);

        return new ResponseEntity<>(savedGameDTO, HttpStatus.CREATED);
    }
}
