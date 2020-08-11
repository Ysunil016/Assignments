import React, { Component } from 'react'
import {detailProduct,storeProducts} from '../../Resources/data'

const HackerContext = React.createContext();
//Provider

//Consumer

class HackerProvider extends Component {
    state = {
        products:[],
        hasDoneVoting:false,
        detailProduct:detailProduct,
    }
    componentDidMount(){
        this.setProduct();
    }

    setProduct = ()=>{

        fetch('http://localhost:8080/v1/coda/hasVoted')
        .then(res => res.json())
        .then((data) => {
          this.setState({ hasDoneVoting: data })
          fetch('http://localhost:8080/v1/coda/getAllHackers')
          .then(res => res.json())
          .then((data) => {
            this.setState({ products: data })
          })   
        })
        // this.setState(()=>{
        //     return {products:tempProducts}
        // })
    }

    getItemById = (id)=>{
        return this.state.products.find(item=> (item.id === id))
    }

    handleDetail = (id)=>{
        console.log(id);
        fetch('http://localhost:8080/v1/coda/getHacker/'+id)
        .then(res => res.json())
        .then((data) => {
            console.log(data)
            this.setState(()=>{
                return {detailProduct:data}
            })
        })
        
    }
    voteNow = (id)=>{
        fetch('http://localhost:8080/v1/coda/voteToHacker/'+id)
        .then(res => res.json())
        .then((data) => {
            console.log(data)
            this.setState(()=>{
                return {detailProduct:data}
        })
        this.setProduct()
        })
        // const tempProducts = [...this.state.products]
        // const index = tempProducts.indexOf(this.getItemById(id))
       
        // const product = tempProducts[index]
        // product.inCart = true;
        // product.count = 1;
        // const price = product.price;
        // product.total = price*product.count;
       
        // this.setState(()=>{
        //     // return {products:tempProducts,cart:[...this.state.cart,product]}
        // },()=>{
        //     this.addTotals()
        // })
    }

    render() {
        return (
            <HackerContext.Provider value={{
                ...this.state,
                handleDetail:this.handleDetail,
                voteNow:this.voteNow,
            }}>
                {this.props.children}
            </HackerContext.Provider>
        )
    }
}

const HackerConsumer = HackerContext.Consumer

export {HackerProvider,HackerConsumer}