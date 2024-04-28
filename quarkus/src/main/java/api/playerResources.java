package api;

import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.standard.Media;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import model.Player;
import model.Stats;

@Path("/players/")
public class playerResources {

    public static List<Player> players = new ArrayList<>();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPlayers() {
        return Response.ok(players).build();
    }


    @GET
    @Path("count")
    @Produces(MediaType.APPLICATION_JSON)
    public Integer getPlayersCount() {
        return players.size();
    }

    @POST
    @Path("add")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createPlayer(Player player) {
        players.add(player);
        return Response.ok(player).build();
    }
    

    @PUT
    @Path("{uuid}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updatePlayer(@PathParam("uuid") String uuid, Player player) {

        Player existingPlayer = players.stream()
                .filter(p -> p.getUUID().equals(uuid))
                .findFirst()
                .orElse(null);

        if (existingPlayer != null) {
            // Update the player attributes
            existingPlayer.setName(player.getName());
            existingPlayer.setHeight(player.getHeight());
            existingPlayer.setWeight(player.getWeight());
            existingPlayer.setBirthDate(player.getBirthDate());
            existingPlayer.setLeague(player.getLeague());
            existingPlayer.setMainFoot(player.getMainFoot());
            existingPlayer.setWeakFoot(player.getWeakFoot());
            existingPlayer.setSkillMoves(player.getSkillMoves());
            existingPlayer.setValue(player.getValue());

            // Update player stats
            Stats playerStats = player.getStats();
            if (playerStats != null) {
                existingPlayer.getStats().setPace(playerStats.getPace());
                existingPlayer.getStats().setShooting(playerStats.getShooting());
                existingPlayer.getStats().setPassing(playerStats.getPassing());
                existingPlayer.getStats().setDribbling(playerStats.getDribbling());
                existingPlayer.getStats().setDefending(playerStats.getDefending());
                existingPlayer.getStats().setPhysical(playerStats.getPhysical());
            }

            return Response.ok(existingPlayer).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Player not found to update").build();
        }
    }


     @DELETE
    @Path("{uuid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletePlayer(@PathParam("uuid") String uuid) {
        Player playerToDelete = players.stream()
                .filter(p -> p.getUUID().equals(uuid))
                .findFirst()
                .orElse(null);

        if (playerToDelete != null) {
            players.remove(playerToDelete);
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Player not found to delete").build();
        }
    }


}
