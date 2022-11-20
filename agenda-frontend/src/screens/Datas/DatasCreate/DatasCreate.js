import React from 'react';
import './DatasCreateStyle.css';
import 'bootswatch/dist/cyborg/bootstrap.css';

export default class DatasCreate extends React.Component {

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
      <div className="App-header">
        <div className="form-group">
            <label className="col-form-label mt-4" htmlFor="inputDefault">Day: </label>
            <input type="text" className="form-control" placeholder="Insert day" id="inputDefault"
            value={this.state.day} onChange={(e) => {this.setState({day: e.target.value})}} />
        </div>

        <div className="form-group">
            <label className="col-form-label mt-4" htmlFor="inputDefault">Month: </label>
            <input type="text" className="form-control" placeholder="Insert month" id="inputDefault"
            value={this.state.month} onChange={(e) => {this.setState({month: e.target.value})}} />
        </div>

        <div className="form-group">
            <label className="col-form-label mt-4" htmlFor="inputDefault">Year: </label>
            <input type="text" className="form-control" placeholder="Insert year" id="inputDefault"
            value={this.state.year} onChange={(e) => {this.setState({year: e.target.value})}} />
        </div>
        <br/>
        <button type="button" className="btn btn-primary" onClick={this.print}>Print</button>

      </div>
    );
  }
}