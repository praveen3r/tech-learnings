//-------------------------Exporting a declaration------------------------------------------------------------

/*
Any declaration (such as a variable, function, class, type alias, or interface) can be exported 
by adding the export keyword.
*/

//StringValidator.ts
export interface StringValidator {
    isAcceptable(s: string): boolean;
}

import { StringValidator } from "./StringValidator";

export const numberRegexp = /^[0-9]+$/;

export class ZipCodeValidator implements StringValidator {
    isAcceptable(s: string) {
        return s.length === 5 && numberRegexp.test(s);
    }
}

//-------------------------Re-exports------------------------------------------------------------

/*
Often modules extend other modules, and partially expose some of their features. A re-export 
does not import it locally, or introduce a local variable.
*/

//ParseIntBasedZipCodeValidator.ts
export class ParseIntBasedZipCodeValidator {
    isAcceptable(s: string) {
        return s.length === 5 && parseInt(s).toString() === s;
    }
}

// Export original validator but rename it
export {ZipCodeValidator as RegExpBasedZipCodeValidator} from "./ZipCodeValidator";


//-------------------------All Exports----------------------------------------------------------

/*
Optionally, a module can wrap one or more modules and combine all their exports using 
export * from "module" 
*/

//AllValidators.ts
export * from "./StringValidator"; // exports 'StringValidator' interface
export * from "./ZipCodeValidator";  // exports 'ZipCodeValidator' and const 'numberRegexp' class
export * from "./ParseIntBasedZipCodeValidator"; 
/* exports the 'ParseIntBasedZipCodeValidator' class and re-exports 'RegExpBasedZipCodeValidator'
 as alias of the 'ZipCodeValidator' class from 'ZipCodeValidator.ts' module.
 */

 //-------------------------Import a single export from a module------------------------------------

 import { ZipCodeValidator } from "./ZipCodeValidator";

 let myValidator = new ZipCodeValidator();

 //-------------------------Renaming imports--------------------------------------------------------

 import { ZipCodeValidator as ZCV } from "./ZipCodeValidator";

let myValidator = new ZCV();

//-------------------------Importing all------------------------------------------------------------

import * as validator from "./ZipCodeValidator";

let myValidator = new validator.ZipCodeValidator();

//-------------------------Importing Types------------------------------------------------------------

/*
Prior to TypeScript 3.8, you can import a type using import. With TypeScript 3.8, you can import 
a type using the import statement, or using import type.
*/

// Re-using the same import
import {APIResponseType} from "./api";

// Explicitly use import type
import type {APIResponseType} from "./api";

//-------------------------Default exports----------------------------------------------------------

/*
Each module can optionally export a default export. Default exports are marked with the keyword 
default; and there can only be one default export per module. default exports are imported using 
a different import form.

default exports are really handy. For instance, a library like jQuery might have a default export 
of jQuery or $, which we’d probably also import under the name $ or jQuery.
*/

// JQuery.d.ts
declare let $: JQuery;
export default $;

//App.ts

import $ from "jquery";

$("button.continue").html( "Next Step..." );

/*
Classes and function declarations can be authored directly as default exports. Default export 
class and function declaration names are optional.
*/

//ZipCodeValidator.ts

export default class ZipCodeValidator {
    static numberRegexp = /^[0-9]+$/;
    isAcceptable(s: string) {
        return s.length === 5 && ZipCodeValidator.numberRegexp.test(s);
    }
}

//Test.ts

import validator from "./ZipCodeValidator";

let myValidator = new validator();


//-------------------------Default export function----------------------------------------------------

//StaticZipCodeValidator.ts
const numberRegexp = /^[0-9]+$/;

export default function (s: string) {
    return s.length === 5 && numberRegexp.test(s);
}

//Test.ts
import validate from "./StaticZipCodeValidator";

let strings = ["Hello", "98052", "101"];

// Use function validate
strings.forEach(s => {
  console.log(`"${s}" ${validate(s) ? "matches" : "does not match"}`);
});

//-------------------------Default export value----------------------------------------------------

//OneTwoThree.ts
export default "123";

//Log.ts 
import num from "./OneTwoThree";

console.log(num); // "123"

//-------------------------Export all as x----------------------------------------------------

/*
With TypeScript 3.8, you can use export * as ns as a shorthand for re-exporting another 
module with a name:
*/

export * as utilities from "./utilities";

/*
This takes all of the dependencies from a module and makes it an exported field, you 
could import it like this:
*/

import { utilities } from "./index";