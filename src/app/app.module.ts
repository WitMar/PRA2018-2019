import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';

import { AppComponent } from './app.component';
import { TodoListComponent } from './todo-list/todo-list.component';
import { TodoItemComponent } from './todo-item/todo-item.component';
import { TodoService } from './service/todo.service';
import { AddTodoComponent } from './add-todo/add-todo.component';

const ROUTES: Routes = [
  { path: '', redirectTo: 'todo-list', pathMatch: 'full' },
  { path: 'todo-list', component: TodoListComponent },
  { path: 'add-todo', component: AddTodoComponent }
];

@NgModule({
  declarations: [AppComponent, TodoListComponent, TodoItemComponent, AddTodoComponent],
  imports: [BrowserModule, HttpClientModule, FormsModule, RouterModule.forRoot(ROUTES)],
  providers: [TodoService],
  bootstrap: [AppComponent]
})
export class AppModule {}
