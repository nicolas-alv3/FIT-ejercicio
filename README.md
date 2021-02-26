# Ejercicio

## Para correr el front
- `cd front`
- `npm install`
- `npm start`

Utilicé la versión 10 de node para el desarrollo, por lo que quiza debas usar el comando

- `nvm use 10`

## Para correr el back
- `cd back`
- `mvn spring-boot:run`
- es necesario tener instalado MYSQL server versión 5 y un usuario root con contraseña password.

## Aclaraciones del modelo

Tomé en cuenta que
  > Si el cliente <b> en un determinado mes </b>, realizó compras por más de $10.000, pasa a ser
  considerado VIP en su próxima compra se le aplican $2000 pesos de descuento, solo si
  supera los $4000.

Con "Un determinado mes" se refiere al corriente mes, es decir el descuento se aplicará si realizo compras por mas de $10000 en este mes.

No entendí bien si el usuario en algun momento nota que su carrito es promocionable o no, tomé en cuanta que en algun momento puede notarlo, por lo que separé en dos clases a los carritos.

En el front se puede elegir la fecha para verificar las promociones, todos los lunes hay descuento por fecha especial

Utilicé postman para hacer los request, se pueden probar con:

- POST /cart 
> {
    "products" : [
        { "name" : "pitusas", "price" : 50.5, "description" : " muyy buena galletita"},
        { "name" : "pizza napolitana", "price" : 500.5, "description" : " Con mucha muzzarella"}
    ],
    "owner" : { "carts" : []}
}

- POST /simulateSell 
> {
    "products" : [{
        "id": 1,
        "price": 50.5,
        "description": "Mas ricas que las de limon,bastante mas",
        "name": "Pitusas de vainilla"
    },{
        "id": 1,
        "price": 50.5,
        "description": "Mas ricas que las de limon,bastante mas",
        "name": "Pitusas de vainilla"
    },{
        "id": 1,
        "price": 50.5,
        "description": "Mas ricas que las de limon,bastante mas",
        "name": "Pitusas de vainilla"
    },{
        "id": 1,
        "price": 50.5,
        "description": "Mas ricas que las de limon,bastante mas",
        "name": "Pitusas de vainilla"
    }],
    "clientID":10
}
