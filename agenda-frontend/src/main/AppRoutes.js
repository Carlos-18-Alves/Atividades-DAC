import React from "react";
import { Route, BrowserRouter, Switch, Redirect } from "react-router-dom";

import Home from "../screens/Home/Home";
import AgendaCreate from "../screens/Agenda/AgendaCreate/AgendaCreate";
import AgendaUpdate from "../screens/Agenda/AgendaUpdate/AgendaUpdate";
import AgendaDelete from "../screens/Agenda/AgendaDelete/AgendaDelete";
import AgendaView from "../screens/Agenda/AgendaView/AgendaView";
import Login from "../screens/Login/Login";
import UserCreate from "../screens/User/UserCreate/UserCreate";
import UserUpdate from "../screens/User/UserUpdate/UserUpdate";
import UserDelete from "../screens/User/UserDelete/UserDelete";
import UserView from "../screens/User/UserView/UserView";

import { AuthConsumer } from '../main/SessionProvider';

function RestrictedRoute( { component: Component, show, ...props } ){
    return (
        <Route exact {...props} render={ (componentProps) => {
            if(show){
                return (
                    <Component {...componentProps} />
                )
            }else{
                return(
                    <Redirect to={ {pathname : '/login', state : { from: componentProps.location } } } />
                )
            }
        }}  />
    )
 }

function AppRoutes(props) {
    return(
        <BrowserRouter>
            <Switch>
                <Route component = {Home} path = "/" exact />
                <Route component = { Login }  path="/login" />
                <Route component = { UserCreate }  path="/createUser" />

                <RestrictedRoute show={props.isAuthenticated} component = {UserUpdate}  path="/updateUser/:id" />
                <RestrictedRoute show={props.isAuthenticated} component = {UserDelete}  path="/deleteUser" />
                <RestrictedRoute show={props.isAuthenticated} component = {UserView}  path="/viewUsers" />
                <RestrictedRoute show={props.isAuthenticated} component = {AgendaCreate} path = "/createAgenda" />
                <RestrictedRoute show={props.isAuthenticated} component= {AgendaDelete} path = "/deleteAgenda" />
                <RestrictedRoute show={props.isAuthenticated} component= {AgendaUpdate} path = "/updateAgenda/:id" />
                <RestrictedRoute show={props.isAuthenticated} component = {AgendaView} path = "/listAgendas" />
            </Switch>
        </BrowserRouter>
    );
}

// eslint-disable-next-line import/no-anonymous-default-export
export default () => (
   <AuthConsumer>
       { (context) => (<AppRoutes isAuthenticated={context.isAuthenticated} />) }
   </AuthConsumer>
)