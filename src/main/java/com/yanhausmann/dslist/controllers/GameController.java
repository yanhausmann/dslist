package com.yanhausmann.dslist.controllers;

import com.yanhausmann.dslist.dto.GameDTO;
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
        game.setNome(gameMinDTO.getNome());
        game.setGenre(gameMinDTO.getNome());
        game.setShortDescription(gameMinDTO.getShortDescription());
        game.setYear(gameMinDTO.getYear());

        Game savedGame = gameService.salvarGame(game);
        GameMinDTO savedGameDTO = new GameMinDTO(savedGame);

        return new ResponseEntity<>(savedGameDTO, HttpStatus.CREATED);
    }


}
