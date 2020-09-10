import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NouvelarticleComponent } from './nouvelarticle.component';

describe('NouvelarticleComponent', () => {
  let component: NouvelarticleComponent;
  let fixture: ComponentFixture<NouvelarticleComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NouvelarticleComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NouvelarticleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
