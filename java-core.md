# Java Core Теория

## JVM — список вопросов

### Блок 1 — общая идея JVM

<details>
<summary>Что такое JVM?</summary>

**JVM (Java Virtual Machine)** — это виртуальная машина Java, которая выполняет скомпилированный код (**байткод**) и управляет выполнением Java-программы.

Простыми словами: JVM — это прослойка между Java-кодом и операционной системой.

</details>


<details>
<summary>Зачем нужна JVM?</summary>

JVM нужна для:

**Кроссплатформенности**
- позволяет писать код один раз и запускать его на Windows, Linux и macOS

**Выполнения байткода**
- преобразует Java-байткод в машинные инструкции процессора

**Управления памятью**
- выделяет память под объекты
- очищает ненужную память через Garbage Collector

**Безопасности**
- проверяет код перед запуском
- ограничивает опасные операции

**Оптимизации**
- анализирует работу программы и ускоряет её через JIT-компиляцию

</details>


<details>
<summary>Что делает JVM?</summary>

JVM берет Java-байткод и выполняет его.

Для этого она:

- загружает классы
- проверяет байткод
- выделяет память
- запускает Garbage Collector
- переводит байткод в машинные инструкции

</details>


<details>
<summary>Какие основные функции JVM?</summary>

Основные функции JVM:

**Загрузка классов**
- загрузка классов через ClassLoader

**Верификация**
- проверка байткода на безопасность

**Исполнение кода**
- выполнение байткода через интерпретатор и JIT

**Управление памятью**
- выделение памяти и работа GC

**Управление выполнением**
- обработка исключений
- многопоточность
- динамическое связывание

</details>


<details>
<summary>Чем JVM отличается от JRE и JDK?</summary>

Разница:

**JDK (Java Development Kit)**
- нужен для разработки
- содержит компилятор, инструменты и JRE

**JRE (Java Runtime Environment)**
- нужен для запуска Java-программ
- содержит JVM и библиотеки

**JVM**
- отвечает за выполнение байткода

Схема:

JDK → JRE → JVM

</details>


<details>
<summary>Как происходит запуск Java-программы?</summary>

1. javac компилирует `.java` в `.class`
2. JVM запускается
3. ClassLoader загружает классы
4. выполняется загрузка, линковка и инициализация
5. Execution Engine начинает выполнение программы

</details>


<details>
<summary>Почему Java называют платформенно-независимой?</summary>

Потому что Java-код сначала компилируется не в машинный код, а в универсальный байткод.

Дальше JVM для конкретной ОС преобразует этот байткод в машинные инструкции.

Главные компоненты:

- байткод
- JVM

</details>


### Блок 2 — жизненный цикл программы

<details>
<summary>Что происходит после запуска java Main?</summary>

После запуска:

