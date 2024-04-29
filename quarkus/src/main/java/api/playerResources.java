package api;

import java.util.List;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import jakarta.inject.Inject;
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
import service.PlayerService;

@Path("/players/")
public class playerResources {

    @Inject
    PlayerService playerService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPlayers() {
        List<Player> players = playerService.getAllPlayers();
        return Response.ok(players).build();
    }


    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPlayerById(@PathParam("id") String id) {
        Player player = playerService.getPlayerById(id);
        if (player == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } 
        return Response.ok(player).build();

    }

    @POST
    @Transactional
    @Path("create")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createPlayer(Player player) {
        boolean created = playerService.createPlayer(player);
        if (!created) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.status(Response.Status.CREATED).build();
    }



    @PUT
    @Transactional
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updatePlayer(@PathParam("id") String id, @RequestBody Player updatedPlayer) {
    boolean updated = playerService.updatePlayer(id, updatedPlayer);
    if(!updated) {
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    return Response.ok(updatedPlayer).build();

    }

    @DELETE
    @Transactional
    @Path("{id}")
    public Response deletePlayer(@PathParam("id") String id) {
        boolean deleted = playerService.deletePlayer(id);
        if (!deleted) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.noContent().build();
    }

}
