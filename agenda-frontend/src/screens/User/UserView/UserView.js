import React from 'react';
import './UserView.css';

import { withRouter } from 'react-router-dom';

import Card from '../../../components/Card';
import FormGroup from '../../../components/FormGroup';
import UsersTable from '../../../components/UsersTable';

import UserApiService from '../../../services/UserApiService';

import { showSuccessMessage } from '../../../components/Toastr';

class UserView extends React.Component {

    state = {
        name: '',
        username: '',
        id: 0,
        users : []
    }

    constructor(){
        super();
        this.service = new UserApiService();
    }

    componentDidMount(){
        this.find();
    }

    find = () => {
        var params = '?';

        if(this.state.id != ''){
            if(params != '?'){
                params = `${params}&`;
            }

            params = `${params}id=${this.state.id}`;
        }

        if(this.state.name != ''){
            if(params != '?'){
                params = `${params}&`;
            }

            params = `${params}name=${this.state.name}`;
        }

        if(this.state.username != ''){
            if(params != '?'){
                params = `${params}&`;
            }

            params = `${params}username=${this.state.username}`;
        }

        this.service.find(params)
        .then( response => 
            {
                const users = response.data;
                this.setState({users});
            }
        ).catch( error => 
            {
                console.log(error.response);
            }
        );
    }

    delete = (userId) => {
        this.service.delete(userId
        ).then( response => 
            {
                showSuccessMessage(`User ${userId} successfully deleted`);
                this.find();
            }
        ).catch( error => 
            {
                console.log(error.response);
            }
        );
    }

    edit = (userId) => {
        this.props.history.push(`/updateUser/${userId}`);
    }

    render(){
        return (
            <div className='container'>
                <br/><br/><br/>
                <Card title="Users List">
                    <div className="row">
                        <div className="col-md-6">
                            <div className="bs-component">
                                <FormGroup htmlFor="inputId" label="Id:">
                                    <input type="text" 
                                        className="form-control" 
                                        id="inputId" 
                                        value={this.state.id}
                                        onChange={e => this.setState({id: e.target.value})}
                                        placeholder="Insert id" />
                                </FormGroup>

                                <FormGroup htmlFor="inputName" label="Name:">
                                    <input type="text" 
                                        className="form-control" 
                                        id="inputName" 
                                        value={this.state.name}
                                        onChange={e => this.setState({name: e.target.value})}
                                        placeholder="Insert name" />
                                </FormGroup>

                                <FormGroup htmlFor="inputUsername" label="Username:">
                                    <input type="text" 
                                        className="form-control" 
                                        id="inputUsername" 
                                        value={this.state.username}
                                        onChange={e => this.setState({username: e.target.value})}
                                        placeholder="Insert username" />
                                </FormGroup>

                                <button onClick={this.find} 
                                        type="button" 
                                        className="btn btn-success">
                                        <i className="pi pi-search"></i> Find
                                </button>

                            </div>
                            
                        </div>
                    </div>   
                    <br/ >
                    <div className="row">
                        <div className="col-md-12">
                            <div className="bs-component">
                                <UsersTable users={this.state.users} 
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

export default withRouter(UserView);