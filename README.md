# sound-synth-example

Sintetizador de audio en Java que genera y reproduce ondas sonoras usando una jerarquía de clases basada en herencia, con frecuencia y duración configurables.

## Estructura del proyecto

```
sound-synth-example/
└── src/
    ├── Main.java             # Punto de entrada y demostración del sintetizador
    ├── SoundSynth.java       # Clase abstracta base para los sintetizadores de audio
    └── SoundSynthSine.java   # Implementación concreta: onda sinusoidal
```

## Componentes

### `SoundSynth.java` — Clase abstracta base

Clase abstracta que define el contrato común para todos los sintetizadores de audio.

**Método abstracto:**

```java
public abstract void makeSound(int numberOfTimesFullFuncPerSec, int durationMs)
        throws LineUnavailableException
```

| Parámetro                    | Tipo  | Descripción                                   |
|------------------------------|-------|-----------------------------------------------|
| `numberOfTimesFullFuncPerSec`| `int` | Frecuencia en Hz (ciclos por segundo)         |
| `durationMs`                 | `int` | Duración del sonido en milisegundos           |

Cada subclase implementa este método para generar un tipo de onda específico.

---

### `SoundSynthSine.java` — Onda sinusoidal

Implementación concreta de `SoundSynth` que sintetiza y reproduce una onda sinusoidal usando la API de sonido de Java (`javax.sound.sampled`).

**Detalles técnicos:**

- **Frecuencia de muestreo:** 44 100 Hz (calidad CD)
- **Formato de audio:** PCM con signo, 16 bits, mono
- **Rango de amplitud:** −32 767 a 32 767 (entero de 16 bits con signo)

**Fórmula de la onda (siendo `phase` la posición en el ciclo, de 0.0 a 1.0):**

| Onda  | Fórmula                   |
|-------|---------------------------|
| SINE  | `Math.sin(2 * π * phase)` |

El valor resultante se convierte a un entero de 16 bits y se escribe byte a byte en el `SourceDataLine` del sistema de audio.

---

### `Main.java` — Punto de entrada

Clase de demostración que instancia `SoundSynthSine` y reproduce una secuencia de cuatro sonidos variando frecuencia y duración:

| # | Tipo  | Frecuencia | Duración |
|---|-------|------------|---------|
| 1 | SINE  | 440 Hz     | 1000 ms |
| 2 | SINE  | 440 Hz     | 200 ms  |
| 3 | SINE  | 700 Hz     | 500 ms  |
| 4 | SINE  | 440 Hz     | 1000 ms |

> **Nota:** Las implementaciones para ondas cuadrada (`SoundSynthSquare`), triangular (`SoundSynthTriangle`) y diente de sierra (`SoundSynthSawtooth`) están pendientes de desarrollo.

## Compilación y ejecución

Requiere **Java 8 o superior** (no tiene dependencias externas; usa únicamente la API estándar del JDK).

```bash
# Compilar
javac -d out src/SoundSynth.java src/SoundSynthSine.java src/Main.java

# Ejecutar
java -cp out Main
```
