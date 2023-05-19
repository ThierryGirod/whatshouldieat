import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TakeoutComponent } from './takeout.component';

describe('TakeoutComponent', () => {
  let component: TakeoutComponent;
  let fixture: ComponentFixture<TakeoutComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TakeoutComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TakeoutComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
