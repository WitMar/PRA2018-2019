import { Injectable } from '@angular/core';
import { Todo } from '../models/todo';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

const apiUrl: String = 'http://localhost:3000';

@Injectable()
export class TodoService {
  constructor(private http: HttpClient) {}

  getAllTodos(): Observable<any> {
    return this.http.get(`${apiUrl}/todos`);
  }

  createNewTodo(name: String) {
    const data = {
      name: name
    };
    const todo = new Todo(data);
    return this.http.post(`${apiUrl}/todos`, todo).subscribe(res => {
      console.log(res);
    });
  }
  removeTodo(todo: Todo) {
    return this.http.delete(`${apiUrl}/todos/${todo.getId()}`);
  }

  updateTodo(todo: Todo) {
    return this.http.put(`${apiUrl}/todos/${todo.getId()}`, todo);
  }
}
