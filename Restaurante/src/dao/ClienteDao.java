
package dao;

import classe.Cliente;
import java.sql.Connection;
import java.sql.ResultSet;
import conexao.Conexao;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;


public class ClienteDao {
    
    private Connection con;
    private ResultSet rs;
    
    
    public ClienteDao(){
        this.con = new Conexao().getConnection();
    }
    
    public void insert(Cliente cliente){
        try{
            PreparedStatement stmt = con.prepareStatement
        ("insert into cliente(nome,telefone,email,status)values(?,?,?,?)");
            
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getTelefone());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4,cliente.getStatus());
            stmt.execute();
            JOptionPane.showMessageDialog(null,"cliente Cadastrado com Sucesso!"); 
            con.close();
            
        }
        catch(SQLException erro){
            throw new RuntimeException(erro); 
        }
        
    }
    
    
     public void edit(Cliente cliente){
        try{
            PreparedStatement stmt = con.prepareStatement
        ("update cliente set nome=?,telefone=?,email=? where idcliente='"+cliente.getIdcliente()+"'");
            
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getTelefone());
            stmt.setString(3, cliente.getEmail());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"Dados Atualizados com Sucesso!"); 
            con.close();
            
        }
        catch(SQLException erro){
            throw new RuntimeException(erro); 
        }
        
    }
     
     
     public void inativo(Cliente cliente){
        try{
            PreparedStatement stmt = con.prepareStatement
        ("update cliente set status=? where idcliente='"+cliente.getIdcliente()+"'");
            
            stmt.setString(1, cliente.getStatus());           
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"Cliente Inativo!"); 
            con.close();
            
        }
        catch(SQLException erro){
            throw new RuntimeException(erro); 
        } 
         
     }
    
     
    
    public void buscaid(Cliente cliente){
      try{  
        
        PreparedStatement stmt = con.prepareStatement
        ("select * from cliente where status='A' and idcliente = '"+cliente.getIdcliente()+"';");
        rs = stmt.executeQuery();
        
        if(rs.next()){
            cliente.setIdcliente(rs.getInt("idcliente"));
            cliente.setNome(rs.getString("nome"));
            cliente.setTelefone(rs.getString("telefone"));
            cliente.setEmail(rs.getString("email"));            
        }
        else{
            JOptionPane.showMessageDialog(null,"Cliente não Encontrado!"); 
        }
        
        //con.close();
        
      }
       catch(SQLException erro){
            throw new RuntimeException(erro); 
        }
      
    }
    
    public void buscanome(Cliente cliente){
      try{  
        
        PreparedStatement stmt = con.prepareStatement
        ("select * from cliente where status='A' and nome = '"+cliente.getNome()+"';");
        rs = stmt.executeQuery();
        
        if(rs.next()){
            cliente.setIdcliente(rs.getInt("idcliente"));
            cliente.setNome(rs.getString("nome"));
            cliente.setTelefone(rs.getString("telefone"));
            cliente.setEmail(rs.getString("email"));            
        }
        else{
            JOptionPane.showMessageDialog(null,"Cliente não Encontrado!"); 
        }
        
        //con.close();
        
      }
       catch(SQLException erro){
            throw new RuntimeException(erro); 
        }
      
    }
    
    
    
}
