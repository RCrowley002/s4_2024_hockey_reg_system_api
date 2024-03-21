package com.keyin.rest.player;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Long> {
    public Player getByFirstName(String firstName);
    public Player getByLastName(String lastName);
}
