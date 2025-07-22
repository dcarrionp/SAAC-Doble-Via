# App SAAC con Text-to-Speech (TTS) - Documentación Completa

Esta aplicación SAAC (Sistema Aumentativo y Alternativo de Comunicación) ahora utiliza **Text-to-Speech (TTS)** integrado, eliminando la necesidad de archivos de audio pregrabados.

## ✅ Funcionalidades Implementadas

### 🎯 Pantallas Completadas:
1. **Pantalla Principal (Board)** - Navegación y botones "Sí/No" con TTS
2. **"Me Duele" (Dolor)** - 7 opciones de dolor con frases completas
3. **"Quiero" (Quiero)** - 6 necesidades básicas 
4. **"Estoy" (Estoy)** - 6 emociones diferentes
5. **"Saludos" (Saludos)** - 6 expresiones de cortesía
6. **"Sobre mí" (SobreMi)** - 6 categorías de información personal

### 🔊 Características del TTS:
- **Idioma**: Español configurado automáticamente
- **Velocidad**: Reducida a 0.8x para mejor comprensión
- **Tono**: Normal (1.0)
- **Fallback**: Si español no está disponible, usa idioma por defecto del sistema
- **Gestión de memoria**: TTS se cierra correctamente al destruir actividades

## 📱 Frases por Pantalla

### Pantalla Principal:
- "Sí" / "No"

### Me Duele:
- "Me duele la cabeza"
- "Me duelen los dientes" 
- "Me duele el estómago"
- "Me duele la espalda"
- "Me duele la garganta"
- "Me duelen los huesos"
- "Me duelen los músculos"

### Quiero:
- "Quiero comer"
- "Quiero beber"
- "Quiero jugar"
- "Quiero dormir"
- "Quiero ir al baño"
- "Quiero ayuda"

### Estoy:
- "Estoy feliz"
- "Estoy triste"
- "Estoy enojado"
- "Estoy asustado"
- "Estoy cansado"
- "Estoy enfermo"

### Saludos:
- "Hola"
- "Adiós"
- "Buenos días"
- "Buenas noches"
- "Gracias"
- "Perdón"

### Sobre mí (Personalizable):
- "Mi nombre es Juan" *(editable)*
- "Tengo 10 años" *(editable)*
- "Esta es mi familia"
- "Esta es mi casa"
- "Esta es mi escuela"
- "Estos son mis gustos"

## 🔧 Ventajas del TTS vs Archivos de Audio

### ✅ Beneficios:
- **Sin archivos de audio**: No necesitas grabar ni almacenar MP3/WAV
- **Menor tamaño de app**: Significativamente menos espacio de almacenamiento
- **Personalización fácil**: Cambiar texto es simple, no requiere regravar
- **Múltiples voces**: El usuario puede elegir diferentes voces del sistema
- **Soporte multiidioma**: Fácil cambio de idioma
- **Actualizaciones simples**: Modificar frases sin recursos adicionales

### 🎛️ Configuración Técnica:
- **Clase TTSHelper**: Maneja toda la funcionalidad TTS
- **Inicialización automática**: TTS se configura al abrir cada pantalla
- **Gestión de errores**: Fallbacks para idiomas no soportados
- **Limpieza de memoria**: TTS se libera correctamente

## 🚀 Navegación
- **Botones de regreso**: Cada pantalla tiene navegación al tablero principal
- **Botón físico "Atrás"**: También navega correctamente
- **Navegación segura**: Referencias a botones opcionales con null-safety

## 🎨 Recursos Visuales Necesarios

Solo necesitas las imágenes/iconos en `app/src/main/res/drawable/`:

### Iconos principales (ya existen):
- `ic_si_foto`, `ic_no_foto`, `ic_meduele_foto`, etc.

### Iconos para nuevas pantallas:
- `ic_comer`, `ic_beber`, `ic_jugar`, `ic_dormir`, `ic_bano`, `ic_ayuda`
- `ic_feliz`, `ic_triste`, `ic_enojado`, `ic_asustado`, `ic_cansado`, `ic_enfermo`
- `ic_hola`, `ic_adios`, `ic_buenos_dias`, `ic_buenas_noches`, `ic_gracias`, `ic_perdon`
- `ic_mi_nombre`, `ic_mi_edad`, `ic_mi_familia`, `ic_mi_casa`, `ic_mi_escuela`, `ic_mis_gustos`

## 🛠️ Personalización

### Para personalizar información personal:
Edita el archivo `sobremi_board.kt`, líneas 18-19:
```kotlin
R.id.imgMiNombre to "Mi nombre es [NOMBRE]",
R.id.imgMiEdad to "Tengo [EDAD] años",
```

### Para agregar más frases:
1. Agrega el botón al layout correspondiente
2. Añade la entrada al `textMap` en la actividad
3. El TTS funcionará automáticamente

## 📋 Estado del Proyecto
- ✅ **Compilación**: Sin errores
- ✅ **TTS**: Completamente funcional
- ✅ **Navegación**: Funcional entre todas las pantallas
- ✅ **Layouts**: Completos y responsivos
- ✅ **Gestión de memoria**: Optimizada
- 🎯 **Listo para usar**: Solo faltan las imágenes/iconos

Tu app SAAC está ahora **funcionalmente completa** y lista para ayudar a personas con dificultades de comunicación!
