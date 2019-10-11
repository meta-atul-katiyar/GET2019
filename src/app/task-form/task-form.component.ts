import { Component, Injectable, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

import { Task } from '../task-model/task-Model';
import { TaskModelService } from '../task-model/task-model.service';
import { Router } from '@angular/router';

// import custom validator to validate that password and confirm password fields match
// import { MustMatch } from './_helpers/must-match.validator';


@Component({
  selector: 'app-task-form',
  templateUrl: './task-form.component.html',
  styleUrls: ['./task-form.component.css']
})


export class TaskFormComponent implements OnInit {
  taskForm: FormGroup;
  submitted = false;
  taskModel:Task;

  constructor(private fb: FormBuilder, private taskService: TaskModelService,
    private router: Router) {

  }
 

  ngOnInit() {
    this.taskForm = this.fb.group({
      taskName: ['', Validators.required],
      taskDescription: ['', Validators.required],
      priority: ['']
    });
  }
  get fval() {
    return this.taskForm.controls;
  }

  getNewTask(){
    if(this.taskModel.taskName != null){
      return this.taskModel;
    }
  }

  save() {
    this.taskService.createTask(this.taskModel);
    // this.taskModel = new Employee();
    // this.gotoList();
  }

  gotoList() {
    this.router.navigate(['/tasks']);
  }

  signup() {
    this.submitted = true;
    if (this.taskForm.invalid) {
      return;
    }
    
    this.taskModel=new Task(this.taskForm.value.taskName, 
      this.taskForm.value.taskDescription,
      this.taskForm.value.priority,
      "New", Date.now(), null);
      // console.log("aaa");
      // console.log("time",this.taskModel.creationDate);
      this.save();   

    // alert('form fields are validated successfully!');
  }
}