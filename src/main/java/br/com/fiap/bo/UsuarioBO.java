package br.com.fiap.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.beans.Usuario;
import br.com.fiap.dao.UsuarioDAO;

public class UsuarioBO {

    UsuarioDAO usuarioDAO;

    // Selecionar
    public ArrayList<Usuario> selecionarBo() throws ClassNotFoundException, SQLException {
        usuarioDAO = new UsuarioDAO();
        // Regra de negocios

        return (ArrayList<Usuario>) usuarioDAO.selecionar();
    }

    // Inserir
    public void inserirBo(Usuario usuario) throws ClassNotFoundException, SQLException {
        UsuarioDAO usuarioDao = new UsuarioDAO();
        // Regra de negocios
        usuarioDao.inserir(usuario);
    }

    // Atualizar
    public void atualizarBo (Usuario usuario) throws ClassNotFoundException, SQLException {
        UsuarioDAO usuarioDao = new UsuarioDAO();
        // Regra de negocios
        usuarioDao.atualizar(usuario);
    }

    // Deletar
    public void deletarBo (String email) throws ClassNotFoundException, SQLException {
        UsuarioDAO unuarioDao = new UsuarioDAO();

        // Regra de negocios

        usuarioDAO.deletar(email);
    }


}
