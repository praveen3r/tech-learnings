const hobbies = ['Sports', 'Cooking']


let favoriteActivities: string[];
favoriteActivities = ['Sports'];

let favoriteActivities1: any[];
favoriteActivities1 = ['Sports', 11];

for (const hobby of hobbies) {
    console.log(hobby.toUpperCase());
    // console.log(hobby.map()); // !!! ERROR !!!
}
