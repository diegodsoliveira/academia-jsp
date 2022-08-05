package br.com.academiajsp.filter;

import br.com.academiajsp.connection.SingleConnectionBanco;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebFilter(urlPatterns = "/principal/*")
public class FilterAutenticacao implements Filter {

    private static Connection conexaoBanco;

    public FilterAutenticacao() {
    }

    public void init(FilterConfig config) throws ServletException {
        conexaoBanco = SingleConnectionBanco.getConexaoBanco();
    }

    public void destroy() {
        try {
            conexaoBanco.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        try {
            HttpServletRequest req = (HttpServletRequest) request;
            HttpSession session = req.getSession();

            String usuarioLogado = (String) session.getAttribute("usuario");
            String urlAutenticacao = req.getServletPath();

            if (usuarioLogado == null && !urlAutenticacao.equalsIgnoreCase("/principal/ServletLogin")) {
                request.setAttribute("msg","É preciso estar logado no sistema");
                request.getRequestDispatcher("/index.jsp?url=" + urlAutenticacao).forward(request, response);
                return;
            } else {
                chain.doFilter(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("msg", e.getMessage());
            request.getRequestDispatcher("404.jsp").forward(request, response);

            try {
                conexaoBanco.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
