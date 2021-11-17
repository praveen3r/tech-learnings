
let products= [
    {name: 'ladies finger', type: 'vegetable', quantity : 0, price: 10},
    {name: 'orange', type: 'fruit', quantity : 10, price: 10},
    {name: 'potato', type: 'vegetable', quantity : 20, price: 20},
    {name: 'guava', type: 'fruit', quantity : 30, price: 30}
  ];
  
  let productModel = products.reduce(function(previous, product){
    return previous + product.name;
  }, '')
                          
  console.log(productModel);  
  
  function display(previous, product){
    return previous + product.name
  }
  
  let productModel1 = products.reduce(display, '');
  
  console.log(productModel1);
  
  let productModel2 = products.reduce((previous, product) => {
    return previous + product.name;
  }, '');
  
  console.log(productModel2);

  //single line only
  let productModel3 = products.reduce((previous, product) => previous + product.name,'');
  
  console.log(productModel3);