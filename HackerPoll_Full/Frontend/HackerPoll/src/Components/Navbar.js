import React, { Component } from 'react'
import {Link} from 'react-router-dom'
import logo from '../coda.png'
import styled from 'styled-components'

import {NavButton} from './Elements/Button'

export default class Navbar extends Component {
    render() {
        return (
            <NavWrapper className="navbar navbar-expand-sm navbar-dark px-sm-5">

                <Link to="/" >
                    <img src={logo} width="136px" alt="Store" className="navbar-brand"></img>
                </Link>
                <ul className="navbar-nav align-items-center">
                <li className="nav-item ml-5">
                    <Link to="/" className="nav-link">Hacker Voting Portal</Link>
                </li>
                </ul>
                <Link to="/cart" className="ml-auto">
                    {/* <NavButton>
                        <span className="mr-2">
                        <i className="fas fa-cart-plus"></i>
                        </span>
                        Cart
                    </NavButton> */}
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

