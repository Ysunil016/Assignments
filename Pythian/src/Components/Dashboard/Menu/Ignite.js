import React, { Component } from 'react'
import {Link} from 'react-router-dom'

import styled from "styled-components"

export default class Ignite extends Component {
    render() {
        return (
            <SwitchMenuWrapper>

              <nav className="row m-0 navbar">
                    <form className="col-5 form-inline dash_menu">
                    <Link to="/">
                    <button className="btn btn-outline-success" type="button"><i className="fas fa-tachometer-alt fa-1x"></i></button>
                    </Link>
                    <Link to="/GCOP">
                    <button className="btn btn-outline-warning" type="button"><i className="fas fa-globe-asia fa-1x"></i></button>
                   </Link>
                    </form>
                    <form className="col-7 form-inline dash_stats">
                        stats
                    </form>
                </nav>
                    
                {/* <div className="row m-0">

                <div className="col-md-6 container-fluid">
                    <Link to="/">
                        <button className="btn"><i className="fas fa-tachometer-alt fa-1x"></i></button>
                    </Link>
                    <Link to="/CGOP">
                        <button className="btn"><i className="fas fa-globe-asia fa-1x"></i></button>
                    </Link>
                    
                </div>
                <div className="col-md-6 container-fluid">
                    Stats
                </div>
                </div> */}

                
            </SwitchMenuWrapper>
        )
    }
}

const SwitchMenuWrapper = styled.div`
{
    background-color:var(--dark_2);
    border:1px solid black;
    border-radius:0 0 4px 4px;
}
.dash_menu button{
    margin:0.5rem;
}


`;
