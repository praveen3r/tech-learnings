resource "local_file" "test" {
   filename = "C:/WS/Learn/projects/dev-ops/Terraform/create_file_with_contents/test.txt"
   content = "created from terraform"
}

resource "random_pet" "random" {
   prefix = "Mrs"
   separator = "."
   length = 1
}