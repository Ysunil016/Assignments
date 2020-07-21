import React from 'react'
import {Marker} from 'react-map-gl';

export default function MapMarker({value}) {
    return (
        <div>
            <Marker latitude={(value.lat)?parseFloat(value.lat):19} longitude={(value.lng)?parseFloat(value.lng):72}>
                        <span className="marker-button" onClick={(e)=>{
                            e.preventDefault();
                            // this.setSelectedTrack(item);
                        }}>
                        <img src="/Map/Tracks/ownship/ownship.png" alt="Track" width="20rem"></img>
                    </span>
                </Marker>
        </div>
    )
}
