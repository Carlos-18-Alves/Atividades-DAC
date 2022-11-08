import React from "react";
import { Route, BrowserRouter } from "react-router-dom";

import Home from "../screens/Home/Home";
import AgendaCreate from "../screens/Agenda/AgendaCreate/AgendaCreate";
import AgendaUpdate from "../screens/Agenda/AgendaUpdate/AgendaUpdate";
import AgendaDelete from "../screens/Agenda/AgendaDelete/AgendaDelete";
import AgendaView from "../screens/Agenda/AgendaView/AgendaView";

function AppRoutes() {
    return(
        <BrowserRouter>
            <Route component = {Home} path = "/" exact />
            <Route component= {AgendaCreate} path = "/createAgenda" />
            <Route component= {AgendaUpdate} path = "/updateAgenda" />
            <Route component= {AgendaDelete} path = "/deleteAgenda" />
            <Route component= {AgendaView} path = "/listAgendas" />
        </BrowserRouter>
    );
}

export default AppRoutes;