import React, { Component } from 'react'
import { HeaderApp } from './HeaderApp';
import { AddTodo } from './AddTodo'
import { TodoList } from './TodoList'

export class TodoApp extends Component {

    constructor(props) {
        super(props)
    
        this.state = {
             todoList:[]
        }

        this.onSubmitHandler = this.onSubmitHandler.bind(this);
        this.onRemoveHandler = this.onRemoveHandler.bind(this);
    }

    onSubmitHandler(value){
        const newTodo = {
            id: value,
            value: value
        }
        this.setState(prevState => { 
            return {
                todoList: [...prevState.todoList, newTodo] 
            }
        })
            
        
    }

    onRemoveHandler(value){
        const newTodoList = this.state.todoList.filter(todo => todo.id !== value.id);
        this.setState({ 
            todoList: newTodoList
        })
            
        
    }
    
    render() {
        return (
            <div>
                <HeaderApp title = "Todo App"/>
                <AddTodo 
                    todoList={this.state.todoList}
                    onSubmitHandler={this.onSubmitHandler}/>
                <br/>
                <TodoList 
                    todoList={this.state.todoList}
                    onRemoveHandler={this.onRemoveHandler}/>
            </div>
        )
    }
}
