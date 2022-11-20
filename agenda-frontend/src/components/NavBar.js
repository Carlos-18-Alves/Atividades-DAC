import React from "react";

import NavBarItem from "./NavBarItem";
import { AuthConsumer } from "../main/SessionProvider";

function NavBar(props){
    return(
        <nav className="navbar navbar-expand-lg fixed-top navbar-dark bg-primary">
        <div className="container-fluid">
            <a href="/" className="navbar-brand" >DAC - Agenda</a>
            <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span className="navbar-toggler-icon"></span>
            </button>
            <div className="collapse navbar-collapse" id="navbarResponsive">
                <ul className="navbar-nav">
                    <NavBarItem href="/" label="Home" />
                    <NavBarItem render={props.isAuthenticated} href="/viewUsers" label="Users" />
                    <NavBarItem render={!props.isAuthenticated} href="/login" label="Login" />
                    <NavBarItem render={props.isAuthenticated} href='/login' onClick={props.logout} label="Logout" />
                    <NavBarItem href="/createAgenda" label="Create Agenda" />
                    <NavBarItem href="/listAgendas" label="List Agendas" />
                </ul>
            </div>
        </div>
        </nav>
    );
}

// eslint-disable-next-line import/no-anonymous-default-export
export default () => (
    <AuthConsumer>
      {(context) => (
          <NavBar isAuthenticated={context.isAuthenticated} logout={context.end} />
      )}
    </AuthConsumer>
  )