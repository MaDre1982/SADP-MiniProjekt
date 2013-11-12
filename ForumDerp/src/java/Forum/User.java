/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Forum;

/**
 *
 * @author Martin
 */
public class User {
    
    private String name;
    private String passWord;
    private boolean admin;
   

    /**
     * Creates a new instance of UserBean
     */
    public User(String name, String passWord, boolean admin) {
        this.name = name;
        this.passWord = passWord;
        this.admin = admin;
    }
    
    public User(){
        
    }

    public String getName() {
        return name;
    }

    public String getPassWord() {
        return passWord;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
    
    @Override
    public String toString(){
        return name;
    }
    
  
}
