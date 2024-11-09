package main

import (
	"bufio"
	"fmt"
	"os"
)

func main() {
	welcome := "Welcome User"

	fmt.Println(welcome)

	reader := bufio.NewReader(os.Stdin)

	fmt.Println("Enter something")

	input, _ := reader.ReadString('\n')

	fmt.Println("You input is ", input)
}
