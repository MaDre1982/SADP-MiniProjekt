/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Forum;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Martin
 */

public class Message {
    private String emne;
    private User user;
    private List<Comment> comments;
    
    public Message(String emne, User user){
        this.emne = emne;
        this.user = user;
        comments = new ArrayList<Comment>();
    }

    public String getEmne() {
        return emne;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public User getUser() {
        return user;
    }

    public void setEmne(String emne) {
        this.emne = emne;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void addComment(Comment c){
        comments.add(c);
    }
    
    public void deleteComment(Comment c){
        if(comments.contains(c)){
        comments.remove(c);
        }
    }
    
    @Override
    public String toString(){
        return emne;
    }
    
}
