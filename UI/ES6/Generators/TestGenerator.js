function* shopping(){
    console.log(" walking in footpath");
    console.log(" about to enter the store ");
    const stuffFromStore = yield 'cash';

    console.log(`walking back to laundry with ${stuffFromStore}`);

    const cleanClothes = yield 'laundry';

    console.log(`walking back to home with ${cleanClothes}`);

    return stuffFromStore;
}

const gen = shopping();
console.log(" left the home");
gen.next();
console.log("reached groceries");
console.log("Started shopping");
console.log("Returning from groceries");
gen.next('groceries');
gen.next('clean Clothes');