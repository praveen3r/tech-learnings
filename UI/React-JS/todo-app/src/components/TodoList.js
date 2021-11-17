import React, { Component } from 'react'
import { Todo } from './Todo'

export class TodoList extends Component {
    render() {
        return (
            this.props.todoList.map(todo => <Todo 
                            key={todo.id} todo={todo}
                            onRemoveHandler={this.props.onRemoveHandler}/>)
        )
    }
}
