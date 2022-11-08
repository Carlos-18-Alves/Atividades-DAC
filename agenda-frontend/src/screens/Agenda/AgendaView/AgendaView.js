import React from "react";
import './AgendaViewStyle.css'

import { withRouter } from "react-router-dom";
import axios from "axios";

import Card from "../../../components/Card";
import FormGroup from "../../../components/FormGroup";
import AgendasTable from "../../../components/AgendasTable";

class AgendaView extends React.Component {
    state = {
        eventName: '',
        day: '',
        month: '',
        year: '',
        id: 0,
        agendas: []
    }

    delete = (agendaId) => {
        axios.delete(`http://localhost:8080/api/calendar/${agendaId}`
        ).then( response => 
            {
                this.find();
            }
        ).catch( error => 
            {
                console.log(error.response);
            }
        );
    }

    edit = (agendaId) => {
        this.props.history.push(`/updateAgenda/${agendaId}`);
    }

    find = async() => {
        var params = '?';

        if(this.state.id != 0){
            if(params != '?'){
                params = `${params}&`;
            }

            params = `${params}id=${this.state.id}`;
        }
        
        if(this.state.eventName != ''){
            if(params != '?'){
                params = `${params}&`;
            }

            params = `${params}eventName=${this.state.eventName}`;
        }

        if(this.state.day != ''){
            if(params != '?'){
                params = `${params}&`;
            }

            params = `${params}day=${this.state.day}`;
        }

        if(this.state.month != ''){
            if(params != '?'){
                params = `${params}&`;
            }

            params = `${params}month=${this.state.month}`;
        }

        if(this.state.year != ''){
            if(params != '?'){
                params = `${params}&`;
            }

            params = `${params}year=${this.state.year}`;
        }

        await axios.get(`http://localhost:8080/api/calendar${params}`)
        .then( response => 
            {
                const agendas = response.data;
                this.setState({agendas});
                console.log(agendas);
            }
        ).catch( error => 
            {
                console.log(error.response);
            }
        );
    }

    render(){
        return(
            <div className='container'>
                <br/><br/><br/><br/>
            <Card title="Agendas List">
                <div className="row">
                    <div className="col-md-6">
                        <div className="bs-component">
                            <FormGroup htmlFor="inputId" label="Id: *">
                                <input type="text"
                                        className="form-control"
                                        id="inputId"
                                        value={this.state.id}
                                        onChange={e => this.setState({id: e.target.value})}
                                        placeholder="Insert Id" />
                            </FormGroup>
                            <FormGroup htmlFor="inputEventName" label="Event name: *">
                                <input type="text"
                                        className="form-control"
                                        id="inputEventName"
                                        value={this.state.eventName}
                                        onChange={e => this.setState({eventName: e.target.value})}
                                        placeholder="Insert the event name" />
                            </FormGroup>
                            <FormGroup htmlFor="inputDay" label="Day: *">
                                <input type="text"
                                        className="form-control"
                                        id="inputDay"
                                        value={this.state.day}
                                        onChange={e => this.setState({day: e.target.value})}
                                        placeholder="Insert the day" />
                            </FormGroup>
                            <FormGroup htmlFor="inputMonth" label="Month: *">
                                <input type="text"
                                        className="form-control"
                                        id="inputMonth"
                                        value={this.state.month}
                                        onChange={e => this.setState({month: e.target.value})}
                                        placeholder="Insert the month" />
                            </FormGroup>
                            <FormGroup htmlFor="inputYear" label="Year: *">
                                <input type="text"
                                        className="form-control"
                                        id="inputYear"
                                        value={this.state.year}
                                        onChange={e => this.setState({year: e.target.value})}
                                        placeholder="Insert the year" />
                            </FormGroup>
                            <button onClick={this.find}
                                    type="button"
                                    className="btn btn-success">
                                    <i className="pi pi-search"></i>find
                            </button>
                        </div>
                    </div>
                </div>
                <br/>
                <div className="row">
                    <div className="col-md-12">
                        <div className="bs-component">
                            <AgendasTable agendas={this.state.agendas}
                                delete={this.delete}
                                edit={this.edit} />
                        </div>
                    </div>
                </div>
            </Card>
            </div>
        )
    }
}

export default withRouter(AgendaView);