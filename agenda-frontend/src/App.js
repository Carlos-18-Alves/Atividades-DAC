import React from "react";
import 'bootswatch/dist/cyborg/bootstrap.css';

import NavBar from './components/NavBar';
import AppRoutes from "./main/AppRoutes";
import SessionProvider from "./main/SessionProvider";

import 'toastr/build/toastr.css';
import 'toastr/build/toastr.min.js';

export default class App extends React.Component {

  render() {
    return(
      <SessionProvider>
        <NavBar />
        <AppRoutes />
      </SessionProvider>
    )
  }

}