package deprecated;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import testapp.service.interfaces.deprecated.ITaskService;
import java.util.List;
import java.util.Optional;

@Primary
@Service
public class TaskService implements ITaskService {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository repository) {
        taskRepository = repository;
    }

    public List<Task> findAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<Task> findTaskById(Long id) {
        return taskRepository.findById(id);
    }

    public Task addTask(Task task) {
        return taskRepository.save(task);
    }

    public void deleteTaskById(Long id) {
        taskRepository.deleteById(id);
    }
}
