package main

import (
	"bytes"
	"encoding/json"
	"fmt"
	"io"
	"net/http"
)

func main() {

	const url = "https://jsonplaceholder.typicode.com/posts"

	// Define the data to send as JSON
	data := map[string]string{
		"title":  "foo",
		"body":   "bar",
		"userId": "1",
	}

	// Convert the data to JSON
	jsonData, err := json.Marshal(data)
	if err != nil {
		fmt.Println("Error marshaling JSON:", err)
		return
	}

	// Create the POST request
	response, err := http.Post(url, "application/json", bytes.NewBuffer(jsonData))

	if err != nil {
		panic(err)
	}

	// Check the response status
	fmt.Println("Status Code:", response.StatusCode)
	fmt.Println("Headers:", response.Header)

	fmt.Printf("Response is of type: %T\n", response)

	defer response.Body.Close() // caller's responsibility to close the connection

	databytes, err := io.ReadAll(response.Body)

	if err != nil {
		panic(err)
	}

	content := string(databytes)
	fmt.Println(content)
}
