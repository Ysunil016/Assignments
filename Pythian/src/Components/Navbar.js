import React, { Component } from 'react'
import {Link} from 'react-router-dom'
import logo from '../logo.svg'
import styled from 'styled-components'
import {NavButton} from './Elements/Button'

export default class Navbar extends Component {
    render() {
        return (
            <NavWrapper className="row navbar navbar-expand-sm navbar-dark px-sm-5 m-0">
                <Link className="col-lg-2 col-2" to="/" >
                    <img src={logo} alt="Store" style={{width:"2rem",transform:"scale(1.7)"}} className="navbar-brand"></img>
                </Link>
                <ul className="col-8 d-sm-block d-none navbar-nav align-self-center align-items-center">
                <li className="nav-item mx-auto">
                    <h2 className="text-white text-center">Force Commandor</h2>
                </li>
                </ul>
                <Link to="/CGOP" className="ml-5 col-2">
                    <NavButton className="float-right ">
                        <span className="m-1">
                        <i className="fas fa-sign-out-alt"></i>
                        </span>
                    </NavButton>
                </Link>
            </NavWrapper>
           )
    }
}


const NavWrapper = styled.nav`
    background:var(--main_blue);
    .nav-link{
        color:var(--main_white) !important;
        font-size:1.3rem;
        text-transform:capatalize;
    }
`;

