package br.com.academiajsp.dao;

import br.com.academiajsp.connection.SingleConnectionBanco;
import br.com.academiajsp.model.ModelLogin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.stream.Stream;

public class DAOLoginRepository {

    private Connection conexaoBanco;

    public DAOLoginRepository() {
        conexaoBanco = SingleConnectionBanco.getConexaoBanco();
    }

    public boolean validarAutenticacao(ModelLogin usuario) {
        String sql = "select * from model_login where upper(login) = upper(?) and upper(senha) = upper(?)";

        try {
            PreparedStatement statement = conexaoBanco.prepareStatement(sql);
            statement.setString(1,usuario.getLogin());
            statement.setString(2, usuario.getSenha());

            ResultSet respostaBanco = statement.executeQuery();

            if(respostaBanco.next()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
