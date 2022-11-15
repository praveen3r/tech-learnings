export class Course {
  id?: number;
  name: string;
  author?: string;
  type: string;

  constructor() {
    this.name = '';
    this.author = '';
    this.type = '';
  }
}
