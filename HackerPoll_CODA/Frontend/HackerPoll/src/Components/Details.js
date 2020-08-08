import React, { Component } from 'react'
import {HackerConsumer} from './Elements/Context'
import {Link} from 'react-router-dom'
import {NavButton} from './Elements/Button'


export default class Details extends Component {
    render() {
        return (
            <HackerConsumer>
                {(value)=>{
                    const {hackerId,solvedChallenges,expertLevel,expertIn,image,info,hackerName} = value.detailProduct;
                    return(
                        <div className="container py-5">
                            <div className="row">
                                <div className="col-10 mx-auto text-center text-slanted text-blue my-5">
                                    <h1>{hackerName}</h1>
                                </div>
                            </div>
                            <div className="row">
                                <div className="col-lg-6 mx-auto col-md-6 col-sm-12 my-3">
                                    <img src={image} className="img-fluid" alt={hackerName}/>
                                </div>
                                <div className="col-lg-6 mx-auto col-md-6 col-sm-12 my-3 text-capitalize">
                                    
                                <h2>Hacker ID : {hackerId}</h2>
                                <h4 className="text-title text-text-uppercase text-muted mt-3 mb-2">
                                Level : <span className="text-text-uppercase">{expertLevel}/5</span>
                                </h4>                                
                                <h4 className="text-blue">
                                    <strong>
                                        Solved Challenges: {solvedChallenges}
                                    </strong>
                                </h4>
                                <p className="text-capitalize font-font-weight-bold mt-3 mb-2">
                                    Expert In :
                                </p>
                                {Object.keys(expertIn).map(key=>{
                                    return <div key={key} className="text-muted lead row"><span className="col-md-3">{key} : </span><span className="col-md-9">{expertIn[key]}/5</span></div>
                                    })
                                }

                                    <div>
                                        <Link to="/">
                                            <NavButton>
                                                Back to Dashboard
                                            </NavButton>
                                        </Link>
                                        <NavButton cart disabled={value.hasDoneVoting?true:false} onClick={()=>{value.voteNow(hackerId)}}>
                                        {value.hasDoneVoting?(<p className="text-capitalize mb-0" disabled>You Voted</p>):(<i className="fas fa-poll"></i>)}
                                        </NavButton>
                                    </div>
                                </div>
                            </div>
                        </div>
                    )
                }}
            </HackerConsumer>
        )
    }
}
