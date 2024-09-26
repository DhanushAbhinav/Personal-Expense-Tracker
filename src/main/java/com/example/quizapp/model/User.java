package.com.example.quizapp.model;

import java.util.HashMap;
import java.util.Map;

public class User {
    private Long id;
    private String name;
    private Map<Long, Integer> quizAttempts = new HashMap<>();

    public User (Long id, String name) {
        this.id=id;
        this.name=name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAttemptsForQuiz(Long quizId) {
        return quizAttempts.getOrDefault(quizId, 0);
    }

    public void incrementAttempts(Long quizId) {
        quizAttempts.put(quizId,quizAttempts.getOrDefault(quizId,0)+1);
        
    }


}
