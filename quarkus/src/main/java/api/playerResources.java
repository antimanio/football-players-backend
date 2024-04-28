package api;

import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.standard.Media;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import model.Player;

@Path("/football/")
public class playerResources {

    public static List<Player> players = new ArrayList<>();

    @GET
    @Path("players")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPlayers() {
        return Response.ok(players).build();
    }


    @GET
    @Path("players/count")
    @Produces(MediaType.APPLICATION_JSON)
    public Integer getPlayersCount() {
        return players.size();
    }

    @POST
    @Path("players/add")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createPlayer(Player player) {
        players.add(player);
        return Response.ok(player).build();
    }

    
}
