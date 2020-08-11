import React from 'react';
import ReactDOM from 'react-dom';
import {BrowserRouter as Router} from 'react-router-dom'
import './index.css';
import App from './App';
import * as serviceWorker from './serviceWorker';

//Top of the Hierarchy
import {HackerProvider} from './Components/Elements/Context'

ReactDOM.render(
  <React.StrictMode>
    <HackerProvider>
      <Router>
        <App />
      </Router>
    </HackerProvider>
  </React.StrictMode>,
  document.getElementById('root')
);

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();
