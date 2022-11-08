import React from "react";

import NavBarItem from "./NavBarItem";

function NavBar(props){
    return(
        <nav className="navbar navbar-expand-lg fixed-top navbar-dark bg-primary">
        <div className="container-fluid">
            <a href="/" className="navbar-brand" >DAC - Agenda</a>
            <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span className="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarResponsive">
                <ul className="navbar-nav">
                    <NavBarItem href="/" label="Home" />
                    <NavBarItem href="/createAgenda" label="Create Agenda" />
                    <NavBarItem href="/updateAgenda" label="Update Agenda" />
                    <NavBarItem href="/deleteAgenda" label="Delete Agenda" />
                    <NavBarItem href="/listAgendas" label="List Agendas" />
                </ul>
            </div>
        </div>
        </nav>
    );
}

export default NavBar;
