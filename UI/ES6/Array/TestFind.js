
let products= [
    {name: 'ladies finger', type: 'vegetable', quantity : 0, price: 10},
    {name: 'orange', type: 'fruit', quantity : 10, price: 10},
    {name: 'potato', type: 'vegetable', quantity : 20, price: 20},
    {name: 'guava', type: 'fruit', quantity : 30, price: 30}
  ];
  
  let productModel = products.find(function(product){
    return product.type === 'vegetable';
  })
                          
  console.log(productModel);  
  
  function display(product){
    return product.type === 'vegetable'
  }
  
  let productModel1 = products.find(display);
  
  console.log(productModel1);
  
  let productModel2 = products.find(product => {
    return product.type === 'vegetable';
  });
  
  console.log(productModel2);

  //single line only
  let productModel3 = products.find(product => product.type === 'vegetable');
  
  console.log(productModel3);