/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forum;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Martin
 */
@Named
@SessionScoped
public class UserBean implements Serializable {

    //User
    private User user = new User();
    private User validUser;
    private String selectedUser;
    private String userName;
    private String userPassword;
    //Category
    private Category selectedCategory;
    private String categoryName = "";
    //Message
    private Message selectedMessage;
    private String messageEmne;
    //Comment
    private String commentText = "";
    
    private boolean loggedIn=false;
   
    @Inject
    private ServiceBean service;

    public UserBean() {
    }

    public List<Category> getCategories() {
        return service.getCategories();
    }

    public Category getSelectedCategory() {
        return selectedCategory;
    }

    public void setSelectedCategory(Category selectedCategory) {
        this.selectedCategory = selectedCategory;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String createCategory() {
        service.addCategory(new Category(categoryName, user));
        categoryName = "";
        return null;
    }

    public String selectCategory(Category category) {
        this.selectedCategory = category;
//        tempUser = selectedUser.copy();
        return "category";
    }

    public String createPost() {
        selectedCategory.addMessage(new Message(messageEmne, user));
        messageEmne = "";
        return null;
    }

    public Message getSelectedMessage() {
        return selectedMessage;
    }

    public void setSelectedMessage(Message selectedMessage) {
        this.selectedMessage = selectedMessage;
    }

    public String selectMessage(Message message) {
        this.selectedMessage = message;
        return "message";
    }

    public String getMessageEmne() {
        return messageEmne;
    }

    public void setMessageEmne(String messageEmne) {
        this.messageEmne = messageEmne;
    }

    public User getUser() {
        return user;
    }

    public List<Message> getMessages() {
        return this.selectedCategory.getMessages();
    }

    public void setMessages(List<Message> messages) {
        messages = this.selectedCategory.getMessages();
    }

    public List<Comment> getComments() {
        return this.selectedMessage.getComments();
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public String createComment() {
        this.selectedMessage.addComment(new Comment(user, commentText));
        commentText = "";
        return null;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public User register() {
        boolean found = false;
        int i = 0;
        while (!found && i < service.getUsers().size()) {
            if (service.getUsers().get(i).getName().equals(userName)) {
                found = true;
                FacesContext.getCurrentInstance().addMessage("name", new FacesMessage("Username already in use!"));

            } else {
                i++;
            }
        }
        if (!found) {
            service.addUser(new User(userName, userPassword, false));
            userName = "";
            userPassword = "";
            FacesContext.getCurrentInstance().addMessage("register", new FacesMessage("Succes!"));
        }

        return null;
    }

    public String getSelectedUser() {
        return selectedUser;
    }

    public void setSelectedUser(String selectedUser) {
        this.selectedUser = selectedUser;
    }

    public User getValidUser() {
        return validUser;
    }

    public String deleteUser() {
        for (User u : getUsers()) {
            if (u.getName().equals(selectedUser)) {
                service.deleteUser(u);
                break;
            }
        }
        return null;
    }

    public List<User> getUsers() {
        List<User> temp = new ArrayList<User>();
        for (User u : this.service.getUsers()) {
            if (u != validUser) {
                temp.add(u);
            }
        }
        return temp;
    }

    public String login(){
        validUser = service.getValidUser(user);
        if (validUser != null){
             loggedIn = true;
             user.update(validUser);
            return "Welcome";
        }
        else{
            user = new User();
            return "Error";
        }
    }
    
     public String logout() {
        loggedIn = false;
        return "index?faces-redirect=true";
    }
}
