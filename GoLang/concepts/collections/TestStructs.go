package main

import "fmt"

type Celebrity struct {
	age    int
	name   string
	movies []string
}

func main() {

	// aCelebrity := Celebrity{
	// 	age:    55,
	// 	name:   "Test",
	// 	movies: []string{"Test1", "Test2"},
	// }

	//do not use
	aCelebrity := Celebrity{
		55,
		"Test",
		[]string{"Test1", "Test2"},
	}

	fmt.Println("the value of aCelebrity is ", aCelebrity)
	fmt.Println("the value of aCelebrity is ", aCelebrity.age)
	fmt.Println("the value of aCelebrity is ", aCelebrity.movies)

	//anonymous struct
	bCelebrity := struct{ age int }{age: 55}

	fmt.Println("the value of bCelebrity is ", bCelebrity)
	fmt.Println("the value of bCelebrity is ", bCelebrity.age)

	bCelebrity.age = 95

	fmt.Println("the value of bCelebrity is ", bCelebrity.age)
}
