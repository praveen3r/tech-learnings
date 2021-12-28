terraform {
   required_providers {
      local = {
         source = "hashicorp/local"
         # version = "1.4.0"
         # version = "!= 2.0.0"
         # version = "< 1.4.0"
         # version = "> 1.4.0"
         # version = "> 1.2.0, < 2.0.0"
         version = "~> 1.2.0"
      }
   }
}

resource "local_file" "test" {
   filename = "C:/WS/Learn/projects/dev-ops/Terraform/create_file_with_contents/test.txt"
   content = "created from terraform"
}