import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MyTaskTrackerComponent } from './my-task-tracker.component';

describe('MyTaskTrackerComponent', () => {
  let component: MyTaskTrackerComponent;
  let fixture: ComponentFixture<MyTaskTrackerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MyTaskTrackerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MyTaskTrackerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
