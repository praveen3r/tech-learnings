package main

import (
	"fmt"
	"net/url"
)

func main() {
	rawURL := "https://jsonplaceholder.typicode.com/comments?postId=1"

	result, err := url.Parse(rawURL)
	if err != nil {
		fmt.Println("Error parsing URL:", err)
		panic(err)
	}

	// fmt.Println(result.Scheme)
	// fmt.Println(result.Host)
	// fmt.Println(result.Path)
	// fmt.Println(result.Port())

	qparams := result.Query()

	if qparams.Has("postId") {
		fmt.Println("value of postId is ", qparams["postId"])
	}

	for _, val := range qparams {
		fmt.Println("Param is: ", val)
	}

}
