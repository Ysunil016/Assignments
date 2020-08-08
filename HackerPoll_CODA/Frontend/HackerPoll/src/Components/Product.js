
import React, { Component } from 'react'
import styled from 'styled-components'
import {Link} from 'react-router-dom'
import {HackerConsumer} from './Elements/Context'

import PropTypes from 'prop-types'

export default class Product extends Component {
render() {
        const {hackerId,hackerName,image,expertLevel} = this.props.product;
        return (
            <ProductWrapper className="col-9 mx-auto col-md-6 col-lg-3 my-3">
                <div className="card">
                    <HackerConsumer>
                        {(value)=>{
                            return (
                    <div className="img-container p-5" onClick={()=>{value.handleDetail(hackerId)}}>
                        <Link to="/details">
                            <img src={image} alt={hackerName} className="card-img-top"></img>
                        </Link>
                        <button className="cart-btn" disabled={value.hasDoneVoting?true:false} onClick={()=>{
                            value.voteNow(hackerId);
                            }}>
                        {value.hasDoneVoting?(<p className="text-capitalize mb-0 btn-sm" disabled>Voting Done</p>):(<i className="fas fa-poll"></i>)}
                        </button>
                    </div>
                            )}}
                    </HackerConsumer>

                    <div className="card-footer d-flex justify-content-between">
                        <p className="align-self-center mb-0">
                            {hackerName}
                        </p>
                        <h5 className="text-blue font-italic mb-0">
                            <span className="mr-1"><i className="fas fa-star"></i></span>
                            {expertLevel}
                        </h5>
                    </div>
                </div>
            </ProductWrapper>
        )
    }
}

Product.protoType = {
    product:PropTypes.shape({
        id:PropTypes.number,
        img:PropTypes.string,
        title:PropTypes.string,
        price:PropTypes.number,
        inCart:PropTypes.bool
    }).isRequired
}


const ProductWrapper = styled.div`
.card{
    border-color:transparent;
    transition:all 0.3s linear;
    max-height:250px !important;
}
.card-footer{
    background:transparent;
    border-color:transparent;
    transition:all 0.3s linear;
}
.cart-btn{
    position:absolute;
    bottom:0;
    right:0;
    padding:0.2rem 0.4rem;
    background: var(--light_blue);
    color: var(--main_white);
    font-size: 1.4rem;
    border-radius: 0.5rem 0 0 0;
    transform: translate(100%,100%);
    transition:all 0.5s linear
}
.img-container{
    position:relative;
    overflow:hidden
}

&:hover{
    .card{
        border:0.4rem solid rgba(0,0,0,0.2);
        box-shadow:2px 2px 5px 0px rgba(0,0,0,0.2);
    }
    .card-footer{
        background:rgba(247,247,247);
    }
    .card-img-top{
        transition: all 0.5s linear;
    }
    .img-container:hover .card-img-top{
        transform: scale(1.2);
    }
    
}
.img-container:hover .cart-btn{
    transform: translate(0,0);
}
.cart-btn:hover{
    color:var(--main_blue);
    cursor:pointer
}
`;
