package org.scoula.todo;

public interface TodoDao { // TodoList 기능 구현을 위한 인터페이스
    int getTotalCount(String userId);
    void getTodosByUserId(String userId);
    void getCompletedTodosByUserId(String userId);
    void getUncompletedTodosUserId(String userId);
    void makeTodoCompleted(int id, String userId);
    void createTodo(String todo, String userId);
    void deleteTodo(int id, String userId);
    void getAllTodosWithUserName();
}
