import React from 'react';
import {Switch,Route,Redirect} from 'react-router-dom';
import 'bootstrap/dist/css/bootstrap.min.css'
import '@fortawesome/fontawesome-free/css/all.css'
import './App.css'

import Navbar from './Components/Navbar'
import ProductList from './Components/ProductList'
import Details from './Components/Details'
// import Default from './Components/Default'

function App() {
  return (
    <React.Fragment>
      <Navbar></Navbar>
      <Switch>
        <Route exact path="/" component={ProductList}></Route>
        <Route path="/details" component={Details}></Route>

        {/* <Route  component={Default}></Route> */}
        <Redirect from="/" to="/"></Redirect>
      </Switch>
    </React.Fragment>
    );
}

export default App;
