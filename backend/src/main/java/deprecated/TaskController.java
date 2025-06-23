package deprecated;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import testapp.SimpleChats;
import testapp.service.interfaces.deprecated.ITaskService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final ITaskService taskService;

    @Autowired
    public TaskController(ITaskService taskService) {
        this.taskService = taskService;
    }

    private static final Logger logger = LoggerFactory.getLogger(SimpleChats.class);

    @GetMapping("/one")
    public Task getTaskByID(@RequestParam Long id) {
        Optional<Task> taskOpt = taskService.findTaskById(id);

        if (taskOpt.isPresent()) {
            return taskOpt.get();
        }

        throw new RuntimeException("Task not found with id: " + id);
    }

    /*@GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        try {
            List<Task> tasks = taskService.findAll();

            if (tasks.isEmpty()) {
                logger.warn("No tasks found.");
                return ResponseEntity.noContent().build(); // 204 No Content
            }

            logger.info("Retrieved {} tasks successfully", tasks.size());
            return ResponseEntity.ok(tasks); // 200 OK
        } catch (Exception ex) {
            logger.error("Error retrieving tasks: {}", ex.getMessage(), ex);
            return ResponseEntity.internalServerError().build(); // 500 Internal Server Error
        }
    }*/

    @GetMapping
    public List<Task> getAllTasks() {
        try {
            return taskService.findAllTasks();
        } catch (Exception ex) {
            logger.error("Error retrieving tasks: {}", ex.getMessage(), ex);
        }

        return null;
    }

    @PostMapping
    public Task addTask(@RequestBody Task task) {
        try {
            return taskService.addTask(task);
        } catch (Exception ex) {
            logger.error("Error addition of task: {}", ex.getMessage(), ex);
        }

        return task;
    }

    @DeleteMapping("/{id}")
    public void removeTask(@PathVariable Long id) {
        try {
            taskService.deleteTaskById(id);
        } catch (Exception ex) {
            logger.error("Error deleting task: {}", ex.getMessage(), ex);
        }
    }

}
