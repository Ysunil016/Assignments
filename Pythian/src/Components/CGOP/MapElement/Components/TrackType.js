import React from 'react'

export default function Sidebar({item}) {
    return (
    <div>
        <input type="checkbox" value={item.name} id="chk4" />
        <span className="ml-1 p-1">{item.name}</span>
        
    </div>
            )
}
