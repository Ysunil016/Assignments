import React, { Component } from 'react'
import {Marker} from 'react-map-gl';

import MapPopup from './MapPopup'

export default class componentName extends Component {
  state={
    selectedTrack:null
  }

  componentDidMount = ()=>{
    this.eventHandler();
  }

  render() {
    return (
      <React.Fragment>
        {this.props.geoJson.default.features.map((item,index)=>{
            return (
                <Marker key={index} latitude={item.geometry.coordinates[1]} longitude={item.geometry.coordinates[0]}>
                  <span className="marker-button" onClick={(e)=>{
                      e.preventDefault();
                      this.setSelectedTrack(item);
                  }}>
                    <img src="/Map/Tracks/ownship/ownship.png" alt="Track" width="20rem"></img>
                  </span>
              </Marker>
            )
          })}
          {this.state.selectedTrack ? (
            <MapPopup track={this.state.selectedTrack} setSelectedTrack={this.setSelectedTrack}></MapPopup>
          ):null}:
      </React.Fragment>
    )
  }



  setSelectedTrack = (Park)=>{
    this.setState(()=>{
      return {selectedTrack:Park}
    })
  }
  eventHandler = ()=>{
    const listner = e=>{
      if(e.key==="Escape"){
        this.setSelectedTrack(null)
      }
    }
    window.addEventListener("keydown",listner);
    return ()=>{
      window.removeEventListener("keydown",listner);
    }
  }
  
}
