# sound-synth-example

Sintetizador de audio en Java que genera y reproduce diferentes tipos de ondas sonoras (seno, cuadrada, triángulo y diente de sierra) con frecuencia y duración configurables.

## Estructura del proyecto

```
sound-synth-example/
└── src/
    ├── Main.java             # Punto de entrada y demostración del sintetizador
    ├── SoundSynth.java       # Clase abstracta base del sintetizador
    └── SoundSynthSine.java   # Implementación de onda sinusoidal
```

## Componentes

### `SoundSynth.java` — Clase abstracta base

Clase abstracta que define el contrato del sintetizador de audio.

**Método abstracto:**

```java
public abstract void makeSound(int numberOfTimesFullFuncPerSec, int durationMs)
        throws LineUnavailableException
```

| Parámetro                    | Tipo  | Descripción                                   |
|------------------------------|-------|-----------------------------------------------|
| `numberOfTimesFullFuncPerSec`| `int` | Frecuencia en Hz (ciclos por segundo)         |
| `durationMs`                 | `int` | Duración del sonido en milisegundos           |

---

### `SoundSynthSine.java` — Onda sinusoidal

Implementación concreta de `SoundSynth` que genera una onda sinusoidal usando la API de sonido de Java (`javax.sound.sampled`).

**Detalles técnicos:**

- **Frecuencia de muestreo:** 44 100 Hz (calidad CD)
- **Formato de audio:** PCM con signo, 16 bits, mono
- **Rango de amplitud:** −32 767 a 32 767 (entero de 16 bits con signo)
- **Fórmula:** `Math.sin(2 * π * phase)` (siendo `phase` la posición en el ciclo, de 0.0 a 1.0)

El valor resultante se convierte a un entero de 16 bits y se escribe byte a byte en el `SourceDataLine` del sistema de audio.

---

### `Main.java` — Punto de entrada

Clase de demostración que instancia `SoundSynthSine` y reproduce una secuencia de cuatro sonidos sinusoidales variando frecuencia y duración:

| # | Tipo | Frecuencia | Duración |
|---|------|-----------|---------|
| 1 | SINE | 440 Hz    | 1000 ms |
| 2 | SINE | 440 Hz    | 200 ms  |
| 3 | SINE | 700 Hz    | 500 ms  |
| 4 | SINE | 440 Hz    | 1000 ms |

## Compilación y ejecución

Requiere **Java 8 o superior** (no tiene dependencias externas; usa únicamente la API estándar del JDK).

```bash
# Compilar
javac -d out src/SoundSynth.java src/SoundSynthSine.java src/Main.java

# Ejecutar
java -cp out Main
```
