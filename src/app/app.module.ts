import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TaskFormComponent } from './task-form/task-form.component';
import { NavbarComponent } from './navbar/navbar.component';
import { MyTaskTrackerComponent } from './my-task-tracker/my-task-tracker.component';
import { TaskModelComponent } from './task-model/task-model.component';
import { EditTaskComponent } from './edit-task/edit-task.component';
// import { TaskModel } from './task-model';

const appRoutes: Routes = [
  { path: 'new-task', component: TaskFormComponent },
  { path: 'app-component', component: AppComponent },
  { path: 'my-task-tracker', component: MyTaskTrackerComponent },
  {path: 'edit-task/:date', component: EditTaskComponent },
  { path: '', redirectTo: '/my-task-tracker', pathMatch: 'full' }
  
];

@NgModule({
  
  declarations: [
    AppComponent,
    TaskFormComponent,
    NavbarComponent,
    MyTaskTrackerComponent,
    TaskModelComponent,
    EditTaskComponent,
    // TaskModel
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    RouterModule.forRoot(
      appRoutes,
      { enableTracing: true } // <-- debugging purposes only
    )
  ],

  exports: [
    RouterModule
  ],

  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
