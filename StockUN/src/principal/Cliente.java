package principal;

import java.util.*;

public class Cliente {
    private String ID;
    private String pw;
    public HashMap clienteMap = new HashMap();// linea en el main publica
    
    Cliente(){
        this.ID="";
        this.pw="";
    }
    Cliente(String ID,String pw){
        this.ID=ID;
        this.pw=pw;
        clienteMap.put(ID,pw);//nombre del Map
    }
    
    public String getID(){
        return ID;
    }
    
    public String toString(){
        return "ID: "+this.ID+"\npw: "+clienteMap.get(ID);//nombre del Map
    }
    
    public boolean login(String pw){
        return clienteMap.get(ID).equals(pw);//nombre del Map
    }
    
    public void cambioPw(String pw){
        this.pw=pw;
        clienteMap.put(ID,pw);//nombre del Map
    }
    
}
