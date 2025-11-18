package br.com.fiap;

import br.com.fiap.beans.Usuario;
import br.com.fiap.bo.UsuarioBO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import jakarta.ws.rs.ext.Provider;
import java.sql.SQLException;
import java.util.ArrayList;


@Provider

@Path("/usuario")
public class UsuarioResource {

    private UsuarioBO usuarioBO = new UsuarioBO();

    // Selecionar
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Usuario> selecionarRs() throws ClassNotFoundException, SQLException, SQLException {
        return  (ArrayList<Usuario>)  usuarioBO.selecionarBo();
    }

    // Inserir
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirRs(Usuario usuario, @Context UriInfo uriInfo ) throws ClassNotFoundException, SQLException {
        usuarioBO.inserirBo(usuario);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(usuario.getEmail());
        return Response.created(builder.build()).build();
    }

    // Atualizar
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarRs(Usuario usuario, @PathParam("email") String email) throws ClassNotFoundException, SQLException {
        usuarioBO.atualizarBo(usuario);
        return Response.ok().build();
    }

    // Deletar
    @DELETE
    @Path("/{email}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletarRs(@PathParam("email") String email) throws ClassNotFoundException, SQLException {
        usuarioBO.deletarBo(email);
        return Response.ok().build();
    }

}
