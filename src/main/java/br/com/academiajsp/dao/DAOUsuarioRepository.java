package br.com.academiajsp.dao;

import br.com.academiajsp.connection.SingleConnectionBanco;
import br.com.academiajsp.model.ModelLogin;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOUsuarioRepository implements Serializable {
    private static final long serialVersionUID = 1L;
    private Connection conexaoBanco;

    public DAOUsuarioRepository() {
        conexaoBanco = SingleConnectionBanco.getConexaoBanco();
    }

    public ModelLogin consultaUsuarioLogado(String login) throws SQLException {
        ModelLogin modelLogin = new ModelLogin();
        String sql = "select * from model_login where upper(login) = upper(?)";

        PreparedStatement statement = conexaoBanco.prepareStatement(sql);
        statement.setString(1,login);

        ResultSet respostaBanco = statement.executeQuery();

        if (respostaBanco.next()) {
            modelLogin = setaCamposModelLogin(respostaBanco, modelLogin);
        }
        return modelLogin;
    }

    public ModelLogin setaCamposModelLogin(ResultSet resultSet, ModelLogin modelLogin) throws SQLException {
        modelLogin.setLogin(resultSet.getString("login"));
        modelLogin.setEmail(resultSet.getString("email"));
        modelLogin.setNome(resultSet.getString("nome"));
        modelLogin.setId(resultSet.getLong("id"));

        return modelLogin;
    }
}
