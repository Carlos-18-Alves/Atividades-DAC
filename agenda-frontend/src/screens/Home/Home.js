import React from 'react';
import './HomeStyle.css';
import 'bootswatch/dist/cyborg/bootstrap.css';

export default class Home extends React.Component {
  render(){
    return (
        <h2 className='App-header'>
           <br/><br/>
            <p><big>Welcome to the Agenda! 
                <br/><br/>
                Add your commitments and don't forget later...</big></p>
                <br/><br/><br/><br/><br/><br/>
  <div class="card text-white bg-warning mb-3">
  <div class="card-header">Disciplina: Desenvolvimento de Aplicações Corporativas   
  <br/>Professor: Elenilson Vieira
  <br/>Aluno: Carlos Alves</div>

  <div class="card-body">
    <h4 class="card-title">Projeto de DAC - IFPB</h4>
    <p class="card-text">Esse projeto foi feito como um dos requisitos para conclusão da disciplina, onde aprendemos a utilizar
    várias ferramentas para o desenlvolvimento web</p>
  </div>
</div>
        </h2>
        
    );
  }
}