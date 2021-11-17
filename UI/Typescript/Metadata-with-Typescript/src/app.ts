import 'reflect-metadata';

class Point {
  x!: number;
  y!: number;
}

class Line {
  private _p0!: Point;
  private _p1!: Point;

  @validate
  set p0(value: Point) { this._p0 = value; }
  get p0() { return this._p0; }

  @validate
  set p1(value: Point) { this._p1 = value; }
  get p1() { return this._p1; }
}

function validate<T>(target: any, propertyKey: string, descriptor: TypedPropertyDescriptor<T>) {
  let type = Reflect.getMetadata("design:type", target, propertyKey);
  console.log(`type is ${type} and propertyKey is ${propertyKey} and descriptor is ${descriptor.value}`);
}

console.log(new Line());
