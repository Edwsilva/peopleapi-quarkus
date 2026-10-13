package dev_java10x.peopleapi.controller;

import org.jboss.logging.Logger;

import dev_java10x.peopleapi.domain.Users;
import dev_java10x.peopleapi.service.UserService;
import jakarta.inject.Inject;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
@Path("/users")
public class UseController {

    private static final Logger LOG = Logger.getLogger(UseController.class);

    @Inject
    UserService userService;

    @GET 
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAllUsers(@QueryParam ("page") @DefaultValue("0") Integer page,
                                 @QueryParam ("pageSize") @DefaultValue("10") Integer pageSize) {
          LOG.infof("Buscando usuários: page=%d, pageSize=%d", page, pageSize);

          var users = userService.findAllUsers(page, pageSize);
          return Response.ok(users)
              .header("X-Total-Count", userService.countUsers())
              .build();
    }

    @POST 
    @Produces(MediaType.APPLICATION_JSON)
    
    public Response createUsers(Users users) {
        LOG.infof("Recebendo requisição POST /users: username=%s, email=%s", users.username, users.email);
        Users created = userService.createUser(users);
        return Response
            .status(Response.Status.CREATED)
            .entity(created)
            .build();
        // return Response.ok(userService.createUser(created)).build();
    }
}
