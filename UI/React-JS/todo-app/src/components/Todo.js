import React, { Component } from "react";

export class Todo extends Component {

  onRemoveHandler = (event, value) => {
      event.preventDefault();
      this.props.onRemoveHandler(value);
  }

  render() {
    return (
      <div>
        <table>
          {/* <thead>
            <tr>
              <th>Todo</th>
            </tr>
          </thead> */}
          <tbody>
            <tr>
              <td>{this.props.todo.value}</td>
              <td></td>
              <td><button onClick={(e) => this.onRemoveHandler(e,this.props.todo)}>Remove</button></td>
            </tr>
          </tbody>
        </table>
      </div>
    );
  }
}
