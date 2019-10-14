import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';


import { generateGuid } from './generateGuid';

import { Task } from './task-model';

@Injectable({
    providedIn: 'root'
})
export class TaskModelService {
    [x: string]: any;

    taskList: Task[] = [];
    obj: JSON;
    task1: Task;
    taskTemp: Task;
    
    //URL for CRUD operations
    taskUrl = "http://localhost:8080/tasks";
    //Create constructor to get Http instance
    constructor(private http: HttpClient) { }
    //Fetch all articles
    getAllTasks() {
        this.taskList = [];
        for (let key in localStorage) {
            if (localStorage.getItem(String(key)) != null) {
                console.log(key, localStorage.getItem(String(key)));
                this.taskTemp = this.stringToTask(localStorage.getItem(String(key)));
                this.taskList.push(this.taskTemp);
            }
        }
        localStorage.key
        return this.taskList;
    }

    stringToTask(str: string) {
        var tempStr = str.split(",");
        // console.log(tempStr[0], tempStr[4]);

        if (tempStr[5] == "null") {
            this.task1 = new Task(String(tempStr[0]), String(tempStr[1]),
                String(tempStr[2]), String(tempStr[3]), tempStr[4], null);
        }
        else {
            this.task1 = new Task(String(tempStr[0]), String(tempStr[1]),
                String(tempStr[2]), String(tempStr[3]), tempStr[4], tempStr[5]);
            // this.task1.completionDate = new Date(tempStr[5]);
        }
        // console.log(this.task1.taskName);
        return this.task1;
    }

    taskToString(task: Task) {
        var tTs = task.taskName + ','
            + task.taskDescription + ',' + task.taskPriority
            + ',' + task.status + ',' + task.creationDate
            + ',' + task.completionDate;

        return tTs;
    }

    //Create article
    createTask(task: Task) {
        var gen = generateGuid.newGuid();
        var json = this.taskToString(task);
        localStorage.setItem(String(gen), json);
        console.log(gen);
        // localStorage.clear();
        // console.log("LS  ::", localStorage.getItem(String(localStorage.length)));
    }

    //Update task
    updateTask(task: Task) {
        for (let key in localStorage) {
            if (localStorage.getItem(String(key)) != null) {
                if (localStorage.getItem(String(key)).split(",")[4] == String(task.creationDate)) {
                    console.log(task.status);
                    localStorage.setItem(String(key), this.taskToString(task));
                }
            }
        }
    }
    //Delete task	
    deleteTask(task: Task) {
        for (let key in localStorage) {
            if (localStorage.getItem(String(key)) != null) {
                if (localStorage.getItem(String(key)).split(",")[4] == String(task.creationDate)) {
                    localStorage.removeItem(String(key));
                }
            }
        }
    }
    private handleError(error: any) {
        console.error(error);
        return throwError(error);
    }
}