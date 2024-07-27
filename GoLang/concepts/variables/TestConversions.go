package main

import (
	"fmt"
	"strconv"
)

func main() {

	//Integer to Float
	i1 := 42
	f1 := float64(i1)
	fmt.Println(f1) // Output: 42.0

	//Float to Integer
	f2 := 42.58
	i2 := int(f2)
	fmt.Println(i2) // Output: 42

	//String to Integer
	s1 := "123"
	i3, err := strconv.Atoi(s1)
	if err != nil {
		fmt.Println(err)
	}
	fmt.Println(i3) // Output: 123

	//Integer to String
	i4 := 123
	s4 := strconv.Itoa(i4)
	fmt.Println(s4) // Output: "123"

	//String to Float
	s5 := "42.58"
	f5, err5 := strconv.ParseFloat(s5, 64)
	if err5 != nil {
		fmt.Println(err5)
	}
	fmt.Println(f5) // Output: 42.58

	//String to Float
	f6 := 42.58
	s6 := strconv.FormatFloat(f6, 'f', -1, 64)
	fmt.Println(s6) // Output: "42.58"

	//Boolean to String
	b7 := true
	s7 := strconv.FormatBool(b7)
	fmt.Println(s7) // Output: "true"

	//String to Boolean
	s8 := "true"
	b8, err8 := strconv.ParseBool(s8)
	if err8 != nil {
		fmt.Println(err8)
	}
	fmt.Println(b8) // Output: true

}
