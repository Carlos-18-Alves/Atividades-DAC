import React from 'react';
import './AgendaCreateStyle.css';

import { withRouter } from 'react-router-dom';
import axios from 'axios';

import Card from '../../../components/Card';
import FormGroup from '../../../components/FormGroup';

class AgendaCreate extends React.Component {

state = {
  eventName:"",

  day:"",
  month:"",
  year:""
}

save = async() => {
  if (!this.state.eventName) {
    console.error('Campo eventName é obrigatório!')
  }
  else if (!this.state.day && !this.state.month && !this.state.year) {
    console.error('Campos de data (day, month e year) são obrigatórios!')
  } else {
      await axios.post('http://localhost:8080/api/calendar',
        {
          eventName: this.state.eventName,
          date: {
            day: this.state.day,
            month: this.state.month,
            year: this.state.year
          }
        }
      ).then( response =>
          {
            console.log(response);
          }
      ).catch( error => 
          {
            console.log(error.response);
          }
      );
      console.log("request finished");
      this.props.history.push('/');
  }
  
}

cancel = () => { 
  this.props.history.push('/');
}

  render(){
    return (
      <div className='container'>
        <br/><br/><br/><br/>
        <Card title="Agenda Create">
          <div className='row'>
            <div className='col-lg-12'>
              <div className='bs-component'>
                <FormGroup label="Event name: *" htmlFor="eventname">
                  <input type="text"
                  id="eventname"
                  className='form-control'
                  name="name"
                  onChange={e => this.setState({eventName: e.target.value})} />
                </FormGroup>
                <FormGroup label="Day: *" htmlFor="eventday">
                  <input type="number"
                  id="eventday"
                  className='form-control'
                  name="day"
                  onChange={e => this.setState({day: e.target.value})} />
                </FormGroup>
                <FormGroup label="Month: *" htmlFor="eventmonth">
                  <input type="number"
                  id="eventmonth"
                  className='form-control'
                  name="month"
                  onChange={e => this.setState({month: e.target.value})} />
                </FormGroup>
                <FormGroup label="Year: *" htmlFor="eventyear">
                  <input type="number"
                  id="eventyear"
                  className='form-control'
                  name="year"
                  onChange={e => this.setState({year: e.target.value})} />
                </FormGroup>
                <br/>
                <button onClick={this.save} type="button" className='btn btn-primary'>
                  <i className='pi pi-save'></i> Save
                </button>
                <button onClick={this.cancel} type="button" className='btn btn-secondary'>
                  <i className='pi pi-times'></i> Cancel
                </button>
              </div>
            </div>
          </div>
        </Card>
      </div>
    );
  }
}

export default withRouter(AgendaCreate);