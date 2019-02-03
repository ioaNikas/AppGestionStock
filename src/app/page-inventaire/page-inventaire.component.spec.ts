import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PageInventaireComponent } from './page-inventaire.component';

describe('PageInventaireComponent', () => {
  let component: PageInventaireComponent;
  let fixture: ComponentFixture<PageInventaireComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PageInventaireComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PageInventaireComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
