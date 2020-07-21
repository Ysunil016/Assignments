import React from 'react'

export default function Scale({lat,lng,zoom}) {
    return (
    <div className="sidebarStyle">
        <div>Lat: {lat} </div>
        <div>Lng: {lng} </div>
        <div>Zoom: {zoom}</div>
    </div>
    )
}


