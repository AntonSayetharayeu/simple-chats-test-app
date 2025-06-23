package testapp.service.interfaces.deprecated;

import deprecated.Task;

import java.util.List;
import java.util.Optional;

public interface ITaskService {
    List<Task> findAllTasks();

    Optional<Task> findTaskById(Long id);

    Task addTask(Task task);

    void deleteTaskById(Long id);
}
