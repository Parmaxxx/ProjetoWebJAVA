package projetoWebDSM.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Persistencia {
    private static ArrayList<Usuario> lista = new ArrayList<>();
    

    public static ArrayList<Usuario> getLista() {
        return lista;
    }

    public static void setLista(ArrayList<Usuario> aLista) {
        lista = aLista;
    }
    
    
    public boolean cadastrar(Usuario user){
        if(user != null){
            lista.add(user);
                    return true;
        }else{
            return false;
        }}
        
    public void excluir(long id){    
    
        lista.forEach((Usuario user) -> {
            if(user.getidUsuario() == id){
                lista.remove(user);
            }else{
                JOptionPane.showMessageDialog(null,"Usuario não encontrado");
            }
        });
    }
    
    public boolean alterar(Usuario alteruser){
        lista.forEach((Usuario user) -> {
            if(!lista.isEmpty() && user.getidUsuario() == alteruser.getidUsuario()){
                user.setNome(alteruser.getNome());
                user.setLogin(alteruser.getLogin());
                user.setSenha(alteruser.getSenha());
            } else{
                JOptionPane.showMessageDialog(null, "Usuario inexistente");
            }
        });
        
        return true;
    }
    public void  listar(Usuario user){
        if(lista.isEmpty()){
         JOptionPane.showMessageDialog(null,"Não contem resgistros");
        }else{
         JOptionPane.showMessageDialog(null, lista);
        }
           
  
    }
    
   
    
    public static void importar(String nomeDoArquivo){
        try {
            FileReader arq = new FileReader(nomeDoArquivo);
            BufferedReader lerArq = new BufferedReader(arq);
            String id, nome, login, senha;//criando strings para armazenamento das informações do usuario
            id = lerArq.readLine();
            while (id != null) {
                nome = lerArq.readLine();
                login = lerArq.readLine();
                senha = lerArq.readLine();
                lista.add(new Usuario(nome,login,senha));
                id = lerArq.readLine();
                }
            arq.close();} 
        catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.",e.getMessage());
}
    }
    
    public static void exportar(String nomeDoArquivo) throws IOException{
        FileWriter arq = new FileWriter(nomeDoArquivo);
        PrintWriter gravarArq = new PrintWriter(arq);
        for(Usuario user:lista){
            gravarArq.print(user);
        }
        gravarArq.close();
    }
    }