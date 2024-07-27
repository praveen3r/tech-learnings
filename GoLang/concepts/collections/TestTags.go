package main

import (
	"fmt"
	"reflect"
)

type User struct {
	name string `valid maxsize:"20"`
	pwd  string `maxsize:"10"`
}

func main() {
	u := User{}
	t := reflect.TypeOf(u)
	field, _ := t.FieldByName("name")

	fmt.Println(field.Tag)
	//fmt.Println(field.Tag.Get("maxsize"))
}
