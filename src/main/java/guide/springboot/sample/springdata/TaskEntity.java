package guide.springboot.sample.springdata;

import javax.persistence.*;

@Entity
@Table(name = "tasks")
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String details;
    private String status = "active";

    protected TaskEntity() {
    }

//    public TaskEntity(String details) {
//        this.details = details;
//    }
//    public TaskEntity(String details, String status) {
//        this.details = details;
//        this.status = status;
//    }
    public String getId() {
        return id;
    }

    public String getDetails() {
        return details;
    }

    public String getStatus() {
        return status;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
