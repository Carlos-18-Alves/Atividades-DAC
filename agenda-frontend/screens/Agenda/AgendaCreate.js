import React from 'react';
import './AgendaCreateStyle.css';

export default class App extends React.Component {

state = {
  eventName: "",
  date:""
}

validate = () => {
    const errors = [];

    if (!this.state.name) {
      errors.push('Campo eventName é obrigatório!')
    }
    if (!this.state.date) {
      errors.push('Campo de data é obrigatório!')
    } else {
      let currentdate = new Date();
      let dia = currentdate.getDate().toString(),
        diaF = (dia.length === 1) ? '0' + dia : dia,
        mes = (currentdate.getMonth() + 1).toString(),
        mesF = (mes.length === 1) ? '0' + mes : mes,
        anoF = currentdate.getFullYear(),
        atual = anoF + "-" + mesF + "-" + diaF
      
      if (this.state.date < atual) {
        errors.push('Data inválida!')
      }
    }
}

  render(){
    return (
      <div className="App">
        <label>Event name: </label>
        <input type="text" value={this.state.eventName} onAuxClick={(e) => {this.setState({eventName: e.target.value})}} />

        <br/>
        <label>Date: </label>
        <input type="text" value={this.state.date} onAuxClick={(e) => {this.setState({date: e.target.value})}} />

        <br/>
        <button onClick={this.validate}>Sum</button>

        <br/>
        <label>O evento criado foi: {this.state.eventName} para a data {this.state.date}</label>

      </div>
    );
  }
}