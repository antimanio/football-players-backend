package service;

import jakarta.enterprise.context.ApplicationScoped;
import model.Player;
import java.util.List;

@ApplicationScoped
public class PlayerService {

    public List<Player> getAllPlayers() {
        return Player.listAll();
    }

    public Player getPlayerById(String id) {
        return Player.findById(id);
    }

    public boolean createPlayer(Player player) {
        player.persist();
        return player.isPersistent();
    }

    public boolean updatePlayer(String id, Player updatedPlayer) {
        Player existingPlayer = Player.findById(id);
        if (existingPlayer != null) {
            existingPlayer.name = updatedPlayer.name;
            existingPlayer.height = updatedPlayer.height;
            existingPlayer.weight = updatedPlayer.weight;
            existingPlayer.birthDate = updatedPlayer.birthDate;
            existingPlayer.league = updatedPlayer.league;
            existingPlayer.foot = updatedPlayer.foot;
            existingPlayer.weakFoot = updatedPlayer.weakFoot;
            existingPlayer.skillMoves = updatedPlayer.skillMoves;
            existingPlayer.marketPrice = updatedPlayer.marketPrice;
            existingPlayer.persist();
            return true;
        }
        return false;
    }

    public boolean deletePlayer(String id) {
        return Player.deleteById(id);
    }
}
