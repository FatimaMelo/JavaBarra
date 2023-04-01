package dao;

import Interfaces.FrMenu;
import classe.Funcionario;
import java.sql.Connection;
import java.sql.ResultSet;
import conexao.Conexao;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;


public class FuncionarioDao {
    
    private Connection con;
    private ResultSet rs;
    
    
    public FuncionarioDao(){
        this.con = new Conexao().getConnection();
    }
    
    
     
    
    public void buscaid(Funcionario funcionario){
      try{  
        
        PreparedStatement stmt = con.prepareStatement
        ("select * from funcionario where usuario = '"+funcionario.getUsuario()+"'"
        + "and senha = '"+funcionario.getSenha()+"';");
        rs = stmt.executeQuery();
        
        if(rs.next()){
            funcionario.setIdfuncionario(rs.getInt("idfuncionario"));
              funcionario.setNome(rs.getString("nome"));
            funcionario.setTelefone(rs.getString("telefone"));          
            funcionario.setUsuario(rs.getString("senha"));
            funcionario.setSenha(rs.getString("senha")); 
             new FrMenu().setVisible(true);
        }
        else{
            JOptionPane.showMessageDialog(null,"funcionario não Encontrado!"); 
        }
        
        //con.close();
        
      }
       catch(SQLException erro){
            throw new RuntimeException(erro); 
        }
      
    }
    
   
    
    
}
