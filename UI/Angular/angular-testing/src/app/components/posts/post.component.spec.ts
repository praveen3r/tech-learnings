import { ComponentFixture, TestBed } from "@angular/core/testing";
import { PostComponent } from "./post.component";
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { By } from "@angular/platform-browser";
import { Post } from "src/app/models/post";


describe('MyTableComponent', () => {
  let component: PostComponent;
  let fixture: ComponentFixture<PostComponent>;
  let httpMock: HttpTestingController;

  const mockData : Post[]= [
    { id: 1, title: 'Test Title 1', body: 'Test body 1' },
    { id: 2, title: 'Test Title 2', body: 'Test body 1' },
    { id: 3, title: 'Test Title 3', body: 'Test body 2' }
  ];

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PostComponent ],
      imports: [ HttpClientTestingModule ] // Import HttpClientTestingModule
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PostComponent);
    component = fixture.componentInstance;
    httpMock = TestBed.inject(HttpTestingController);
    fixture.detectChanges();
  });

  // it('should create the component', () => {
  //   expect(component).toBeTruthy();
  // });

  it('should render table rows', () => {
    //fixture.detectChanges();

    const req = httpMock.expectOne(`https://jsonplaceholder.typicode.com/posts`);
    expect(req.request.method).toBe('GET');
    req.flush(mockData);

    // Trigger change detection
    fixture.detectChanges();

    expect(component.posts).toEqual(mockData);

    const rows = fixture.debugElement.queryAll(By.css('tbody tr'));
    expect(rows.length).toBe(3); // Assuming your tableData has 3 rows
    expect(rows[0].nativeElement.textContent).toContain('Test Title 1');
  });

  afterEach(() => {
    httpMock.verify();
  });

});
