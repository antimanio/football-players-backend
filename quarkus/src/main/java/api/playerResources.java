package api;

import java.util.List;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import jakarta.transaction.Transactional;
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

@Path("/players/")
public class playerResources {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPlayers() {
        List<Player> players = Player.listAll();
        return Response.ok(players).build();
    }


    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPlayerById(@PathParam("id") String id) {
        return Player.findByIdOptional(id)
        .map(player -> Response.ok(player).build())
        .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    @POST
    @Transactional
    @Path("add")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createPlayer(@RequestBody Player player) {
        Player.persist(player);
        if(player.isPersistent()){
            return Response.status(Response.Status.CREATED).build();

        }

        return Response.status(Response.Status.BAD_REQUEST).build();
    }


    @PUT
    @Transactional
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updatePlayer(@PathParam("id") String id, @RequestBody Player updatedPlayer) {
    Player existingPlayer = Player.findById(id);
    if (existingPlayer == null) {
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    existingPlayer.name = updatedPlayer.name;
    existingPlayer.height = updatedPlayer.height;
    existingPlayer.weight = updatedPlayer.weight;
    existingPlayer.birthDate = updatedPlayer.birthDate;
    existingPlayer.league = updatedPlayer.league;
    existingPlayer.mainFoot = updatedPlayer.mainFoot;
    existingPlayer.weakFoot = updatedPlayer.weakFoot;
    existingPlayer.skillMoves = updatedPlayer.skillMoves;
    existingPlayer.value = updatedPlayer.value;

    existingPlayer.persist();

    return Response.ok(existingPlayer).build();
}


    @DELETE
    @Transactional
    @Path("{id}")
    public Response deletePlayer(@PathParam("id") String id) {
        boolean deleted = Player.deleteById(id);

        if(deleted) {
            return Response.noContent().build();
        }
    
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

}
