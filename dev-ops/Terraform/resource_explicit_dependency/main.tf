resource "local_file" "test" {
   filename = "C:/WS/Learn/projects/dev-ops/Terraform/create_file_with_contents/test.txt"
   content = random_pet.random.id
   
   depends_on = [random_pet.random]
}

resource "random_pet" "random" {
   prefix = "Mrs"
   separator = "."
   length = 1
}