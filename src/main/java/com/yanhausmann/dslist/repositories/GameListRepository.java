package com.yanhausmann.dslist.repositories;

import com.yanhausmann.dslist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList, Long> {
}
