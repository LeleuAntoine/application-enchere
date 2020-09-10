import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AppliFrontComponent } from './appli-front.component';

describe('AppliFrontComponent', () => {
  let component: AppliFrontComponent;
  let fixture: ComponentFixture<AppliFrontComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AppliFrontComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AppliFrontComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
