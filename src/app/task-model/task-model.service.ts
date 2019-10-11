import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { map, catchError, tap } from 'rxjs/operators';

import { Task } from './task-model';

@Injectable({
    providedIn: 'root'
})
export class TaskModelService {

taskList:Task[] =[];

    //URL for CRUD operations
    taskUrl = "http://localhost:8080/tasks";
    //Create constructor to get Http instance
    constructor(private http: HttpClient) { }
    //Fetch all articles
    getAllTasks() {
        return this.taskList;
    }
    //Create article
    createTask(task: Task) {
        let httpHeaders = new HttpHeaders({
            'Content-Type': 'application/json'
        });
        this.taskList.push(task);
    }

    //Fetch article by id
    getTaskByName(taskName: string): Observable<Task> {
        return this.http.get<Task>(this.taskUrl ).pipe(
            tap(task => console.log(task.taskDescription + " " + task.creationDate)),
            catchError(this.handleError)
        );
    }
    //Update article
    updateTask(task: Task){
        this.taskList.forEach(function (tempTask) {  
            if(tempTask.creationDate == task.creationDate){
                tempTask.taskName=task.taskName;
                tempTask.taskDescription = task.taskDescription;
                tempTask.status = task.status;
                tempTask.taskPriority = task.taskPriority;
            }
            
          });
    }
    //Delete article	
    deleteTaskByName(taskName: string): Observable<string> {
        return this.http.delete<string>(this.taskUrl + "/" + taskName).pipe(
            tap(status => console.log("status: " + status)),
            catchError(this.handleError)
        );
    }
    private handleError(error: any) {
        console.error(error);
        return throwError(error);
    }
}