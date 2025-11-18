package br.com.fiap.dao;

import br.com.fiap.beans.Usuario;
import br.com.fiap.conexoes.ConexaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    public Connection minhaConexao;

    // metodo construtor com parâmetro vazio
    public UsuarioDAO() throws SQLException, ClassNotFoundException {
        super();
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    // Insert
    public String inserir(Usuario usuario) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("Insert into T_FIAP_USUARIO values (?, ?, ?, ?, ?, ?)");
        stmt.setString(1, usuario.getNome());
        stmt.setString(2, usuario.getSobrenome());
        stmt.setInt(3, usuario.getIdade());
        stmt.setString(4, usuario.getCurso());
        stmt.setString(5, usuario.getEmail());
        stmt.setString(6, usuario.getSenha());

        stmt.execute();
        stmt.close();

        return "Usuario cadastrado com sucesso!";
    }

    // Delete
    public String deletar(String email) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("Delete from T_FIAP_USUARIO where EMAIL = ?");
        stmt.setString(1, email);

        stmt.execute();
        stmt.close();

        return  "Usuario deletado com sucesso!";
    }

    // UpDate
    public String atualizar(Usuario usuario) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("Update T_FIAP_USUARIO set NOME = ?, SOBRENOME = ?, IDADE = ?, CURSO = ?, SENHA = ? where EMAIL = ?");
        stmt.setString(1, usuario.getNome());
        stmt.setString(2, usuario.getSobrenome());
        stmt.setInt(3, usuario.getIdade());
        stmt.setString(4, usuario.getCurso());
        stmt.setString(5, usuario.getEmail());
        stmt.setString(6, usuario.getSenha());

        stmt.executeUpdate();
        stmt.close();

        return "Usuario atualizado com sucesso!";
    }

    // Select
    public List<Usuario> selecionar() throws SQLException {
        List<Usuario> listaUsuarios = new ArrayList<Usuario>();
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("select * from T_FIAP_USUARIO");
        ResultSet rs = stmt.executeQuery();

        while(rs.next()){
            Usuario usuario = new Usuario();
            usuario.setNome(rs.getString(1));
            usuario.setSobrenome(rs.getString(2));
            usuario.setIdade(rs.getInt(3));
            usuario.setCurso(rs.getString(4));
            usuario.setEmail(rs.getString(5));
            usuario.setSenha(rs.getString(6));
            listaUsuarios.add(usuario);
        }
        return listaUsuarios;
    }


}
