import { Component, OnInit } from '@angular/core';


import{TaskFormComponent} from '../task-form/task-form.component'
import{TaskModelService} from '../task-model/task-model.service'
import { Task } from '../task-model/task-model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-my-task-tracker',
  templateUrl: './my-task-tracker.component.html',
  styleUrls: ['./my-task-tracker.component.css']
})
export class MyTaskTrackerComponent implements OnInit {

  taskList:Task[];
  task:Task;
  constructor(private taskService: TaskModelService,
    private router: Router ) { }

  ngOnInit() {
    
    
    this.taskList = this.taskService.getAllTasks();
    // let playStore = []; 
    // this.taskList.forEach(function(item){  
    //   playStore.push(item)  
    // });  
    // for (var i = 5; i < localStorage.length+1; i++){
    //   console.log(i, localStorage.getItem(String(i)));
    //   this.task = this.taskService.stringToTask(localStorage.getItem(String(i)));
    //   this.taskList.push(this.task);
    // }

  }

}
