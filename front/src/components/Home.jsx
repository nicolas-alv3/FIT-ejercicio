import React, { useEffect } from 'react';
import Menu from './Menu';
import { Container } from "semantic-ui-react";
import ProductCard from './ProductCard';
import API from '../service/api';

export default function Home(props){

  const [products, setProducts] = React.useState([]);


  useEffect(() => {
    API.get("/products")
      .then((res) => {
        setProducts(res);
      })
      .catch((e) => console.log(e));
  }, [products.length]);

    const renderProducts = () => products.map((p)=> 
      <div style={{margin:"20px"}}>
          <ProductCard 
            product={p}
            setCart={props.setCart}
            callback= {(product,amount) => props.setCart(prevCart => prevCart + {product,amount})}
          />
      </div>)

    return(
        <div>
            <Menu cart={props.cart} setCart={props.setCart} />
            <Container>
            <h1>Productos</h1>
            <hr></hr>
            <div style={{display:"flex", justifyContent:"space-around", flexFlow:"row wrap"}}>
              {renderProducts()}
            </div>
            </Container>
        </div>
    );
}