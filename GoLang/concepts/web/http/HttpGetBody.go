package main

import (
	"fmt"
	"io"
	"net/http"
	"strings"
)

const url = "https://jsonplaceholder.typicode.com/posts"

func main() {
	fmt.Println("web request")

	response, err := http.Get(url)

	if err != nil {
		panic(err)
	}

	// Check the response status
	fmt.Println("Status Code:", response.StatusCode)
	fmt.Println("Headers:", response.Header)

	fmt.Printf("Response is of type: %T\n", response)

	defer response.Body.Close() // caller's responsibility to close the connection

	//databytes, err := io.ReadAll(response.Body)

	if err != nil {
		panic(err)
	}
	var responseString strings.Builder
	content, _ := io.ReadAll(response.Body)
	byteCount, _ := responseString.Write(content)

	fmt.Println("ByteCount is: ", byteCount)
	//content := string(databytes)
	//fmt.Println(content)
	fmt.Println(responseString.String())

}
