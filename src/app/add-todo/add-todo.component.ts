import { Component, OnInit } from '@angular/core';
import { TodoService } from '../service/todo.service';

@Component({
  selector: 'app-add-todo',
  templateUrl: './add-todo.component.html',
  styleUrls: ['./add-todo.component.css']
})
export class AddTodoComponent implements OnInit {
  newTodoName: String;

  constructor(private todoService: TodoService) {}

  ngOnInit() {
    this.newTodoName = '';
  }

  createNewTodo() {
    if (this.newTodoName !== '') {
      this.todoService.createNewTodo(this.newTodoName);
      this.newTodoName = '';
    } else {
      window.alert('brak nazwy zadania');
    }
  }
}
