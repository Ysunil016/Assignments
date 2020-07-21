import React, { Component} from 'react'
import Menu from './Dashboard/Menu/Ignite'
import ListView from './Dashboard/List/Ignite'
import InfoView from './Dashboard/Info/Ignite'
import MapView from './Dashboard/Map/Ignite'

import {ItemConsumer} from './Dashboard/Context/Context'


export default class Dashboard extends Component {
  
    state={
        selectedItemId:null,
        funcs:{
            selectItem:null
        }
    }

    
    componentDidMount = ()=>{
        this.setSelectItem();
    }



    render() {
        return (
            <div className="row m-0" style={{backgroundColor:"var(--dark_1)"}}>
                <div className="col-6">
                <Menu></Menu>
            <ItemConsumer>
                {(value)=>{
                    return <ListView handleItem={value.handleItem}></ListView>  
                }
                }
            </ItemConsumer>
                </div>
                <div className="col-6">
                <InfoView></InfoView>
                <MapView></MapView>
                </div>
            </div>
        )
    }

    selectItem = (id)=>{
        if(id)
        this.setState(()=>{return {
            selectedItemId:id
        }})
    }

    setSelectItem=()=>{
        this.setState(()=>{return {
            funcs:{
                selectItem:this.selectItem
            }
        }})
    }

    

    
}

