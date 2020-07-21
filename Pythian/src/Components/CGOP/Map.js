import React,{Component} from 'react'
import {geolocated} from 'react-geolocated'
import ReactMapGL,{Layer} from 'react-map-gl';
import styled from 'styled-components'
import Scale from './MapElement/Components/MapScale'
import Sidebar from './MapElement/Components/MapSidebar'
import MapMarker from './MapElement/Elements/MapMarker'

import * as geoJson from '../../Resources/Park.json'

const MAPBOX_API = "pk.eyJ1Ijoic3VuaWwwMTYiLCJhIjoiY2p0azh4dGxoMDkwejQzcTNhc2I5enFoOCJ9.QvzpRwYLcGl4hW9xtzi95w"

class Map extends Component {

  state={
    viewPort:{
      longitude: 78,
      latitude: 19,
      zoom: 3.84,
      height:"calc(100vh - var(--nav_height))",
      width:"100vw"  
    },
    lat_lng:[78,19],
    selectedTrack:null
  }


  componentDidMount = ()=>{
    this.eventHandler();
  }


  setViewPort = (viewPort)=>{
    this.setState(()=>{return {viewPort:viewPort}});
  }
  
  mouseHover = (el)=>{
      this.setState(()=>{
        return {lat_lng:[el.lngLat[0].toFixed(2),el.lngLat[1].toFixed(2)]}
      })
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
 
  render() {   
    return (
      <MapWrapper>
        <Sidebar></Sidebar>
        <ReactMapGL
        {...this.state.viewPort}
        mapboxApiAccessToken={MAPBOX_API}  
        mapStyle="mapbox://styles/mapbox/dark-v10"
        onViewportChange={(viewPort)=>{this.setViewPort(viewPort)}}
        onHover={(e)=>{
          this.mouseHover(e);
        }}>
        <MapMarker geoJson={geoJson}></MapMarker>
        <Layer type source="./stations.zip"></Layer>
        </ReactMapGL>
        <Scale lng={this.state.lat_lng[0]} lat={this.state.lat_lng[1]} zoom={this.state.viewPort.zoom.toFixed(2)}></Scale>
      </MapWrapper>
    )
}
  


  MapMouseMoveController = (map)=>{
    map.on('mousemove', (e) => {
      this.setState({
        lng: e.lngLat.lat.toFixed(2),
        lat: e.lngLat.lng.toFixed(2),
        });
    });
  }

  MapMoveController = (map)=>{
    map.on('move', (e) => {
      this.setState({
        zoom : map.getZoom().toFixed(2) 
      });
    });
  }
}

export default geolocated({
  positionOptions: {
      enableHighAccuracy: true,
  },
  userDecisionTimeout: 5000,
})(Map);











const MapWrapper = styled.div`
.sidebarStyle {
  display: inline-block;
  position: absolute;
  left: 0;
  bottom:0;
  z-index: 1 !important;
  background-color: #404040;
  color: #ffffff;
  padding: 6px;
  font-weight: bold;
  border-radius:0 0.5rem 0 0
  }

  .ownPositionIcon{
    position: absolute;
    top: calc(var(--nav_height)+2rem);
    z-index:1;
    font-size: 2rem;
    background:none;
    border:none 
  }
   
  .mapContainer {
  position: absolute;
  right: 0;
  top: var(--nav_height);
  left: 0;
  bottom: 0;
  }

  .mapboxgl-control-container{
    display:none
  }

  .marker-button{
    background:none;
    border:none;
    cursor:pointer;
  }
  .marker-button img{
    width:20px;
    height:20px;
  }
  
`;








