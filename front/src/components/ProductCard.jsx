import React from 'react'
import { Button, Card, Grid, Icon,Image,Label,Popup  } from 'semantic-ui-react'

export default function ProductCard(props){ 
  const [enabled, setEnabled] = React.useState(true);
  const [open, setOpen] = React.useState(false);
  const [added, setAdded] = React.useState(false);
  const [amount, setAmount] = React.useState("");

  const makeCallback = () => {
    props.setCart(prevCart => prevCart.concat({product:props.product,amount}));
    setEnabled(false);
    setOpen(false);
    setAdded(true)
  }

  const handleAmountChanged = (e) => {
    setAmount(e.target.value);
  }
  return(
  <Card style={{ width : "200px",height:"400px"}}>
     <Image src="https://picsum.photos/500" wrapped ui={false} />
    <Card.Content>
      <Card.Header>{props.product.name}</Card.Header>
      <Card.Meta>
        <span className='date'>Nuevo!</span>
      </Card.Meta>
      <Card.Description>
        {props.product.description}
        <h4 style={{color:"green"}}>${props.product.price}</h4>
        {added ? <Label style={{position:"absolute",top:"10px",right:"10px"}} color="red">Agregado</Label> : <div/>}
      </Card.Description>
    </Card.Content>
    <Card.Content extra>
      <Popup
      on='click'
      color="green"
      pinned
      open={open}
      trigger={
        <Button disabled={!enabled} onClick={() => setOpen(true)} icon color="vk" labelPosition='right' >
          Comprar
          <Icon name='cart plus' />
        </Button>
      }
  >
    <Grid>
      <Grid.Row>
        <form>
          <input type="number" value={amount} onChange={(e) => handleAmountChanged(e)} placeholder="¿Cuantos vas a llevar?"/>
          <Button disabled={amount <= 0} color="green" onClick={ () => makeCallback()} icon="check"/>
        </form>
      </Grid.Row>
    </Grid>
  </Popup>
    </Card.Content>
  </Card>
)
}