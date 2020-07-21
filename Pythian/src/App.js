import React from 'react';
import {Switch,Route,Redirect} from 'react-router-dom';
import 'bootstrap/dist/css/bootstrap.min.css'
import '@fortawesome/fontawesome-free/css/all.css'
import './App.css'

import Navbar from './Components/Navbar'
import Dashboard from './Components/Dashboard'
import GCOP from './Components/GCOP'

// import Default from './Components/Default'

function App() {
  return (
    <React.Fragment>
      <Navbar></Navbar>
      <Switch>
        <Route exact path="/" component={Dashboard}></Route>
        <Route path="/GCOP" component={GCOP}></Route>
        {/* <Route  component={Default}></Route> */}
        <Redirect from="/" to="/"></Redirect>
      </Switch>
    {/* <ProductModel></ProductModel> */}
    </React.Fragment>
    );
}

export default App;
