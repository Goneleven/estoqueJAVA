/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aula;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author alunocmc
 */
public class Banco {

    Informacoes infos = new Informacoes();
    Connection conexao = null;

    //----- CADASTRAR FUNCIONÁRIOS -----
    public void cadastrar(Informacoes infos) throws ClassNotFoundException, SQLException {
        String sql = "insert into funcionarios(email,senha) values(?,?)";
        PreparedStatement ps; //Traduz SQL para JAVA
        Connection conexao = new Conexao().getConnection(); //Pegando a Conexão da Classe conexao :o
        ps = conexao.prepareStatement(sql); //Qual SQL será executado
        ps.setString(1, infos.getEmail()); //Inserindo no campo Email
        ps.setString(2, infos.getSenha()); //Inserindo no campo Senha
        ps.execute(); //EXECUTAR

    }

    //----- LOGAR FUNCIONÁRIOS -----
    public void login(Informacoes infos) throws ClassNotFoundException, SQLException {
        Connection conexao = new Conexao().getConnection();
        String loginF = "SELECT * FROM funcionarios WHERE email = '" + infos.email + "'AND Senha = '" + infos.senha + "'";

        PreparedStatement al = conexao.prepareStatement(loginF);
        ResultSet ra = al.executeQuery();

        if (ra.next()) {
            FrameHome home = new FrameHome();
            home.setVisible(true);

            JOptionPane.showMessageDialog(null, "Bem Vindo ao Estoque INDIE BUNNY");

        } else {
            JOptionPane.showMessageDialog(null, "Email e/ou Senha incorretos");
        }
    }

    //----- CADASTRAR JOGOS -----
    public void cadastrarJogos(Informacoes infos) throws ClassNotFoundException, SQLException {
        String sql = "insert into jogos(titulo,preco,quantidade) values(?,?,?)";
        PreparedStatement ps; //Traduz SQL para JAVA
        Connection conexao = new Conexao().getConnection(); //Pegando a Conexão da Classe conexao :o
        ps = conexao.prepareStatement(sql); //Qual SQL será executado
        ps.setString(1, infos.getTitulo()); //Inserindo no campo Titulo
        ps.setDouble(2, infos.getPreco()); //Inserindo no campo Preço
        ps.setInt(3, infos.getQuantidade()); //Inserindo no campo Quantidade
        ps.execute(); //EXECUTAR

    }

    //----- CONSULTAR JOGOS -----
    public void consultar(Informacoes infos) throws ClassNotFoundException, SQLException {
        conexao = new Conexao().getConnection();
        String sql = "SELECT * FROM jogos WHERE idJogo = ?";
        PreparedStatement st = conexao.prepareStatement(sql);
        st.setInt(1, infos.getIdJogo());
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            infos.setTitulo(rs.getString(2));
            infos.setQuantidade(rs.getInt(4));
        }

    }

    //----- PESQUISAR JOGOS NA ABA DE ALTERAÇÃO -----
    public void pesquisar(Informacoes infos) throws ClassNotFoundException, SQLException {
        conexao = new Conexao().getConnection();
        String sql = "SELECT * FROM jogos WHERE idJogo = ?";
        PreparedStatement st = conexao.prepareStatement(sql);
        st.setInt(1, infos.getIdJogo());
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            infos.setTitulo(rs.getString(2));
            infos.setPreco(rs.getDouble(3));
            infos.setQuantidade(rs.getInt(4));
        }
    }

    //----- ALTERAR JOGOS -----
    public void alterar(Informacoes infos, int id) throws ClassNotFoundException, SQLException {
        conexao = new Conexao().getConnection();
        String sql = "UPDATE jogos set titulo=?, preco=?, quantidade=? WHERE idJogo = ?";
        PreparedStatement st = conexao.prepareStatement(sql);
        st.setString(1, infos.getTitulo());
        st.setDouble(2, infos.getPreco());
        st.setInt(4, infos.getIdJogo());
        st.setInt(3, infos.getQuantidade());

        st.executeUpdate();
    }

    //----- EXCLUIR JOGOS -----
    public void excluir(Informacoes infos, int id) throws SQLException, ClassNotFoundException {
        conexao = new Conexao().getConnection();
        String sql = "DELETE FROM jogos WHERE idJogo = ?";
        PreparedStatement st = conexao.prepareStatement(sql);
        st.setInt(1, infos.getIdJogo());

        st.execute();
    }
}
