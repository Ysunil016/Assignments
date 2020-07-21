import React, { Component } from 'react'
import styled from 'styled-components'
import TracksSelect from './TrackType'

export default class MapSidebar extends Component {
    
    state = {
        allTracksOptions:[{
            name:"Surface",
            method:null,
        },{
            name:"Air",
            method:null,
        },{
            name:"Sub Surface",
            method:null,
        }],
        selectedTracks:[]
    }
    

    componentDidMount = ()=>{
        this.setState(()=>{
            return {
                allTracksOptions:[{
                    name:"Surface",
                },{
                    name:"Air",
                },{
                    name:"Sub Surface",
                }]
            }
        })
    }

    handleChange = (e)=>{
        console.log(e.target.value);
    }
    render() {
        return (
<MapMenuOptions>

        <button className="openMapSidebar" onClick={this.openMapSidebarNav}><i className="fas fa-bars"></i></button>
            <div id="mapMenuSidebar" className="sidenav">
                <span className="closebtn" onClick={this.closeMapSidebarNav}>&times;</span>
                
                <div className="dropdown">
                        </div>

                    <div className="tracksMenu p-2" onChange={this.handleChange}>
                                    {this.state.allTracksOptions.map((item,index)=>{
                                        return <TracksSelect key={index} item={item}></TracksSelect>
                                    })}
                </div>
                </div>


{/* 
                <div className="tracksMenu p-2" onChange={this.handleChange}>
                    {this.state.allTracksOptions.map((item,index)=>{
                        return <TracksSelect key={index} item={item}></TracksSelect>
                    })}
                </div>       */}
            </MapMenuOptions>
        )
    }


    closeMapSidebarNav = ()=>{
        document.getElementById("mapMenuSidebar").style.width = "0"
    }
    openMapSidebarNav = ()=>{
        document.getElementById("mapMenuSidebar").style.width = "15rem"
    }

}



const MapMenuOptions = styled.div`
.tracksMenu{
    background-color:rgba(0,0,0,0.6);
    z-index:1 !important;
    color:white;
    border-radius:0 0 0.5rem 0;
}
.sidenav {
    height: 100%;
    width: 250px;
    position: fixed; 
    z-index: 1; 
    top: var(--nav_height);
    left: 0;
    background-color: var(--main_blue);
    overflow-x: hidden; 
    padding-top: 60px;
    transition: 0.1s; 
  }
.openMapSidebar{
    position: absolute;
    top: var(--nav_height);
    z-index:1;
    font-size: 2rem;
    background:none;
    border:none
}

  .sidenav .closebtn {
    position: absolute;
    top: 0;
    cursor:pointer;
    right: 25px;
    font-size: 2rem;
    margin-left: 50px;
    z-index:1;
  }
  #mapMenuSidebar{
      width:0;
  }
  
`;