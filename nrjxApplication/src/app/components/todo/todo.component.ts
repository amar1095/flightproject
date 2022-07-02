import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { select, Store } from '@ngrx/store';
import { Todo } from 'src/app/models/todo';
import { TodoRemove } from 'src/app/action/todo.action';

@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.css'],
})
export class TodoComponent implements OnInit {
  [x: string]: any;
  todos: Todo[];

  constructor(private store: Store<{ todos: Todo[] }>) {
    store.pipe(select('todos')).subscribe((values) => {
      this.todos = values;
      console.log(values);
    });
  }

  removeTodo(index:number){
    this.store.dispatch(new TodoRemove(index));
  }

  ngOnInit(): void {}
}
