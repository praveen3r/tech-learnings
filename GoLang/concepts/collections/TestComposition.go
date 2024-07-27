package main

import "fmt"

type Vehicle struct {
	name        string
	vehicleType string
}

type Car struct {
	Vehicle
	speed   int16
	carType string
}

func main() {

	aCar := Car{}
	aCar.name = "Skoda"
	aCar.vehicleType = "Car"
	aCar.speed = 100
	aCar.carType = "Diesel"

	fmt.Println("the value of aCar is ", aCar)
}
