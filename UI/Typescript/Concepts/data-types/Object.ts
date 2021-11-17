// const person: {
//   name: string;
//   age: number;
// } = {
    const person = {
        name: 'Maximilian',
        age: 30
      };
      
      console.log(person.name);

      //Nested Objects

      const product = {
        id: 'abc1',
        price: 12.99,
        tags: ['great-offer', 'hot-and-new'],
        details: {
          title: 'Red Carpet',
          description: 'A great carpet - almost brand-new!'
        }
      }

      console.log(product.id);