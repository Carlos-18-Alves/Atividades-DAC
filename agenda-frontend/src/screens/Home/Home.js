import React from 'react';
import './HomeStyle.css';
import 'bootswatch/dist/cyborg/bootstrap.css';

export default class Home extends React.Component {

  getLoggedUser = () => {
    var value = localStorage.getItem('loggedUser');
   
    if(!value) {
      return null;
    }
   
    var user = JSON.parse(value);
  
    return user;
  }

  render(){
    return (
        <h2 className='App-header'>
           <br/><br/>
            <p><big>Welcome to the Agenda! 
                <br/><br/>
                Add your commitments and don't forget later...</big></p>
                <br/><br/>
                <label>Logged user: { this.getLoggedUser() != null ? this.getLoggedUser().name : ''} </label> 
                <br/><br/><br/>
                <div className="card text-white bg-warning mb-3">
                <div className="card-header">Aluno: Carlos Alves   
                <br/>Disciplina: Desenvolvimento de Aplicações Corporativas
                <br/>Professor: Elenilson Vieira</div>

                <div className="card-body">
                <h4 className="card-title">Projeto de DAC - IFPB</h4>
    <p className="card-text">Esse projeto foi feito como um dos requisitos para conclusão da disciplina, onde aprendemos a utilizar
    várias ferramentas para o desenlvolvimento web</p>
              </div>
</div>
        </h2>
        
    );
  }
}