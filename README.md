# Sistema de Acceso Facial - Aplicación Móvil (Android)

Aplicación cliente para Android basada en **WebView** que integra el sistema de control de asistencia por reconocimiento facial. La aplicación permite acceder al portal alojado en Vercel, gestionando permisos de cámara nativos en Android y conectándose a los servicios en la nube (Render + Supabase).

---

## 📱 Descripción del Proyecto

Este repositorio contiene únicamente el **módulo de la aplicación móvil nativa para Android**. La app actúa como un cliente móvil optimizado para interactuar con la interfaz web y realizar la captura de rostro desde la cámara integrada del dispositivo o emulador.

* **Frontend Web alojado en:** Vercel (`https://acceso-facial.vercel.app/`)
* **Backend de API REST en:** Render (Python/Flask)
* **Base de Datos:** Supabase (PostgreSQL)

> **Repositorio Principal del Sistema:**  
> Para ver el código fuente completo del Backend (Flask), scripts de Base de Datos y la versión Web original, consulta el repositorio principal:  
> [👉 Repositorio del Sistema de Acceso Facial - Backend y Web](https://github.com/CodeWithAlli/Acceso_Facial.git)

---

## 🛠️ Tecnologías Utilizadas

* **Lenguaje:** Java 
* **IDE:** Android Studio
* **Componente Principal:** Android `WebView` con `WebChromeClient` para gestión de cámara nativa.
* **Manejo de Permisos:** Android Camera Permission & Internet Permission.

---

## 🚀 Requisitos y Configuración Local

### Requisitos previos
* Android Studio (versión Iguana, Jellyfish o posterior).
* JDK 11 o superior.
* Dispositivo móvil Android o emulador (ej. BlueStacks, AVD) con soporte de cámara/webcam.

## 📁 Estructura del Módulo Android

Acceso_Facial_Android/
* ├── app/
* │   ├── src/
* │   │   └── main/
* │   │       ├── java/com/tuapp/accesofacial/
* │   │       │   └── MainActivity.java       # Control de WebView y permisos
* │   │       ├── res/
* │   │       │   └── layout/
* │   │       │       └── activity_main.xml   # Vista con pantalla completa WebView
* │   │       └── AndroidManifest.xml         # Permisos de red y cámara
* ├── build.gradle                            # Configuración de compilación
* └── README.md

## 🔒 Consideraciones de Seguridad
* No se almacenan credenciales ni claves privadas en el código nativo de la app.
* La comunicación con Render y Supabase se gestiona de forma segura a través de HTTPS.
