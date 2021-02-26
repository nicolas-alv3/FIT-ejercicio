/* eslint-disable react/jsx-props-no-spreading */
import React from 'react';
import './App.css';
import 'semantic-ui-css/semantic.min.css'
import Home from './components/Home';

export const CartContext = React.createContext(null);
export const CartUpdaterContext = React.createContext(null);

function App() {
  const [cart, setCart] = React.useState([]);
  return (
        <Home cart={cart} setCart={setCart}/>
  );
}

export default App;