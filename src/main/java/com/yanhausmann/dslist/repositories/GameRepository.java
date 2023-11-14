package com.yanhausmann.dslist.repositories;

import com.yanhausmann.dslist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
