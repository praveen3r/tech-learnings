export class Course {
  id?: number;
  name: string;
  author?: string;
  type?: string;
  typeId: number;

  constructor() {
    this.name = '';
    this.author = '';
    this.type = '';
    this.typeId = null;
  }
}
