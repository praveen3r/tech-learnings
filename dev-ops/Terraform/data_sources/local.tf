resource "local_file" "test" {
   filename = "C:/WS/Learn/projects/dev-ops/Terraform/create_file_with_contents/test.txt"
   content = data.local_file.test1.content
}

data "local_file" "test1" {
   filename = "C:/WS/Learn/projects/dev-ops/Terraform/create_file_with_contents/test1.txt"
}