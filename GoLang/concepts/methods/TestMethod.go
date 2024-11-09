package main

import "fmt"

func main() {
	course := Course{id: 1, name: "GoLang", courseType: "Backend"}
	course.getCourse()
	course.setCourse()
	fmt.Println("course name is ", course.name)
}

type Course struct {
	id         int
	name       string
	courseType string
}

func (course Course) getCourse() {
	fmt.Println("course name is", course.name)

}

func (course Course) setCourse() {
	//func (course *Course) setCourse() { //pointer will change the object value
	course.name = "ReactJS"
	fmt.Println("course name is", course.name)

}
