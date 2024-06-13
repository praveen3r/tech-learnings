import { HttpClientModule } from '@angular/common/http';
import { PostComponent } from './post.component';
import { ComponentFixture, TestBed } from '@angular/core/testing';

describe('Post Component', () => {
  let fixture: ComponentFixture<PostComponent>;
  let comp: PostComponent;
  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PostComponent],
      imports: [ HttpClientModule ]
    });

    fixture = TestBed.createComponent(PostComponent);
    comp = fixture.componentInstance;
  });

  it('should create post component using TestBed', () => {
    expect(comp).toBeDefined();
  });
});
