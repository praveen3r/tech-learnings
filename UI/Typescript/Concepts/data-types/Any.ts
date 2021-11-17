/*
We may need to describe the type of variables that we do not know when we are writing an application. 
These values may come from dynamic content, e.g. from the user or a 3rd party library. In these cases,
we want to opt-out of type checking and let the values pass through compile-time checks. To do so, 
we label these with the any type:
*/

let notSure: any = 4;
notSure = "maybe a string instead";
notSure = false; // okay, definitely a boolean

/*
The any type is a powerful way to work with existing JavaScript, allowing you to gradually opt-in 
and opt-out of type checking during compilation. You might expect Object to play a similar role, 
as it does in other languages. However, variables of type Object only allow you to assign any value 
to them. You can’t call arbitrary methods on them, even ones that actually exist:
*/

let notSure1: any = 4;
notSure1.ifItExists(); // okay, ifItExists might exist at runtime
notSure1.toFixed(); // okay, toFixed exists (but the compiler doesn't check)

let prettySure: Object = 4;
//prettySure.toFixed(); // Error: Property 'toFixed' doesn't exist on type 'Object'.

//Note: Avoid using Object in favor of the non-primitive object type 

/* 
The any type is also handy if you know some part of the type, but perhaps not all of it. For example, 
you may have an array but the array has a mix of different types:
*/

let list: any[] = [1, true, "free"];

list[1] = 100;