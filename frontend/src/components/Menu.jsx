import React from 'react'
import { Menu,Input } from 'semantic-ui-react';
import ShowCart from './ShowCart';
import "../style/home.css";

export default function NavBar (props) {
    return (
      <Menu stackable className="navbar">
        <Menu.Item>
          <h2>Tienda FIT</h2>
        </Menu.Item>

        <Menu.Item
          name='Clientes'
        >
          Clientes
        </Menu.Item>

        <Menu.Item
          name='Ofertas'
        >
          Ofertas
        </Menu.Item>

        <Menu.Item >
            <Input className='icon' icon='search' placeholder='Search...' />
        </Menu.Item>
        <Menu.Item
          name='sign-in'
          icon
          position="right"
        >
          <ShowCart cart={props.cart} setCart={props.setCart}/>
        </Menu.Item>
      </Menu>
    )
  }