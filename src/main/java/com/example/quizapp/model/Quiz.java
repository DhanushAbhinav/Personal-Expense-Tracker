package.com.example.quizapp.model;

import java.util.HashSet;
import java.util.Set;

public class Quiz {
    private Long id;
    private String title;
    private Set<User> assignedUsers=new HashMap<>();

    public Quiz (Long id, String title) {
        this.id=id;
        this.title=title;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Set<User> getAssignedUsers() {
        return assignedUsers;
    }

    public void assignUser(User user) {
        this.assignedUsers.add(user);

    }

}