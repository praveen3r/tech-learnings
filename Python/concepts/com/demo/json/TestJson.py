import json

a = {
    "name": "Praveen",
    "age":  23,
    "courses": ["Angular", "React"]
}

print(json.dumps(a, indent=3))