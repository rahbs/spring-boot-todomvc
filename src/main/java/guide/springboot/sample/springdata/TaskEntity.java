package guide.springboot.sample.springdata;

import javax.persistence.*;

@Entity
@Table(name = "tasks")
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id = null;
    private String details;
    private String status = "active";

    protected TaskEntity() {
    }
    public TaskEntity(String details) {
        this.details = details;
    }
    public String getId() {
        return id;
    }

    public String getDetails() {
        return details;
    }

    public String getStatus() {
        return status;
    }

    public TaskEntity(String id, String details, String status) {
        this.id = id;
        this.details = details;
        this.status = status;
    }
}
