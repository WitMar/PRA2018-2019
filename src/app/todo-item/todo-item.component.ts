import { Component, OnInit, Input, EventEmitter, Output } from '@angular/core';
import { Todo } from '../models/todo';
import { TodoService } from '../service/todo.service';

@Component({
  selector: 'app-todo-item',
  templateUrl: './todo-item.component.html',
  styleUrls: ['./todo-item.component.css']
})
export class TodoItemComponent implements OnInit {
  @Input() todo: Todo;
  @Output() removeItem: EventEmitter<Todo> = new EventEmitter();
  constructor(private todoService: TodoService) {}

  ngOnInit() {}

  remove() {
    this.removeItem.emit(this.todo);
  }

  toggleStatus() {
    this.todo.toggleStatus();
    this.todoService.updateTodo(this.todo).subscribe();
  }
}
