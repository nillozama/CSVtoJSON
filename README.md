
# CSV to JSON

Este reto se basa en crear una función que convierta un archivo CSV y devuelva un JSON con los datos. En esta aplicación cargaremos un archivo CSV, lo leeremos y extraeremos los datos del archivo en un objeto (para lo que he creado la clase Product). Luego, con una petición GET devolveremos el objeto, más bien un array de objetos y obtendremos un JSON.

## Arquitectura

Utilizo una estructura básica con capa modelo entidad, servicio y controlador.



## End-points
Para cargar el archivo utilizamos el método POST en la siguiente dirección:

**http://localhost:9009/file/upload/**

En el body de POSTMAN, en form-data añadimos el archivo que queramos cargar, en nuestro caso un CSV con las columnas name, brand, price y stock correspondientes a los atributos de nuestra clase Product. No es necesario que estén las 4 columnas, puede leer una sola columna y devolver el objeto.

Para recibir respuesta utilizamos el método GET en la siguiente dirección:
**http://localhost:9009/file/convert/NOMBRE_ARCHIVO.csv**

Como ejemplo pedimos convertir el archivo inputTest4.csv-> http://localhost:9009/file/convert/inputTest4.csv

## Resultado
Al hacer la petición nos retorna un JSON
