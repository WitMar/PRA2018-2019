import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {HttpClientModule} from '@angular/common/http';
import {RouterModule, Routes} from '@angular/router';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';

import {AppComponent} from './app.component';
import {TodoListComponent} from './todo-list/todo-list.component';
import {TodoService} from './service/todo.service';
import {AddTodoComponent} from './add-todo/add-todo.component';
import {FilterPipe} from './models/filterPipe';


const ROUTES: Routes = [
    {path: '', redirectTo: 'todo-list', pathMatch: 'full'},
    {path: 'todo-list', component: TodoListComponent},
    {path: 'add-todo', component: AddTodoComponent}
];

@NgModule({
    declarations: [FilterPipe, AppComponent, TodoListComponent, AddTodoComponent],
    imports: [BrowserModule, HttpClientModule, FormsModule, RouterModule.forRoot(ROUTES), ReactiveFormsModule],
    providers: [TodoService],
    bootstrap: [AppComponent],
    exports: [FilterPipe],
})
export class AppModule {
}
