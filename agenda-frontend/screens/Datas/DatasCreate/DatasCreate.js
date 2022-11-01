import React from 'react';
import './AgendaCreateStyle.css';

export default class App extends React.Component {

state = {
  day:"",
  month:"",
  year:"2023"
}

print = () => {
    console.log(this.state.ano);
}

  render(){
    return (
      <div className="App">
        <label>Day: </label>
        <input type="text" value={this.state.day} onChange={(e) => {this.setState({day: e.target.value})}} />

        <br/>
        <label>Month: </label>
        <input type="text" value={this.state.month} onChange={(e) => {this.setState({month: e.target.value})}} />

        <br/>
        <label>Year: </label>
        <input type="text" value={this.state.year} onChange={(e) => {this.setState({year: e.target.value})}} />

        <br/>
        <button onClick={this.print}>Print</button>
        
      </div>
    );
  }
}