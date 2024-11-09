package main

import (
	"fmt"
	"time"
)

func main() {

	presentTime := time.Now()

	fmt.Println(" time now is ", presentTime)

	fmt.Println(" time now is ", presentTime.Format("01-02-2006 "))
	fmt.Println(" time now is ", presentTime.Format("01-02-2006 15:04:05 Monday"))
	fmt.Println(" time now is ", presentTime.Format("01-02-2006 15:04:05"))
	fmt.Println(" time now is ", presentTime.Format("01-02-2006 Monday"))

	pastDate := time.Date(2020, time.August, 12, 14, 15, 16, 0, time.UTC)
	fmt.Println(" time now is ", pastDate)

	fmt.Println(" time now is ", pastDate.Format("01-02-2006 "))
}
