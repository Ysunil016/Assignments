import React, { Component } from 'react'
import Product from './Product'
import Title from './Elements/Title'
import {storeProducts} from '../Resources/data'

import {HackerConsumer} from './Elements/Context'

export default class ProductList extends Component {
    


    state={
        product:storeProducts
    }
    render() {
        return (
            <React.Fragment>
                <div className="py-5">
                    <div className="container">
                        <Title name="Hackers" title=""></Title>
                        <div className="row">
                        <HackerConsumer>
                            {(value)=>{
                                return value.products.map( product => {
                                    return <Product key={product.hackerId} product={product}></Product>
                                })
                            }}
                        </HackerConsumer>
                        </div>
                    </div>
                </div>
            </React.Fragment>
        )
    }
}
