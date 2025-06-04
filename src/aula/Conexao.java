/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aula;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alunocmc
 */
public class Conexao {

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/indiebunny", "root", "");

        Class.forName("com.mysql.cj.jdbc.Driver");

        return conexao;
    }

}
