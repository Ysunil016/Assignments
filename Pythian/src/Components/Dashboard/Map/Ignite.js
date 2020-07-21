import React, { Component } from 'react'
import ReactMapGL from 'react-map-gl';
import MapMarker from './MapMarker'
import Styled from 'styled-components'
import {ItemConsumer} from '../Context/Context'

const MAPBOX_API = "pk.eyJ1Ijoic3VuaWwwMTYiLCJhIjoiY2p0azh4dGxoMDkwejQzcTNhc2I5enFoOCJ9.QvzpRwYLcGl4hW9xtzi95w"

export default class Ignite extends Component {

    state={
        selectedTrack:null
      }

    //   setViewPort = (viewPort)=>{
    //     this.setState(()=>{return {viewPort:viewPort}});
    //   }
      
    render() {
        return (
            <MapWrapper className="mt-2">
                <ItemConsumer>
                    {
                        (value)=>{
                            return (
                            <ReactMapGL
                                {...value.viewPort}
                                mapboxApiAccessToken={MAPBOX_API}  
                                mapStyle="mapbox://styles/mapbox/dark-v10"
                                onViewportChange={(viewPort)=>{value.setViewPort(viewPort)}}
                                // onHover={(e)=>{
                                // this.mouseHover(e);
                                // }}
                                className="dash_map"
                                >
                                    {(Object.keys(value.itemDetail).length!==0)?
                                    <MapMarker value={value.itemDetail}></MapMarker>
                                    :(Object.keys(value.ItemsInfo).map((key2,i)=>{
                                        return(
                                            <MapMarker key={i} value={value.ItemsInfo[key2]}></MapMarker>
                                        )}))}
                                </ReactMapGL>
                            )
                        }
                    }
                </ItemConsumer>
        </MapWrapper>
        )
    }
}

const MapWrapper = Styled.div`
{
    border:1px solid black
}
.dash_map{
    margin:auto;
    width:auto;
    heigth:calc(48vh);
}
.element_inline_list{
    overflow-y:auto
}
.mapboxgl-ctrl-logo{
    display:none
}
.mapboxgl-ctrl-bottom-right{
    display:none
}
`;
