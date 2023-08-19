// How many data types does JavaScript have?
// Primitives
var num;
var str = 'Brian';
var bool;

// Objects
// Arrays
var numArr = [1, 2, 3];
var strArr = ['Brian', 'Nicole']
var boolArr = [true, false, true]


// Review of string interpolation
var firstName = 'Brian'
var lastName = 'Hudson'

// Old School
var fullName = firstName + ' ' + lastName;

// New School (interpolation)
var newStr = `firstName: ${firstName}, lastName: ${lastName}`;

// console.log(newStr);

// Using backticks for line breaks/formatted logs
console.log(`
  type a line
  and then a new line
`)
console.log('\n\ttype a line\n\tand then a new line')

// Back to arrays
console.log(`numArr: ${numArr}`);
console.log(`strArr: ${strArr}`);
console.log(`boolArr: ${boolArr}`);

// Objects
var obj = {};

// Example: user
var user = {
  id: 1,
  firstName: 'Nicole',
  lastName: 'Nguyen',
  score: 0
}
var user2 = {
  id: 2,
  firstName: 'Brian',
  lastName: 'Hudson',
  score: 0
}

// Use objects to create an array of users
var users = [user, user2]
var users2 = [{}, {}]

// console.log(`
//   Arrays of users: ${users}
//   Arrays of users2: ${users2}
// `);

// console.log( `What's inside the object? ${user}`)


// Types of loops
// For loop
for (var i = 0; i < 10; i++) {
  
}
// For-in Loop: Loop through an object
for (var property in user) {
  // console.log(`${property}: ${user[property]}`);
}

// For loop again -- for arrays
for (var index = 0; index < users.length; index++) {
  // console.log(`User at ${index}: ${users[index].firstName}`)
}

// For-of loop -- simpler way to loop through arrays
for (var user of users) {
  // console.log(`User: ${user.firstName}`)
}

// Practice: 
// Create an object for a dog
// Array -- efficient, but difficult to use
var goldenRetriever = [
  7,
  'Ponyo',
  'Golden Retriever'
];

var goldenRetrieverAsObject = {
  age: 7,
  name: 'Ponyo',
  breed: 'Golden Retriever'
}

var variableProperty = 'favoriteFood'
console.log(`Name: ${goldenRetriever[1]}`)
console.log(`Name: ${goldenRetrieverAsObject.name}`)
console.log(`Name: ${goldenRetrieverAsObject[variableProperty]}`)

/** 
 * Create a function to accept an array of nums,
 * filter out duplicate values, and return the unique values
 * @param {Array} nums
 * @returns {Array} An array with only unique values
*/
const filterDuplicates = (nums) => {
  return nums;
}

const input1 = [1, 1, 1, 3, 4, 3, 5]
// console.log(`Filter Duplicates:
//   Input: ${input1}
//   Output: ${filterDuplicates(input1)}
// `);

/** 
 * Create a function to accept a string and remove
 * any white space
 * @param {string} text
 * @returns {string} A reversed string with any white space removed
*/
const reverseString = (text) => {
  return text;
}

const input2 = ' Hi, Nicole! It\'s so nice to work with you!'
// console.log(`Reverse String:
//   Input: ${input2}
//   Output: ${reverseString(input2)}
// `);
