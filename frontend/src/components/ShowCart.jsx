import React, {useEffect} from 'react'
import { Button, Header, Modal,Icon, List } from 'semantic-ui-react'
import API from '../service/api';
import WithFeedback from './Feedback';

function ShowCart(props) {
  const [open, setOpen] = React.useState(false)
  const [simulation,setSimulation] = React.useState("")
  const [date,setDate] = React.useState("")

  useEffect(() => {
    const body ={
      products : getProductsForBody(),
      clientID:10,
      date
    }
    console.log(body)
    API.post("/simulateSell",body)
      .then((res) => {
        setSimulation(res);
      })
      .catch((e) => console.log(e));
  }, [props.cart]);

  const getProducts = (item) => {
    let res = [];
    for (let step = 0; step < parseInt(item.amount); step++) {
      res = res.concat({
        name:item.product.name,
        price:item.product.price,
        description : item.product.description
      })
    }
    return res;
  }

  const getProductsForBody = () =>  props.cart.map(i => getProducts(i)).reduce((acc,current) => acc.concat(current),[])

  const postCart = () => {
    const body = {
      products : getProductsForBody(),
      date: date,
      owner:{ carts:[]}
    }
    API.post("/cart",body)
    .then( ()=> props.successFeedback('Se ha realizado la compra'))
    .catch( e => props.errorFeedback('Hubo un error al vender'));
  }
  const renderItem = (item) => {
    return <List.Item>
          <b>
          <span style={{color:"blue", marginRight:"20px"}}>
            {item.product.name} 
          </span>
          <Icon name="arrow right" />
          <span style={{color:"gray", marginRight:"20px"}}>
            ${item.amount * item.product.price}
          </span>
          <span style={{color:"green", marginRight:"20px"}}>
            {item.amount} u.
          </span>
          <Icon name="delete" color="red" onClick={() => props.setCart(prevCart => prevCart.filter(e => e.name === item.product.name))} />
          </b>
      </List.Item>
  }

  return (
    <Modal
      size="small"
      onClose={() => setOpen(false)}
      onOpen={() => setOpen(true)}
      open={open}
      trigger={<Icon name="cart" size="big" color="red"/>}
    >
      <Modal.Header>Tu carrito</Modal.Header>
      <Modal.Content>
        <Modal.Description>
          <Header>Producto</Header>
          <input type="date" value={date} onChange={ e => setDate(e.target.value)}/>
          <b>Elegir fecha, hay descuento todos los lunes!</b>
          <List divided bulleted>
              {props.cart.map(item=> renderItem(item))}
          </List>
          <h2>Total:<del style={{color:"gray",fontSize:"14pt"}}>${simulation.priceWithoutDiscount}</del> ${simulation.price}</h2>
          <h3>Ahorraste ${simulation.priceWithoutDiscount - simulation.price}</h3>
        </Modal.Description>
      </Modal.Content>
      <Modal.Actions>
        <Button color='black' onClick={() => setOpen(false)}>
          Cancelar
        </Button>
        <Button
          content="Finalizar"
          labelPosition='right'
          icon='checkmark'
          onClick={() => postCart()}
          positive
        />
      </Modal.Actions>
      {props.renderError}
      {props.renderSuccess}
    </Modal>
  )
}

export default WithFeedback(ShowCart);