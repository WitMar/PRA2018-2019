import { Component, OnInit } from '@angular/core';
import { TodoService } from '../service/todo.service';
import { Todo } from '../models/todo';

@Component({
  selector: 'app-todo-list',
  templateUrl: './todo-list.component.html',
  styleUrls: ['./todo-list.component.css']
})
export class TodoListComponent implements OnInit {
  todos: Todo[];

  constructor(private todoService: TodoService) {}

  ngOnInit() {
    this.getTodos();
  }

  public removeTodo(todo: Todo) {
    console.log(todo, 'remove');
    this.todoService.removeTodo(todo).subscribe(res => {
      this.todos = this.todos.filter(el => el.getId() !== todo.getId());
    });
  }
  private getTodos() {
    this.todoService.getAllTodos().subscribe(res => {
      this.todos = res.map(el => new Todo(el));
    });
  }
}
