package br.com.academiajsp.servlets;

import br.com.academiajsp.dao.DAOLoginRepository;
import br.com.academiajsp.dao.DAOUsuarioRepository;
import br.com.academiajsp.model.ModelLogin;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = {"/principal/ServletLogin", "/ServletLogin"})
public class ServletLogin extends HttpServlet {

    private DAOLoginRepository daoLoginRepository = new DAOLoginRepository();
    private DAOUsuarioRepository daoUsuarioRepository = new DAOUsuarioRepository();

    public ServletLogin () {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String acao = request.getParameter("acao");

            if (acao != null && !acao.isEmpty() && acao.equalsIgnoreCase("logout")) {
                request.getSession().invalidate();
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } else {
                doPost(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String senha = request.getParameter("password");
        String url = request.getParameter("url");

        try {

            if (login != null && !login.isEmpty() && senha != null && !senha.isEmpty()) {
                ModelLogin modelLogin = new ModelLogin();
                modelLogin.setLogin(login);
                modelLogin.setSenha(senha);

                try {
                    if(daoLoginRepository.validarAutenticacao(modelLogin)) {
                        modelLogin = daoUsuarioRepository.consultaUsuarioLogado(login);

                        request.getSession().setAttribute("usuario", modelLogin.getLogin());

                        if (url == null || url.equals("null")) {
                            url = "principal/principal.jsp";
                        }
                        request.getRequestDispatcher(url).forward(request, response);
                    } else {
                        request.setAttribute("msg", "Login ou senha inválidos.");
                        request.getRequestDispatcher("index.jsp").forward(request, response);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else {
                request.setAttribute("msg", "Login ou senha inválidos.");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();

            request.setAttribute("msg", e.getMessage());
            request.getRequestDispatcher("erro.jsp").forward(request, response);
        }
    }
}
