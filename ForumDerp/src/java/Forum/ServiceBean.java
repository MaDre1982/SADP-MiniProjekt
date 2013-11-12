/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package Forum;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;


/**
 *
 * @author Martin
 */
@ApplicationScoped
public class ServiceBean {
    
    List<Category> categories;
    List<User> users;
    /**
     * Creates a new instance of Dao
     */
    public ServiceBean() {
        this.categories = new ArrayList<Category>();
        this.users = new ArrayList<User>();
        createSomeObjects();
        //System.out.println(categories.get(0).getMessages().get(0).toString());
    }
    
    public List<Category> getCategories() {
        return new ArrayList<Category>(categories);
    }
    
    public List<User> getUsers() {
        return new ArrayList<User>(users);
    }
    
    public void addUser(User u){
        if(!users.contains(u)){
            users.add(u);
        }
    }
    
    public void deleteUser(User user){
        Iterator<User> itr = users.iterator();
        while (itr.hasNext()) {
            User u = itr.next();
            if(u.equals(user)){
                deleteCategories(u);
                itr.remove();
            }
        }
    }
    
    public void deleteCategories(User user){
        Iterator<Category> itr = categories.iterator();
        while(itr.hasNext()){
            Category cat = itr.next();
            if(cat.getUser().equals(user)){
                deleteMessages(user,cat);
                itr.remove();
            }
        }
    }
    
    public void deleteMessages(User user,Category category){
        Iterator<Message> itr = category.getMessages().iterator();
        while(itr.hasNext()){
            Message mes = itr.next();
            if(mes.getUser().equals(user)){
                deleteComments(user,mes);
                itr.remove();
            }
        }
    }
    
    public void deleteComments(User user, Message message){
        Iterator<Comment> itr = message.getComments().iterator();
        while(itr.hasNext()){
            Comment com = itr.next();
            if(com.getUser().equals(user)){
                itr.remove();
            }
        }
    }
    
    public void addCategory(Category category){
        if(!categories.contains(category)){
            categories.add(category);
        }
    }
    
    public void deleteCategory(Category category){
        if(categories.contains(category)){
            categories.remove(category);
        }
    }
    
    public void createSomeObjects(){
        User u1 = new User("Martin", "111", true);
        User u2 = new User("Nicolai", "222", true);
        User u3 = new User("Vicki", "333", false);
        
        users.add(u1);
        users.add(u2);
        users.add(u3);
        
        Category c1 = new Category("Fodbold", u2);
        Category c2 = new Category("Biler", u1);
        Category c3 = new Category("Musik", u3);
        
        categories.add(c1);
        categories.add(c2);
        categories.add(c3);
        
        Message m1 = new Message("Er en fodbold lavet af læder?", u3);
        Message m2 = new Message("Hvor kan jeg finde en Ford T?", u2);
        Message m3 = new Message("Er Lou Reed død?", u1);
        
        c1.addMessage(m1);
        c2.addMessage(m2);
        c3.addMessage(m3);
        
        Comment com1 = new Comment(u1, "Ja din idiot");
        Comment com2 = new Comment(u2, "Google det!");
        Comment com3 = new Comment(u3, "Ja!!! som 71 årig");
        
        m1.addComment(com1);
        m2.addComment(com2);
        m3.addComment(com3);
        
    }
    
    public User getValidUser(User user){
        for (User u : users) {
            if (u.getName().equals(user.getName())
                    && u.getPassWord().equals(user.getPassWord())) {
                return u;
            }
        }
        return null;
    }
    
    
    
}
