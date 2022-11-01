import React from 'react';
import './App.css';

export default class App extends React.Component {

  state = {
    eventName: "Learn React",
    date:"31/10/2022"
  }
  
    render(){
      return (
        
        <div className="App">
          <br/>
          <label>Event name: </label>
          <input type="text" value={this.state.eventName} onChange={(e) => {this.setState({eventName: e.target.value})}} />
  
          <br/>
          <label>Date: </label>
          <input type="text" value={this.state.date} onChange={(e) => {this.setState({date: e.target.value})}} />
          <br/>
          <br/>
          <label>The inserted event is {this.state.eventName} </label>
          <br/>
          <label>This event's date is {this.state.date}</label>
          <br/>---------------------------------------------------------------------------------
        </div>
      );
    }
  }

