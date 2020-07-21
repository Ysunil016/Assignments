import React, { Component } from 'react'
import Entity from './Entity'
import styled from 'styled-components'

import Info from '../../../Resources/Dashboard/Info.json'
import {ItemConsumer} from '../Context/Context'


export default class Ignite extends Component {

    state={
        selectedItem:{}
    }

    componentDidMount = ()=>{
        if(this.props.itemId)
        this.setState(()=>{return {
            selectedItem:Info[this.props.itemId]
        }})
    }

    render() {
        return (
            <InfoWrapper>
                <form className="info_form">
                <ItemConsumer>
                        {(value)=>{
                            return <div className="info_title">{value.selectedItemId}</div>
                        }
                    }
                 </ItemConsumer>
                <div className="form-row align-items-center mx-auto">
                <ItemConsumer>
                        {(value)=>{
                            return Object.keys(value.itemDetail).map((key,i)=>{
                            return <Entity key={i} key_val={key} value={value.itemDetail[key]}></Entity>
                            })
                        }
                    }
                </ItemConsumer>
                    </div>
                </form>
            </InfoWrapper>
        )
    }
}

const InfoWrapper = styled.div`
.info_form{
    height:calc(40vh);
    max-height:calc(50vh);
    overflow-y:auto;
    border:1px solid black;
    border-radius:0 0 4px 4px;
}
.info_title{
    color:white;
    text-align:center;
    font-weight:bold;
    text-transform:uppercase;
    font-size:1.5rem;
    display: block;
    margin: 4px;
}
`;
