import {TodoService} from '../service/todo.service';
import {Todo} from '../models/todo';
import { Component, OnInit, Output, EventEmitter, Input } from '@angular/core';

@Component({
    selector: 'app-todo-list',
    templateUrl: './todo-list.component.html',
    styleUrls: ['./todo-list.component.css']
})

export class TodoListComponent implements OnInit {
    todos: Todo[];
    name: String;
    sortedData: Todo[];
    searchString: string;

    constructor(private todoService: TodoService) {
    }

    headElements = ['nameInput', 'remove', 'save', 'toggle'];

    ngOnInit() {
        this.getTodos();
    }

    public removeTodo(todo: Todo) {
        console.log(todo, 'remove');
        this.todoService.removeTodo(todo).subscribe(res => {
            this.todos = this.todos.filter(el => el.getId() !== todo.getId());
        });
    }

    public save(todo: Todo) {
        console.log(todo, 'save');
        this.todoService.updateTodo(todo);
    }

    private getTodos() {
        this.todoService.getAllTodos().subscribe(res => {
            this.todos = res.map(el => new Todo(el));
        });
    }

    private toggleStatus(todo: Todo) {
        todo.toggleStatus();
        this.todoService.updateTodo(todo);
    }

}

