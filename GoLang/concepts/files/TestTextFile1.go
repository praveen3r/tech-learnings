package main

import (
	"fmt"
	"io"
	"os"
)

// This is the simplest way to read an entire file into memory.
func main() {
	fmt.Println("Welcome to files in golang")
	content := "Hello world file"

	file, err := os.Create("./test.txt")

	checkNilErr(err)

	length, err := io.WriteString(file, content)
	checkNilErr(err)
	fmt.Println("length is: ", length)
	defer file.Close()
	readFile("./test.txt")
}

func readFile(filname string) {
	databyte, err := os.ReadFile(filname)
	checkNilErr(err)

	fmt.Println("Text data inside the file is \n", string(databyte))

}

func checkNilErr(err error) {
	if err != nil {
		panic(err)
	}
}
