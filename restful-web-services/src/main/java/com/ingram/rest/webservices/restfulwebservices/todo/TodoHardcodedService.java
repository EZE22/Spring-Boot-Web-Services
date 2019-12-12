package com.ingram.rest.webservices.restfulwebservices.todo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TodoHardcodedService {

    private static List<Todo> todos = new ArrayList();
    private static int idCounter = 0;

    static {
        todos.add(new Todo(++idCounter, "Everett", "Learn to Dance 2", new Date(), false));
        todos.add(new Todo(++idCounter, "Lindsay", "Learn about Microservices", new Date(), false));
        todos.add(new Todo(++idCounter, "Ellie", "Learn about Angular", new Date(), false));
    }

    public List<Todo> findAll(){
        return todos;
    }

    //This is a simple save method.
    public Todo save(Todo todo){
        if(todo.getId()==-1 || todo.getId()==0){
            //this will add a todo
            todo.setId(++idCounter);
            todos.add(todo);
        } else {
            //if i need to delete this will delete and update the todo
            deleteById(todo.getId());
            todos.add(todo);
        }
        return todo;
    }

    public Todo deleteById(long id){
        Todo todo = findById(id);

        //I am checking if i can find the todo
        if(todo==null) return null;

        //Here i am checking to see if I can delete the todo
        //If it is successful in retuning the todo back the it will return null
        if(todos.remove(todo)){
            return todo;
        }
        return null;
    }

    public Todo findById(long id) {
        for(Todo todo : todos){
            if(todo.getId() == id){
                return todo;
            }
        }
        return null;
    }

}
