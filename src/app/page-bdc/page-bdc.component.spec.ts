import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PageBDCComponent } from './page-bdc.component';

describe('PageBDCComponent', () => {
  let component: PageBDCComponent;
  let fixture: ComponentFixture<PageBDCComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PageBDCComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PageBDCComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
