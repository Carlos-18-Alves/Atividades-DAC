import React from 'react';
import './Login.css';

import { withRouter  } from 'react-router-dom';

import Card from '../../components/Card';
import FormGroup from '../../components/FormGroup';

import { showSuccessMessage, showErrorMessage } from '../../components/Toastr';

import { AuthContext  } from '../../main/SessionProvider';

class Login extends React.Component {

  state = {
    username: '',
    password: ''
  }

  login = () => {
        this.context.login(
              this.state.username,
              this.state.password
        ).then(user =>  
          {
            if(user){
              showSuccessMessage(`Welcome, ${user.name}`);
              this.props.history.push('/viewUsers');
            }else{
              showErrorMessage('Invalid login!');
            }
          }
        ).catch( error => 
          {
            showErrorMessage('Error processing authentication: ', error);
          }
        );
  }

  createUser = () => {
    this.props.history.push('/createUser');
  }

  render(){
    return(
      <div className='container'>
        <br/><br/><br/>
        <div className='row'>
          <div>
            <div className='bs-docs-section'>
              <Card title='Login'>
                <div className='row'>
                  <div className='col-lg-12'>
                    <div className='bs-component'>
                      <fieldset>
                        <FormGroup label='Username: *' htmlFor='inputUsername'>
                          <input type='text' className='form-control' id='inputUsername' 
                            placeholder='Insert username'
                            value={this.state.username} onChange={(e) => this.setState({username: e.target.value})} />
                        </FormGroup>
                        <FormGroup label='Password: *' htmlFor='inputPassword'>
                          <input type='password' className='form-control' id='inputPassword' 
                            placeholder='Insert password'
                            value={this.state.password} onChange={(e) => this.setState({password: e.target.value})} />
                        </FormGroup>
                        <button className='btn btn-success' onClick={this.login}>Login</button>
                        <button className='btn btn-danger' onClick={this.createUser}>Register</button>
                      </fieldset>
                    </div>
                  </div>
                </div>
              </Card>
            </div>
          </div>
        </div>
      </div>
    )
  }
}

Login.contextType = AuthContext;
export default withRouter (Login);