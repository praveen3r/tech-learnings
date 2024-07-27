package main

import "fmt"

func main() {

	sum := 0
	for i := 0; i <= 10; i++ {
		fmt.Println("value of i is ", i)
		sum = sum + i
	}
	fmt.Println("value of sum is ", sum)

	for i := 0; i <= 10; i++ {
		fmt.Println("value of i is ", i)
		if i == 5 {
			break
		}
	}

	//slices
	nums := []string{"one", "two", "three"}

	for idx, num := range nums {
		fmt.Println("value of index is ", idx, " and value is", num)
	}

	for idx := range nums {
		fmt.Println("value of index is ", idx)
	}

	for _, num := range nums {
		fmt.Println("value is", num)
	}

	//arrays

	nums1 := [...]string{"one", "two", "three"}

	for idx, num := range nums1 {
		fmt.Println("value of index is ", idx, " and value is", num)
	}

	for idx := range nums1 {
		fmt.Println("value of index is ", idx)
	}

	for _, num := range nums1 {
		fmt.Println("value is", num)
	}

	for range nums1 {
		fmt.Println("Praveen")
	}

	//pointer array

	nums2 := &[...]string{"one", "two", "three"}

	for idx, num := range *nums2 {
		fmt.Println("value of index is ", idx, " and value is", num)
	}

	for idx := range *nums2 {
		fmt.Println("value of index is ", idx)
	}

	for _, num := range *nums2 {
		fmt.Println("value is", num)
	}

	for range *nums2 {
		fmt.Println("Praveen2")
	}

	//maps

	countryPopulation := map[string]int{
		"India":   100,
		"Germany": 10,
		"USA":     25,
		"Aus":     40,
	}

	for key, value := range countryPopulation {
		fmt.Println("value of key is ", key, " and value is", value)
	}

	for key := range countryPopulation {
		fmt.Println("value of key is ", key)
	}

	for _, value := range countryPopulation {
		fmt.Println("value is", value)
	}

	for range countryPopulation {
		fmt.Println("Praveen2")
	}

	//short variable declaration and scoping

	nums3 := []string{"one", "two", "three"}

	var idx int
	for idx = range nums3 {
		fmt.Println("value of index is ", idx)
	}
	fmt.Println("value of final index is ", idx)

}
