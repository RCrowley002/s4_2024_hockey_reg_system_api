package com.keyin.rest.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {
    @Autowired
    private PlayerRepository playerRepository;

    public Player getByFirstName(String firstName){
        return playerRepository.getByFirstName(firstName);
    }

    public Player getByLastName(String lastName){
        return playerRepository.getByLastName(lastName);
    }

    public List<Player> getAllPlayers(){
        return (List<Player>) playerRepository.findAll();
    }

    public Player getPlayerByID(long id){
        Optional<Player> playerOptional = playerRepository.findById(id);
        return playerOptional.orElse(null);
    }

    public Player createPlayer(Player newPlayer){
        return playerRepository.save(newPlayer);
    }

    public void deletePlayerByID(long id){
        playerRepository.deleteById(id);
    }

    public Player updatePlayer(long id, Player editPlayer){
        Optional<Player> playerEditOptional = playerRepository.findById(id);
        if(playerEditOptional.isPresent()){
            Player playerToEdit = playerEditOptional.get();

            playerToEdit.setBirthday(editPlayer.getBirthday());
            playerToEdit.setFirstName(editPlayer.getFirstName());
            playerToEdit.setLastName(editPlayer.getLastName());

            return playerRepository.save(playerToEdit);
        }
        return null;
    }

}
