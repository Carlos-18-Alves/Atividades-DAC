import React from 'react'
import './UserDelete.css';

import { withRouter  } from 'react-router-dom';

import Card from '../../../components/Card'
import FormGroup from '../../../components/FormGroup'

import UserApiService from '../../../services/UserApiService';

import { showSuccessMessage } from '../../../components/Toastr';

class UserDelete extends React.Component{

    state = {
        id: 0
    }

    constructor(){
        super();
        this.service = new UserApiService();
    }

    delete = () => {
        this.service.delete(`/${this.state.id}`
        ).then( response => 
            {
                showSuccessMessage(`User ${this.state.id} successfully deleted`);
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

    render(){
        return (
            <div className='container'>
                <Card title="User Deletion">
                    <div className="row">
                        <div className="col-lg-12">
                            <div className="bs-component">
                                <FormGroup label="Id: *" htmlFor="inputId">
                                    <input type="text" 
                                        id="inputId" 
                                        className="form-control"
                                        name="name"
                                        onChange={e => this.setState({id: e.target.value})} />
                                </FormGroup>
                                <button onClick={this.delete} type="button" className="btn btn-success">
                                    <i className="pi pi-save"></i> Delete
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

export default withRouter(UserDelete);