import React from 'react'
import {Popup} from 'react-map-gl';

export default function MapPopup({track,setSelectedTrack}) {
    return (
        <div>
        <Popup 
            latitude={track.geometry.coordinates[1]} 
            longitude={track.geometry.coordinates[0]}
            onClose={()=>{
                  setSelectedTrack(null)
            }}
            >
              <div>Park</div>
            </Popup>    
        </div>
    )
}
