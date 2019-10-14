import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Task } from '../task-model/task-model';
import { TaskModelService } from '../task-model/task-model.service';
import { Router, ActivatedRoute  } from '@angular/router';
import { TaskFormComponent } from '../task-form/task-form.component';

@Component({
  selector: 'app-edit-task',
  templateUrl: './edit-task.component.html',
  styleUrls: ['./edit-task.component.css']
})
export class EditTaskComponent implements OnInit {

  taskEditForm: FormGroup;
  submitted = false;
  taskModel:Task;
  toEditTask:Task;
  cD:number =null;

  constructor(private fb: FormBuilder, private taskService: TaskModelService,
    private router: Router, private activatedRoute :ActivatedRoute ) {

  }
 

  ngOnInit() {

    console.log(this.activatedRoute.snapshot.paramMap.get("date"));

    this.taskService.taskList.forEach((t: Task) => {
      if (t.creationDate.toString() == (this.activatedRoute.snapshot.paramMap.get("date"))) {
        // console.log("inside:",this.activatedRoute.snapshot.paramMap.get("date"));
        this.toEditTask = t;
      }
    });
// console.log("name:", this.toEditTask.taskName);

    this.taskEditForm = this.fb.group({
      taskName: ['', Validators.required],
      taskDescription: ['', Validators.required],
      priority: [''],
      status: ['']
    });
  }
  get fval() {
    return this.taskEditForm.controls;
  }

  save() {
    this.taskService.updateTask(this.taskModel);
  }
  signup() {
    this.submitted = true;
    if (this.taskEditForm.invalid) {
      return;
    }

    if(this.taskEditForm.value.status=="Completed"){
      this.cD = Date.now();
    }
    // console.log("name:", this.toEditTask.creationDate);
    
    this.taskModel=new Task(this.taskEditForm.value.taskName, 
      this.taskEditForm.value.taskDescription,
      this.taskEditForm.value.priority,
      this.taskEditForm.value.status, 
      this.toEditTask.creationDate, 
      this.cD);
      console.log(new Date(this.cD));

      this.save();  
      this.router.navigate(['/my-task-tracker'])  

  }

  deleteTask(){
    this.taskService.deleteTask(this.toEditTask);
    this.router.navigate(['/my-task-tracker']) 
  }

}
