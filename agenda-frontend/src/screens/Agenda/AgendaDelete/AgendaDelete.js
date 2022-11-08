import React from 'react';
import './AgendaDeleteStyle.css';

import { withRouter } from 'react-router-dom';
import axios from 'axios';

import Card from '../../../components/Card';
import FormGroup from '../../../components/FormGroup';

class AgendaDelete extends React.Component {

state = {
  id:0
}

delete = async() => {
  if(this.state.id===0)
    console.error('Campo id é obrigatório!')
  
    else {
      await axios.delete(`http://localhost:8080/api/calendar/${this.state.id}`,
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
        <Card title="Agenda Delete">
          <div className='row'>
            <div className='col-lg-12'>
              <div className='bs-component'>
                <FormGroup label="Id: *" htmlFor="eventid">
                  <input type="number"
                  id="eventid"
                  className='form-control'
                  name="id"
                  onChange={e => this.setState({id: e.target.value})} />
                </FormGroup>
                <br/>
                <button onClick={this.delete} type="button" className='btn btn-primary'>
                  <i className='pi pi-save'></i> Delete
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

export default withRouter(AgendaDelete);