1. JVM запускается
2. ClassLoader загружает Main.class
3. Выполняется [Loading, Linking и Initialization](#как-jvm-загружает-классы)
4. JVM вызывает:

```java
public static void main(String[] args)
```

После этого начинается выполнение программы.

</details>

---

<details>
<summary>Как JVM загружает классы?</summary>
<a id="как-jvm-загружает-классы"></a>

JVM загружает классы динамически по мере необходимости через ClassLoader.

Процесс состоит из трех этапов:

1. **Loading**
- поиск `.class`
- чтение байткода
- создание объекта `Class`
- загрузка метаданных класса

2. **Linking**

Состоит из:

**Verification**
- проверка байткода

**Preparation**
- выделение памяти для `static` полей
- значения по умолчанию

**Resolution**
- замена символьных ссылок на реальные

3. **Initialization**
- выполнение `static {}`
- присвоение значений `static` полям

</details>

---

<details>
<summary>Что такое ClassLoader?</summary>

ClassLoader — компонент JVM, отвечающий за динамическую загрузку классов в память.

Он:

- ищет .class файл
- читает байткод
- создает объект Class
- загружает метаданные класса

</details>

---

<details>
<summary>Какие ClassLoader существуют?</summary>

Встроенные ClassLoader:

1. Bootstrap ClassLoader

- написан на C++
- загружает java.lang.*, java.util.* и другие базовые классы

2. Platform ClassLoader

- загружает классы платформы Java

3. Application (System) ClassLoader

- загружает классы приложения и библиотеки из classpath

Также можно создавать свои ClassLoader.

</details>

---

<details>
<summary>Как работает Delegation Model?</summary>

Delegation Model — механизм, при котором загрузчик сначала передает запрос родителю.

Алгоритм:

Application
↓
Platform
↓
Bootstrap

Если родитель не нашел класс:

запрос возвращается обратно вниз.

Зачем нужна:

- защита от подмены системных классов
- избежание повторной загрузки

</details>

---

<details>
<summary>Что такое загрузка, линковка и инициализация?</summary>

Это этапы жизненного цикла класса в JVM.

Loading
- загрузка байткода класса

Linking
- проверка
- выделение памяти
- разрешение ссылок

Initialization
- выполнение static кода

</details>

---

<details>
<summary>Из каких этапов состоит жизненный цикл класса?</summary>

Жизненный цикл класса:

1. Loading
2. Linking
    - Verification
    - Preparation
    - Resolution
3. Initialization

</details>

### Блок 3 — память JVM

---

<details>
<summary>Какие области памяти есть в JVM?</summary>

В JVM есть следующие области памяти:

- [Heap](#heap)
- [Stack](#stack)
- [Metaspace](#metaspace)
- Native Method Stack
- Code Cache
- PC Register

</details>

---

<a id="heap"></a>
<details>
<summary>Что хранится в Heap?</summary>


Heap — общая память для всех потоков.

Там хранятся:

- все объекты (`new`)
- массивы
- поля объектов (instance variables)
- String Pool (строковый пул внутри Heap)

Важно:
объекты живут в Heap и управляются Garbage Collector’ом.

</details>

---

<a id="stack"></a>
<details>
<summary>Что хранится в Stack?</summary>

Stack — память одного потока.

Там находятся:

- локальные переменные методов
- параметры методов
- ссылки на объекты (не сами объекты)
- информация о вызовах методов

Особенность:
у каждого потока свой Stack

</details>

---

<a id="metaspace"></a>
<details>
<summary>Что такое Metaspace?</summary>

Metaspace — область памяти JVM для хранения метаданных классов.

Там хранятся:

- структура классов
- методы
- поля
- сигнатуры

Важно:

- появился в Java 8
- заменил PermGen
- использует native memory (память ОС)

Связь:

Method Area (логическая область)
→ реализуется через Metaspace в HotSpot JVM

</details>

---

<details>
<summary>Чем Heap отличается от Stack?</summary>

**Heap:**
- общая память для всех потоков
- хранит объекты
- медленнее
- управляется GC

**Stack:**
- отдельный для каждого потока
- хранит вызовы методов и локальные данные
- очень быстрый
- работает по LIFO

</details>

---

<details>
<a id="objects"></a>
<summary>Где хранятся объекты?</summary>

Все объекты создаются в Heap.

</details>

---

<details>
<summary>Где хранятся примитивы?</summary>

- локальные примитивы → Stack
- поля объектов → Heap (внутри объекта)
- static поля → Metaspace (логически через Method Area)

</details>

---

<details>
<summary>Где хранятся ссылки?</summary>

- локальные ссылки → Stack
- сами объекты → Heap

</details>

---

<details>
<summary>Что такое StackOverflowError?</summary>

StackOverflowError возникает, когда переполняется стек вызовов.

Причины:

- бесконечная рекурсия
- слишком глубокие вызовы методов

</details>

---

<details>
<summary>Что такое OutOfMemoryError?</summary>

OutOfMemoryError возникает, когда JVM не может выделить память.

Причины:

- переполнение Heap
- переполнение Metaspace
- нехватка native memory

</details>

### Блок 4 — Garbage Collector

---

<details>
<summary>Что такое Garbage Collector?</summary>

Garbage Collector (GC) — это встроенный механизм JVM, который автоматически управляет памятью.

Он:
- находит неиспользуемые объекты
- освобождает память в Heap
- снижает необходимость ручного управления памятью

</details>

---

<details>
<summary>Зачем нужен Garbage Collector?</summary>

GC нужен для:

- автоматического освобождения памяти
- удаления объектов, которые больше не используются
- предотвращения утечек памяти

</details>

---

<details>
<summary>Как работает GC?</summary>

GC работает в фоне и отслеживает достижимость объектов.

Основная идея:

- объект считается “живым”, если на него есть ссылка
- если до объекта нельзя добраться → он считается мусором

GC строит граф объектов, начиная от [GC Roots](#gc-roots).

</details>

---

<a id="gc-roots"></a>
<details>
<summary>Что такое GC Roots?</summary>


GC Roots — это стартовые точки, от которых GC начинает обход объектов.

К ним относятся:

- локальные переменные в Stack
- активные потоки
- static переменные
- JNI ссылки

Все объекты, достижимые от GC Roots → считаются живыми.

</details>

---

<details>
<summary>Какие поколения памяти существуют?</summary>

Heap делится на поколения:

- [Young Generation](#young-gen)
- [Old Generation](#old-gen)
- Metaspace (метаданные классов — не часть Heap)

Идея:
большинство объектов живут недолго → поэтому их выгодно чистить отдельно

</details>

---

<a id="young-gen"></a>
<details>
<summary>Что такое Young Generation?</summary>


Young Generation — область Heap для новых объектов.

Состоит из:

- Eden
- Survivor S0
- Survivor S1

Особенность:
- большинство объектов здесь быстро умирают

</details>

---

<details>
<summary>Как работает Young Generation?</summary>

Процесс:

1. Объекты создаются в Eden
2. Когда Eden заполняется → запускается Minor GC
3. Живые объекты перемещаются в Survivor (S0 / S1)
4. После нескольких циклов → объекты переходят в Old Generation

</details>

---

<a id="old-gen"></a>
<details>
<summary>Что такое Old Generation?</summary>


Old Generation — область Heap для долгоживущих объектов.

Туда попадают объекты, которые:

- пережили несколько Minor GC
- считаются “долгоживущими”

</details>

---

<details>
<summary>Что такое Minor GC?</summary>

Minor GC — сборка мусора в Young Generation.

Что происходит:

- очищается Eden
- живые объекты перемещаются в Survivor
- при “старении” → объекты попадают в Old Generation

</details>

---

<details>
<summary>Что такое Major GC?</summary>

Major GC — сборка мусора в Old Generation.

Особенности:

- работает со старой памятью
- запускается реже, чем Minor GC
- может вызывать Stop-The-World паузы

</details>

---

<details>
<summary>Что такое Full GC?</summary>

Full GC — полная сборка мусора в JVM.

Очищает:

- Young Generation
- Old Generation
- иногда Metaspace

Это самая “тяжёлая” операция GC.

</details>

---

<details>
<summary>Что такое Stop-The-World?</summary>

Stop-The-World (STW) — это пауза, во время которой:

- все потоки приложения останавливаются
- GC безопасно выполняет очистку памяти

</details>

---

<details>
<summary>Какие существуют типы GC?</summary>

### 1. Serial GC
- один поток
- полностью останавливает приложение
- простой и лёгкий

---

### 2. Parallel GC
- несколько потоков
- STW паузы есть
- высокая пропускная способность

---

### 3. G1 GC
- делит Heap на регионы
- старается ограничивать паузы
- баланс производительности и предсказуемости

---

### 4. ZGC
- почти полностью параллельный
- минимальные паузы (миллисекунды)
- подходит для больших систем

</details>


### Блок 5 — исполнение кода

- Что такое JIT?
- Зачем нужен JIT?
- Как работает JIT?
- Что такое интерпретация байткода?
- Что такое Code Cache?
- Что такое прогрев JVM?
- Что такое inline методы?
- Что такое AOT?

### Блок 6 — байткод

- Что такое байткод?
- Что содержит .class файл?
- Что такое javac?
- Что такое javap?
- Что такое invokedynamic?

### Блок 7 — сложные вопросы (часто на middle)

- Что такое Metaspace leak?
- Что такое ClassLoader leak?
- Почему может возникнуть утечка памяти в Java?
- Как найти проблему с GC?
- Что такое escape analysis?