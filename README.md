# **🛡️ Recuperatorio del 1er Parcial de Programación con Objetos II \- Com. 3 (60 Minutos).**

\[\!IMPORTANTE\]  
👀 Leer todo antes de comenzar a resolver.

## **⚙️ Datos necesarios y obligatorios a completar.**

* **APELLIDO, NOMBRE**:  GRISAFI Marilin
* **COMISIÓN**:  3
* **DNI**: 36074397

## **📝 Consideraciones Iniciales y Criterio de Evaluación.**

Se evaluará cada solución prestando especial atención a:

* **Pautas obligatorias** correctamente cumplidas.  
* **Aplicación de conceptos**: Patrones de diseño, reificación, manejo de excepciones y test unitarios (**GWT** y **AAA**).  
* El código entregado debe tener los tests suficientes que garanticen el correcto funcionamiento de la solución propuesta (*esperado 75%+*).  
* La solución debe aplicar patrones de diseño apropiados para la problemática. **El uso inadecuado o forzado de un patrón descalifica el examen automáticamente**.  
* No se aceptan entregas fuera de plazo ni mal subidas al repositorio.  
* Las entregas que tengan un solo commit o no reflejen el progreso del proceso de solución serán desaprobadas.

## **📌 Pautas obligatorias para la entrega.**

Utilizaremos un sistema de 3 'checkpoints' obligatorios, a saber:

* ⚠️ El código entregado debe compilar obligatoriamente. **Una entrega que no compila queda desaprobada automáticamente**.  
* **Checkpoint 1**: Clonar el repositorio, modificar este archivo registrando sus datos personales y hacer un primer push.  
* **Checkpoint 2**: Push antes de escribir el primer test.  
* **Checkpoint 3**: Push al final de la entrega, al terminar todos sus tests.

# **🚨 Sistema de Asignación de Alertas SIEM 🌐.**

El departamento de ciberdefensa necesita un núcleo rápido para su sistema SIEM (Security Information and Event Management). El objetivo es asignar alertas de red a los analistas del SOC según su perfil, añadiendo previamente módulos de inteligencia a la alerta.

# **🕵️‍♂️ Criterios de Triaje.**

Cada analista tiene configurado un **criterio de triaje** que indica qué tipo de alertas procesa. Los criterios que el sistema debe soportar son:

* 🟢 **Analista Nivel 1**: Puede procesar cualquier alerta. Es el criterio por defecto para los analistas junior al ingresar al SOC.  
* 🔴 **Especialista Crítico**: Solo procesa alertas cuya *severidad base* sea estrictamente mayor a 75\.

# **⚠️ Alertas de Seguridad.**

Las alertas de red tienen definido:

* 📛 **Código identificador** (ej: "CVE-2024-123")  
* 📊 **Severidad base** (un número entero)

Por ahora solo existen alertas estándar (podemos llamarle simplemente *Alerta*), pero el diseño debe soportar que surjan nuevos tipos en el futuro.

# **➕ Módulos de Inteligencia (Threat Intel).**

El sistema enriquece una alerta agregándole módulos de inteligencia antes de entregarla al analista. Cada módulo incrementa la severidad total de la alerta de forma acumulativa. Se conocen los siguientes:

* 📍 **Geolocalización IP** → suma \+10 a la severidad total.  
* 🦠 **Análisis Sandbox** → suma \+30 a la severidad total.

El sistema debe quedar preparado para incorporar nuevos módulos de inteligencia en el futuro sin modificar el código existente.

# **👥 Analistas del SOC.**

De los analistas sólo nos interesa conocer:

* 🪪 **Legajo** (nunca puede modificarse).  
* 🎯 **Criterio de triaje** que utilizan. Cada analista puede cambiar su criterio en cualquier momento según las necesidades del turno.

Además, cada analista lleva registro de las **alertas procesadas** 📜. Cada analista debe poder informar la lista de sus alertas procesadas, incluyendo la severidad total calculada de cada una.

# **🖥️ El Motor SIEM.**

El motor SIEM es quien posee la lista de **alertas pendientes** 📒. Se permite agregar nuevas alertas.  
Cuando el SIEM ejecuta la acción de **asignar alerta a un analista** ocurre lo siguiente:

1. Busca en la cola la **primera alerta** adecuada según el criterio del analista.  
2. A esa alerta encontrada le agrega **siempre** el módulo de *Geolocalización IP*.  
3. Finalmente, esa alerta enriquecida pasa a registrarse en el historial del analista y es removida de la lista de pendientes.

# **❌ Situaciones Excepcionales.**

* AnalistaSinCriterioException: Si un analista intenta recibir una asignación sin tener un criterio de triaje configurado.  
* AlertaInvalidaException: No se puede crear una alerta con severidad negativa o código vacío.

# **🏗️ Restricciones de Diseño.**

* No se permite modificar las alertas base originales cada vez que se les agregan módulos de inteligencia.  
* No se permite el uso de estructuras condicionales (if/switch) para despachar comportamiento polimórfico.  
* Las responsabilidades deben estar correctamente distribuidas entre los objetos del sistema.