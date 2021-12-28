module "test1" {
   source = ".//module1"
   filename = "C:/WS/Learn/projects/dev-ops/Terraform/create_file_with_contents/test1.txt"
   content = "created from terraform"
}