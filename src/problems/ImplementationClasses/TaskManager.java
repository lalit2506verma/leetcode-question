package problems.ImplementationClasses;

import com.sun.source.tree.Tree;

import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

public class TaskManager {
    HashMap<Integer, Task> taskIdToTaskMap;
    TreeSet<Task> userToTaskSet;

    public TaskManager(List<List<Integer>> tasks) {
        taskIdToTaskMap = new HashMap<>();
        userToTaskSet = new TreeSet<>((a, b) -> {
            if(a.priority != b.priority) {
                return Integer.compare(b.priority, a.priority);
            }

            return Integer.compare(b.taskId, a.taskId);
        });

        for(List<Integer> task : tasks){
            add(task.get(0), task.get(1), task.get(2));
        }
    }

    public void add(int userId, int taskId, int priority) {
        // adding task in the Map
        Task t = new Task(userId, taskId, priority);

        taskIdToTaskMap.put(taskId, t);
        userToTaskSet.add(t);

    }

    public void edit(int taskId, int newPriority) {
        Task t = taskIdToTaskMap.get(taskId);
        int userId = t.userId;

        userToTaskSet.remove(t);

        t.priority = newPriority;
        userToTaskSet.add(t);
    }

    public void rmv(int taskId) {
        Task t = taskIdToTaskMap.get(taskId);
        int userId  = t.userId;

        taskIdToTaskMap.remove(taskId);

        userToTaskSet.remove(t);

    }

    public int execTop() {
        if(userToTaskSet.isEmpty()){
            return -1;
        }

        Task t = userToTaskSet.getFirst();
        userToTaskSet.remove(t);

        return t.userId;
    }

    static class Task{
        public int taskId;
        public int userId;
        public int priority;

        public Task(int userId, int taskId, int priority) {
            this.taskId = taskId;
            this.userId = userId;
            this.priority = priority;
        }
    }
}
