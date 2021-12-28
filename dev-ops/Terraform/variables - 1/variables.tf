variable "filename" {
   type = string
   default = "C:/WS/Learn/projects/dev-ops/Terraform/create_file_with_contents/test.txt"
}

variable "content" {
   default = "created from terraform"
}

variable "prefix" {
   default = "Mrs"
}

variable "separator" {
   default = "."
}

variable "length" {
   default = "1"
}

variable "users" {
  type    = list
  default = ["root", "user1", "user2"]
}

variable "plans" {
  type = map
  default = {
    "5USD"  = "1xCPU-1GB"
    "10USD" = "1xCPU-2GB"
    "20USD" = "2xCPU-4GB"
  }
}