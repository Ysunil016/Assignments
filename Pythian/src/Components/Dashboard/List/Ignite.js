import React, { Component } from 'react'
import Styled from 'styled-components'
import Entity from './Entity'

import ListItems from '../../../Resources/Dashboard/UnitList.json'

export default class Ignite extends Component {

    render() {
        return (
            <ListWrapper className="row m-0 mt-2">
                {
                    ListItems.map((item,i)=>{
                        return <Entity key={i} image={item.image} items={item.items} itemFunc={this.props.handleItem}></Entity>
                    })
                }
            </ListWrapper>
        )
    }
}

const ListWrapper = Styled.div`
{
    border:1px solid black;
    height: calc(100vh - 144px);
    overflow-y: auto;
}
`;
