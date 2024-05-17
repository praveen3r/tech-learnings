export const userType = `
type UserType {
  id: ID!,
  sNo: Int,
  name: String,
  age: Int,
  gender: String
} 

input UserInput {
  name: String,
  age: Int,
  gender: String
}

scalar Void

type Mutation {
  addUser(user: UserInput!): UserType!
  editUser(id:ID!, user: UserInput!): Void
  deleteUser(id:ID!): Void
}

type Query {
  users: [UserType!]!
  searchUsers(user: UserInput): [UserType!]!
}

`;
