
let cars= [
    {model: 'Nano', price: 'Cheap'},
    {model: 'BMW', price: 'Expensive'}
  ];
  
  let carModel = cars.map(function(car){
    return car.model;
  })
                          
  console.log(carModel);  
  
  function display(car){
    return car.model
  }
  
  let carModel1 = cars.map(display);
  
  console.log(carModel1);
  
  let carModel2 = cars.map(car => {
    return car.model;
  });
  
  console.log(carModel2);

  //single line only
  let carModel3 = cars.map(car => car.model);
  
  console.log(carModel3);