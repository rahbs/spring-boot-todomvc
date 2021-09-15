package guide.springboot.sample.controller;


import guide.springboot.sample.springdata.TaskEntity;
import guide.springboot.sample.springdata.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    TaskController(final TaskService taskService){
        this.taskService = taskService;
    }

    @GetMapping
    List<TaskEntity> viewAll(){
        return taskService.selectAll();
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    String create(@Valid @RequestBody final String details){

        final var request = new TaskEntity(details);
        return taskService.insert(request);

    }


}
