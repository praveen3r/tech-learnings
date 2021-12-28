resource "local_file" "test" {
   filename = each.value
   for_each = toset(var.filename)
}