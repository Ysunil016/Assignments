import React, { Component } from 'react'
import Items from '../../../Resources/Dashboard/UnitList.json'
import ItemInfo from '../../../Resources/Dashboard/Info.json'

const ItemContext = React.createContext();

class ItemProvider extends Component {
    state = {
        viewPort:{
              longitude: 78,
              latitude: 19,
              zoom: 2,
              height:"calc(48vh)",
              width:"auto"  
        },
        items:Items,
        ItemsInfo:ItemInfo,
        selectedItemId:"",
        itemDetail:{},
        modelOpen:false,
    }

    setProduct = ()=>{
    }

    getItemById = (id)=>{
        console.log("Getting Data Based on ID ",id);
        id = id.toLowerCase();
        if(ItemInfo[id]){
            return ItemInfo[id];
        }
        else
        return {}
    }

    setViewPort = (viewPort)=>{
        this.setState(()=>{return {viewPort:viewPort}});
      }

    handleItem = (id)=>{
        console.log("Setting Element ID ",id);
        this.setState(()=>{
            return {selectedItemId:id,itemDetail:this.getItemById(id)}
        })
    }
    openModel = (id)=>{
        const product = this.getItemById(id);
        this.setState(()=> {return {modelOpen:true,modelProduct:product
        }})
    }
    closeModel = ()=>{
        this.setState(()=> {return {modelOpen:false
        }})
    }
    
    render() {
        return (
            <ItemContext.Provider value={{
                ...this.state,
                handleItem:this.handleItem,
                openModel:this.openModel,
                closeModel:this.closeModel,
                setViewPort:this.setViewPort
            }}>
                {this.props.children}
            </ItemContext.Provider>
        )
    }
}

const ItemConsumer = ItemContext.Consumer

export {ItemProvider,ItemConsumer}