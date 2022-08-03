package br.com.academiajsp.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnectionBanco {

    private static String url = "jdbc:postgresql://localhost:5432/academia";
    private static String login = "postgres";
    private static String password = "admin";
    private static Connection conexaoBanco = null;

    static {
        conectar();
    }

    public SingleConnectionBanco() {
        conectar();
    }

    public static void conectar() {

        try {
            if (conexaoBanco == null) {
                Class.forName("org.postgresql.Driver");
                conexaoBanco = DriverManager.getConnection(url, login, password);
                conexaoBanco.setAutoCommit(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConexaoBanco() {
        return conexaoBanco;
    }
}
