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
public class Comment {
    
    private User user;
    private String text;
    
    public Comment(User user, String text){
        this.user = user;
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public String getText() {
        return text;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setText(String text) {
        this.text = text;
    }
}
