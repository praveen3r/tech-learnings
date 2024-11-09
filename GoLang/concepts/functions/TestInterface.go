package main

import "fmt"

type Vehicle INTERFACE {
	display() string
}

type Car struct{}

type Bike struct{}

func (c Car) display() string {
	return "Car!"
}

func (b Bike) display() string {
	return "Bike!"
}

func main() {

	var vehicle Vehicle

	vehicle = Car{}
	fmt.Println(vehicle.display())

	vehicle = Bike{}
	fmt.Println(vehicle.display())
}
