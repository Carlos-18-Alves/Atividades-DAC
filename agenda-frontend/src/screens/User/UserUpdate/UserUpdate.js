import React from 'react'
import './UserUpdate.css';

import { withRouter } from 'react-router-dom';

import Card from '../../../components/Card';
import FormGroup from '../../../components/FormGroup';

import UserApiService from '../../../services/UserApiService';

import { showSuccessMessage, showErrorMessage } from '../../../components/Toastr';

class UserUpdate extends React.Component{

    state = {
        id: '',
        name : '',
        username: ''
    }

    constructor(){
        super();
        this.service = new UserApiService();
    }

    validate = () => {
        const errors = [];

        if(!this.state.name){
            errors.push('Field name is required!');
        }

        if(!this.state.username){
            errors.push('Field username is required!');
        }

        return errors;
    }

    componentDidMount(){
        const params = this.props.match.params;
        const id = params.id;
        this.findById(id);
    }

    update = () => {
        const errors = this.validate();

        if(errors.length > 0){
            errors.forEach( (message, index) => {
                showErrorMessage(message);
            } );
            return false;
        }

        this.service.update(this.state.id, 
        {
            name: this.state.name,
            email: this.state.email,
            username: this.state.username,
        }
        ).then( response => 
            {
                showSuccessMessage(`User ${this.state.name} successfully updated`);
                this.props.history.push('/viewUsers');
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

    findById = (userId) => {
        this.service.get(`?id=${userId}`)
        .then( response => 
            {
                const user = response.data[0];
                const id = user.id;
                const name = user.name;
                const username = user.username;

                this.setState({id, name, username});
            }
        ).catch( error => 
            {
                console.log(error.response);
            }
        );
    }

    render(){
        return (
            <div className='container'>
                <br/><br/><br/><br/>
                <Card title="User update">
                    <div className="row">
                        <div className="col-lg-12">
                            <div className="bs-component">
                                <FormGroup label="Id: *" htmlFor="inputid">
                                    <input type="text" 
                                        id="inputid" 
                                        disabled={true}
                                        className="form-control"
                                        value={this.state.id}
                                        name="id"
                                        onChange={e => this.setState({id: e.target.value})} />
                                </FormGroup>
                                <FormGroup label="Name: *" htmlFor="inputname">
                                    <input type="text" 
                                        id="inputname" 
                                        className="form-control"
                                        value={this.state.name}
                                        name="name"
                                        onChange={e => this.setState({name: e.target.value})} />
                                </FormGroup>
                                <FormGroup label="Username: *" htmlFor="inputUsername">
                                    <input type="username" 
                                        id="inputUsername"
                                        className="form-control"
                                         value={this.state.username}
                                        name="username"
                                        onChange={e => this.setState({username: e.target.value})} />
                                </FormGroup>
                                <button onClick={this.update} type="button" className="btn btn-success">
                                    <i className="pi pi-save"></i> Update
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

export default withRouter(UserUpdate);