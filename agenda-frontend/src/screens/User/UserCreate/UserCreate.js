import React from 'react'
import './UserCreate.css';

import { withRouter } from 'react-router-dom';
import axios from 'axios';

import Card from '../../../components/Card';
import FormGroup from '../../../components/FormGroup';

import { showSuccessMessage, showErrorMessage } from '../../../components/Toastr';

class UserCreate extends React.Component{

    state = {
        name : '',
        username: '', 
        password: '',
        passwordRepeat : '',
    }

    create = () => {
        const errors = this.validate();

        if(errors.length > 0){
            errors.forEach( (message, index) => {
                showErrorMessage(message);
            } );
            return false;
        }

        axios.post('http://localhost:8080/api/user', 
            {
                name: this.state.name,
                username: this.state.username,
                password: this.state.password
            }
        ).then( response => 
            {
                showSuccessMessage("User created successfully!");
                this.props.history.push("/login");
            }
        ).catch( error => 
            {
                console.log(error.response);
            }
        );
    }

    cancel = () => {
        this.props.history.push('/');
    }

    validate = () => {
        const errors = [];

        if(!this.state.name){
            errors.push('Field name is required!');
        }

        if(!this.state.username){
            errors.push('Field username is required!');
        }

        if(!this.state.password){
            errors.push('Field password is required!');
        }else if(this.state.password !== this.state.passwordRepeat){
            errors.push('Passwords do not match!');
        }

        return errors;
    }

    render(){
        return (
            <div className='container'>
                <br/><br/><br/>
                <Card title="User registration">
                    <div className="row">
                        <div className="col-lg-12">
                            <div className="bs-component">
                                <FormGroup label="Name: *" htmlFor="inputname">
                                    <input type="text" 
                                        id="inputname" 
                                        className="form-control"
                                        name="name"
                                        onChange={e => this.setState({name: e.target.value})} />
                                </FormGroup>
                                <FormGroup label="Username: *" htmlFor="inputUsername">
                                    <input type="username" 
                                        id="inputUsername"
                                        className="form-control"
                                        name="username"
                                        onChange={e => this.setState({username: e.target.value})} />
                                </FormGroup>
                                <FormGroup label="Password: *" htmlFor="inputpassword">
                                    <input type="password" 
                                        id="inputpassword"
                                        className="form-control"
                                        name="password"
                                        onChange={e => this.setState({password: e.target.value})} />
                                </FormGroup>
                                <FormGroup label="Repeat the password: *" htmlFor="inpuPasswordRepeat">
                                    <input type="password" 
                                        id="inpuPasswordRepeat"
                                        className="form-control"
                                        name="password"
                                        onChange={e => this.setState({passwordRepeat: e.target.value})} />
                                </FormGroup>
                                <button onClick={this.create} type="button" className="btn btn-success">
                                    <i className="pi pi-save"></i> Save
                                </button>
                                <button onClick={this.cancel} type="button" className="btn btn-danger">
                                    <i className="pi pi-times"></i> Cancel
                                </button>
                            </div>
                        </div>
                    </div>
                </Card>
            </div>
        )
    }
}

export default withRouter(UserCreate);