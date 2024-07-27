package main

import "fmt"

func main() {

	// countryPopulation := map[string]int{
	// 	"India":   100,
	// 	"Germany": 10,
	// 	"USA":     25,
	// 	"Aus":     40,
	// }

	countryPopulation := make(map[string]int)

	countryPopulation = map[string]int{
		"India":   100,
		"Germany": 10,
		"USA":     25,
		"Aus":     40,
	}

	fmt.Println("the value of countryPopulation is ", countryPopulation)
	//fetch a value
	fmt.Println("the value of countryPopulation is ", countryPopulation["Germany"])

	//add a value
	countryPopulation["Russia"] = 50

	fmt.Println("the value of countryPopulation is ", countryPopulation)

	//delete a value
	delete(countryPopulation, "Russia")

	fmt.Println("the value of countryPopulation is ", countryPopulation)

	//modify a value
	countryPopulation["India"] = 120

	fmt.Println("the value of countryPopulation is ", countryPopulation)

	//invalid key

	fmt.Println("the value of countryPopulation is ", countryPopulation["FTE"])

	//check for invalid key
	keyValue, isPresent := countryPopulation["FTE"]

	fmt.Println(keyValue, isPresent)

	fmt.Println("the len of countryPopulation is ", len(countryPopulation))

}
