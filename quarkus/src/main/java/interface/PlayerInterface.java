
import java.util.List;
import model.Player;

public interface PlayerInterface {

    List<Player> getAllPlayers();

    Player getPlayerById(String id);

    boolean createPlayer(Player player);

    boolean updatePlayer(String id, Player updatedPlayer);
    
    boolean deletePlayer(String id);

}