import React from 'react';
import './App.css';

export default class App extends React.Component {

state = {
  day:"",
  month:"",
  year:""
}

print = () => {
  var dateString = null;
  if(this.state.month=="1") {
    dateString = "January"
  }
  else if(this.state.month=="2") {
    dateString = "February";
  }
  else if(this.state.month=="3") {
    dateString = "March";
  }
  else if(this.state.month=="4") {
    dateString = "April";
  }
  else if(this.state.month=="5") {
    dateString = "May";
  }
  else if(this.state.month=="6") {
    dateString = "June";
  }
  else if(this.state.month=="7") {
    dateString = "July";
  }
  else if(this.state.month=="8") {
    dateString = "August";
  }
  else if(this.state.month=="9") {
    dateString = "September";
  }
  else if(this.state.month=="10") {
    dateString = "October";
  }
  else if(this.state.month=="11") {
    dateString = "November";
  }
  else if(this.state.month=="12") {
    dateString = "December";
  }
  else {

  }
  if(this.state.month==""||this.state.month==""||this.state.year=="") {
    console.log("Invalid date");
  } else {
    console.log("The created data is: %s %s, %s", dateString,this.state.day,this.state.year);
  }
   
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
        <br/>-----------------------------------------------------------------------------------
        
      </div>
    );
  }
}

