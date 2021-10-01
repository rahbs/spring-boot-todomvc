package guide.springboot.sample.controller;


import guide.springboot.sample.springdata.TaskEntity;
import guide.springboot.sample.springdata.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/{id}")
    ResponseEntity<TaskEntity> viewById(@PathVariable("id") final String id){
        return ResponseEntity.of(taskService.select(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    String create(@Valid @RequestBody final TaskEntity taskEntity){
        return taskService.insert(taskEntity);

    }
    @PatchMapping("/{id}")
    TaskEntity patch(
            @PathVariable("id") final String id,
            @RequestBody final TaskEntity attributes){
        return taskService.patch(id,attributes);
    }
    @PutMapping("/{id}")
    TaskEntity update(
            @PathVariable("id") final String id,
            @RequestBody final TaskEntity attributes
    ) {
        return taskService.update(id, attributes);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable("id") final String id) {
        taskService.delete(id);
    }


}
