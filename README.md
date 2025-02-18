# svr06-bussines-amq-streams

Este arquetipo presenta ejemplos de como conetarse a AMQ Streams
- [x] Endpoints REST
- [x] Producir mensajes
- [x] Consumir mensajes
- [x] Procesar mensajes
- [x] Recibir y producir JSON
- [x] Despliegue en ocp / Comandos OC
- [x] Carpeta Openshift
- [x] Parametrizacion y Configuracion
- [x] Configuracion de Logs 
- [x] Manejo de excepciones
- [x] Junit Test

De una forma sencilla para que al equipo al cual va dirigido, pueda basar su desarrollo en el.

# Tecnologías utilizadas
- Quarkus: 3.2
- Java: 17

# Que es AMQ Streams
RH-AMQ Streamses una plataforma de mensajería empresarial basada en Apache ActiveMQ y respaldada por Red Hat, que permite la comunicación y el intercambio de datos entre aplicaciones y sistemas en una organización. Ofrece soporte para varios protocolos de comunicación, escalabilidad, alta disponibilidad y características de seguridad, además de herramientas de gestión y soporte técnico, lo que lo convierte en una solución completa para la gestión de mensajes en entornos empresariales.

# Configuración
La configuración de la aplicación se encuentra en el archivo application.properties en la carpeta resources. Aquí se pueden ajustar diversos aspectos, como la configuración de la base de datos, los logs y otras propiedades específicas de Quarkus.


# Integracion con Quarkus y AMQ

La integración de Red Hat AMQ Streamscon Quarkus, un framework de desarrollo de aplicaciones Java diseñado para la nube y nativo de Kubernetes, se logra mediante el uso de extensiones y bibliotecas específicas. A continuación, te proporciono una visión general de cómo funciona la integración:

Uso de la Extensión Quarkus AMQP: Para integrar Red Hat AMQ Streamscon una aplicación Quarkus, puedes utilizar la extensión "quarkus-amqp" proporcionada por Quarkus. Esta extensión facilita la comunicación entre tu aplicación Quarkus y un servidor AMQP (como RH-AMQ Broker) utilizando el protocolo AMQP (Advanced Message Queuing Protocol).

Configuración de Propiedades: Debes configurar las propiedades específicas de la extensión "quarkus-amqp" en el archivo de configuración de tu aplicación Quarkus. Esto incluye detalles como la URL de conexión al servidor AMQP (que apuntaría a tu instancia de RH-AMQ Broker), credenciales de autenticación, y configuración de colas y temas.

Uso de Anotaciones: Puedes utilizar anotaciones específicas de Quarkus y AMQP en tu código para definir productores y consumidores de mensajes. Por ejemplo, puedes utilizar @Outgoing para definir un productor que envía mensajes a un tema o @Incoming para definir un consumidor que recibe mensajes de una cola.

Implementación de Lógica de Mensajes: En tu aplicación Quarkus, implementa la lógica de mensajes dentro de los métodos anotados con @Incoming o @Outgoing. Esto te permitirá enviar y recibir mensajes desde y hacia RH-AMQ Streamsde manera eficiente.

Despliegue en Kubernetes: Si estás desarrollando una aplicación nativa de Kubernetes con Quarkus, puedes empaquetar tu aplicación en contenedores y desplegarla en tu clúster de Kubernetes. Asegúrate de que la configuración de conexión a RH-AMQ Streamssea adecuada para el entorno de Kubernetes.

Monitoreo y Mantenimiento: RH-AMQ Streamsproporciona herramientas de monitoreo y administración que te permiten supervisar el rendimiento y el estado de tu sistema de mensajería. Esto es útil para garantizar que la integración funcione sin problemas y para solucionar problemas si surgen.

# Manejo de logs
La configuración de logs se encuentra en el archivo application.properties. Aquí se pueden ajustar los niveles de log para diferentes paquetes y clases, así como configurar la salida de los logs.


# Manejo de excepciones
La aplicación muestra ejemplos de cómo manejar excepciones utilizando Camel. Se pueden agregar manejadores de excepciones personalizados en las rutas para capturar y manejar excepciones específicas según sea necesario.

# Pruebas JUnit 
La aplicacion muestra ejemplos de como testear metodos y funcionalidades con Junit5 y rest-assured.

# Configuraciones en carpeta OpenShift
La carpeta openshift contiene el archivo route-config.yaml, que proporciona configuraciones de rutas para OpenShift. Estas configuraciones se pueden utilizar para exponer los servicios desde OCP.

# Comandos OC 
Estos comandos sirven para desplegar el arquetipo en openshift desde la consola del bastion.

- oc new-build --binary=true --name=amq --image-stream=java:latest
- oc set env bc/amq OPENSHIFT_AMQ_HOST="" OPENSHIFT_AMQ_PORT="" OPENSHIFT_AMQ_USER="" OPENSHIFT_AMQ_PASSWORD=""
- oc start-build amq --from-dir=. --follow
- oc new-app amq
- oc expose service/amq

# Comandos compilacion (Local)
A continuación se presentan algunos comandos útiles para utilizar la aplicación:

#### Ejecutar la aplicación en modo de desarrollo:

mvn quarkus:dev
Ejecutar el proyecto en modo desarrollo
./mvnw compile quarkus:dev
Empaquetar y ejecutar la aplicación:

./mvnw package  
java -jar target/quarkus-app/quarkus-run.jar
Crear un ejecutable nativo:

./mvnw package -Pnative
Ejecutar el ejecutable nativo en un contenedor:

./mvnw package -Pnative -Dquarkus.native.container-build=true
