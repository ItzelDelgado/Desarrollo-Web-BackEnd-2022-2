Autor: Itzel Azucena Delgado Díaz

Requisitos: 

- Tener instalado un servidor con apache (wampserver, xampp, mamp)
- Tener instalado spring tools
- Tener instalado un manejador de base de datos(SQL workbench)
Ejecución: 
- Deberemos importar el proyecto en spring tools 
- Deberemos cargar la base de datos 
- Y ejecutar el servidor 
- Ejecutaremos el proyecto 
- realizar las operaciones pertinentes usando Postman

GET http://localhost:8081/product/category/1

PUT http://localhost:8081/product/1

Body

{
    "product": "XBOX X",
    "gtin": "423GEW2G43",
    "description": "Consola de video juegos sin juegos",
    "price": "12000",
    "stock": "40"
}
