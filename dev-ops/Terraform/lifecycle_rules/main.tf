resource "local_file" "test" {
  filename = "C:/WS/Learn/projects/dev-ops/Terraform/create_file_with_contents/test.txt"
  content  = "created from terraform"
  file_permission = "0700"
  lifecycle {
#   prevent_destroy = true
    create_before_destroy = true
  }
}

