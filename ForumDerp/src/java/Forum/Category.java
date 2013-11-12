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
public class Category {

    private String name;
    private List<Message> messages;
    private User user;

    public Category() {
        messages = new ArrayList<Message>();
    }

    public Category(String name, User user) {
        this.name = name;
        this.user = user;
        messages = new ArrayList<Message>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Message> getMessages() {
        return new ArrayList<Message>(messages);
    }

    public void addMessage(Message m) {
        messages.add(m);
    }

    public void deleteMessage(Message m) {
        if (messages.contains(m)) {
            messages.remove(m);
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
