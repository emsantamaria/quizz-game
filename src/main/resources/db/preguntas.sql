DROP TABLE if EXISTS pregunta ;

DROP TABLE if EXISTS respuestaPreguntas ;

CREATE TABLE pregunta(
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    pregunta TEXT NOT NULL,
    tipo TEXT NOT NUll,
    pista TEXT NOT NULL
);

CREATE TABLE respuestaPreguntas(
    id INTEGER,
    respuesta text NOT NULL,
    correcta TEXT not null
);

INSERT into pregunta(pregunta, tipo, pista)values
('¿Quien pinto La Geoconda?','Arte','Gran pintor'),
('¿Que animal de los siguientes es un dinosaurio?','Ciencia','A veces lo que parece no es'),
('¿Quien invento la gravedad?','Ciencia','La gravedad es un fenomeno natural'),
('¿Que es lo mas pequeño que se haya descubierto?','Ciencia','Hay diferentes tipo pero todos mas pequeños que un nucleo'),
('En la novela de Edgar Allan Poe (Read Death) todos los invitados de la fiesta mueren de...','Arte','La novela transcurre en el siglo 20'),
('Segun la mitologia nordica,¿Cuantos pasos dara Thor antes de morir?','Mitologia','Apenas pudo respirar tras la batalla'),
('Completa la frase: Dios dijo ama a tu enemigo y yo...','Arte','Frase de autorefleccion y aceptacion personal'),
('Einstain dijo que la luz era','Ciencia','Explicada en la teoria de la relatividad'),
('De que mitologia es el Dios Marte','Mitologia','Muchos planetas llevan el nombre de dioses griegos'),
('Segun la mitologia romana Hercules...','Mitologia','12 fueron las tareas'),
('Un liquido no newtoniano es...','Ciencia','De un estado a otro'),
('¿Toda energia genera energia calorifica?','Ciencia','La energia no es mas que atomos en aceleracion'),
('En la pelicula el Jango Desencadenado, el papel de Jango es interpretado por:','Arte','Este actor hace de villano en The Amazig SpiderMan 2'),
('La Divina Comedia fue escrita por...','Arte','El nombre del autor se ha utilizado para nombrar personajes con relacion al infierno'),
('El solo de guitarra en la cancion Give In to Me de Michael Jackson ¿Quien fue el guitarrista?','Arte','Guitarristra principal de un banda de rock contemporanea con Nirvana'),
('El menor de los hijos de Cronos es...','Mitologia','Este lo derrotaria'),
('Sejmet era la Diosa egipcia de la...','Mitologia','Poseia una fuerza descomunal'),
('Rah era un dios cuya apariencia era mitad humano y mitad...','Mitologia','Rah solia volar cerca del sol')
;

INSERT into respuestaPreguntas(id,respuesta,correcta)values
(1,'Pablo Picasso','False'),
(1,'Juan Cuesta','False'),
(1,'Leonardo Davinci','True'),
(1,'Ellon Musk','False'),
(2,'Leon','False'),
(2,'Buitre','True'),
(2,'Dragon de Comodo','False'),
(2,'Megatherium','False'),
(3,'Issac Newton','False'),
(3,'Galileo Galilei','False'),
(3,'Ninguno','True'),
(3,'Uno complemento la investigacion del otro','False'),
(4,'Nucleo atomico','False'),
(4,'Proton','False'),
(4,'Neutrino Solar','False'),
(4,'Quartz','True'),
(5,'Anthrax','True'),
(5,'Ebola','False'),
(5,'Peste Negra','False'),
(5,'Peste Roja','False'),
(6,'5','False'),
(6,'3','True'),
(6,'Thor murio volando','False'),
(6,'7','False'),
(7,'Me ame a mi mismo','True'),
(7,'Abrace mi orgullo','False'),
(7,'Perdone a aquellos que me dieron la espalda','False'),
(7,'Me enamore de el','False'),
(8,'Un espectro que viaja a una velocidad relativa','False'),
(8,'Lo unico no relativo conocido por el hombre','True'),
(9,'Romana','True'),
(9,'Griega','False'),
(9,'Anglosajona','False'),
(9,'Mesopotamica','False'),
(10,'Mato a Medusa','False'),
(10,'Mato al Jabalí de Erimanto','True'),
(10,'Participo en la rebelion de Karkatos','False'),
(10,'Mato a Heron','False'),
(11,'Un liquido no diluible en agua','False'),
(11,'Un liquido que no puede llegar al punto de ebullicion','False'),
(11,'Un liquido que se comparta como solido al ejercerle una fuerza','True'),
(11,'Un gas convertido en liquido','False'),
(12,'Verdadero','True'),
(12,'False','False'),
(13,'Samuel L. Jackson','False'),
(13,'Morgan Freeman','False'),
(13,'Jamie Fox','True'),
(13,'Anthony McLovin','False'),
(14,'Mario Bennedetti','False'),
(14,'Dante Alligeri','True'),
(14,'Lucio Morningstar','False'),
(14,'Dante Bennedetti','False'),
(15,'Bryan May','False'),
(15,'Van Hallen','False'),
(15,'Slash','True'),
(15,'Prince','False'),
(16,'Hefesto','False'),
(16,'Zeus','True'),
(16,'Prometeo','False'),
(16,'Hades','False'),
(17,'Muerte','False'),
(17,'Fertilidad','False'),
(17,'Guerra','True'),
(17,'Acero','False'),
(18,'Camello','False'),
(18,'Aguila','True'),
(18,'Cocodrilo','False'),
(18,'Gato','False')
;
-- INSERTAR PREGUNTAS 19 a 30
INSERT INTO pregunta(pregunta, tipo, pista) VALUES
('¿Quién pintó la Última Cena?', 'Arte', 'Famoso pintor italiano del Renacimiento'),
('¿Qué animal tiene el récord de velocidad en tierra?', 'Ciencia', 'Un felino rápido'),
('¿En qué país se encuentra la Gran Muralla?', 'Cultura', 'Una gran construcción antigua'),
('¿Cómo se llama el continente que no tiene países?', 'Geografía', 'Un continente de hielo'),
('¿Qué metal es líquido a temperatura ambiente?', 'Ciencia', 'Un metal que se usa en termómetros'),
('¿Quién es el dios griego del vino?', 'Mitología', 'Hijo de Zeus y Sémele'),
('¿Qué famoso físico formuló la teoría de la relatividad?', 'Ciencia', 'Un genio de la física moderna'),
('¿Cuál es la capital de Francia?', 'Geografía', 'Una ciudad famosa por la Torre Eiffel'),
('¿Quién escribió "Cien años de soledad"?', 'Literatura', 'Un autor colombiano'),
('¿En qué ciudad se celebró la primera Olimpiada moderna?', 'Historia', 'En la ciudad que inspiró los juegos'),
('¿Cuántos planetas conforman el sistema solar?', 'Ciencia', 'La respuesta está en el número de planetas'),
('¿Cuál es el océano más grande del mundo?', 'Geografía', 'Un océano que rodea grandes continentes'),
('¿Qué obra de arte es conocida como "La Monalisa"?', 'Arte', 'Un famoso cuadro de Leonardo da Vinci'),
('¿Qué evento histórico ocurrió el 14 de julio de 1789?', 'Historia', 'Un evento clave en la Revolución Francesa'),
('¿Qué tipo de arte tiene como característica la deformación de figuras?', 'Arte', 'Estilo artístico muy influyente del siglo XX'),
('¿Quién es el dios griego de la guerra?', 'Mitología', 'El hijo de Zeus y Hera'),
('¿Qué gas constituye la mayor parte de la atmósfera terrestre?', 'Ciencia', 'Un gas esencial para la respiración'),
('¿Qué famoso inventor desarrolló la bombilla eléctrica?', 'Ciencia', 'Un genio de la electricidad'),
('¿Quién escribió la novela "Don Quijote de la Mancha"?', 'Literatura', 'Un autor español famoso'),
('¿Qué autor es conocido por "Romeo y Julieta"?', 'Literatura', 'Un dramaturgo inglés');

-- INSERTAR RESPUESTAS PARA LAS PREGUNTAS 19 A 30
INSERT INTO respuestaPreguntas(id, respuesta, correcta) VALUES
-- Pregunta 19: ¿Quién pintó la Última Cena?
(19, 'Miguel Ángel', 'False'),
(19, 'Leonardo da Vinci', 'True'),
(19, 'Raphael', 'False'),
(19, 'Donatello', 'False'),

-- Pregunta 20: ¿Qué animal tiene el récord de velocidad en tierra?
(20, 'León', 'False'),
(20, 'Guepardo', 'True'),
(20, 'Antílope', 'False'),
(20, 'Tigre', 'False'),

-- Pregunta 21: ¿En qué país se encuentra la Gran Muralla?
(21, 'Japón', 'False'),
(21, 'India', 'False'),
(21, 'China', 'True'),
(21, 'México', 'False'),

-- Pregunta 22: ¿Cómo se llama el continente que no tiene países?
(22, 'Asia', 'False'),
(22, 'Antártida', 'True'),
(22, 'África', 'False'),
(22, 'Europa', 'False'),

-- Pregunta 23: ¿Qué metal es líquido a temperatura ambiente?
(23, 'Mercurio', 'True'),
(23, 'Plomo', 'False'),
(23, 'Aluminio', 'False'),
(23, 'Oro', 'False'),

-- Pregunta 24: ¿Quién es el dios griego del vino?
(24, 'Apolo', 'False'),
(24, 'Hermes', 'False'),
(24, 'Dionisio', 'True'),
(24, 'Zeus', 'False'),

-- Pregunta 25: ¿Qué famoso físico formuló la teoría de la relatividad?
(25, 'Isaac Newton', 'False'),
(25, 'Albert Einstein', 'True'),
(25, 'Nikola Tesla', 'False'),
(25, 'Marie Curie', 'False'),

-- Pregunta 26: ¿Cuál es la capital de Francia?
(26, 'Londres', 'False'),
(26, 'Roma', 'False'),
(26, 'Madrid', 'False'),
(26, 'París', 'True'),

-- Pregunta 27: ¿Quién escribió "Cien años de soledad"?
(27, 'Gabriel García Márquez', 'True'),
(27, 'Julio Cortázar', 'False'),
(27, 'Mario Vargas Llosa', 'False'),
(27, 'Carlos Fuentes', 'False'),

-- Pregunta 28: ¿En qué ciudad se celebró la primera Olimpiada moderna?
(28, 'Roma', 'False'),
(28, 'Atenas', 'True'),
(28, 'Londres', 'False'),
(28, 'París', 'False'),

-- Pregunta 29: ¿Cuántos planetas conforman el sistema solar?
(29, '9', 'True'),
(29, '8', 'False'),
(29, '7', 'False'),
(29, '10', 'False'),

-- Pregunta 30: ¿Cuál es el océano más grande del mundo?
(30, 'Atlántico', 'False'),
(30, 'Índico', 'False'),
(30, 'Pacífico', 'True'),
(30, 'Ártico', 'False');

-- INSERTAR PREGUNTAS 31 a 40
INSERT INTO pregunta(pregunta, tipo, pista) VALUES
('¿Quién pintó la Capilla Sixtina?', 'Arte', 'Un pintor renacentista italiano'),
('¿Cuál es el número atómico del oro?', 'Ciencia', 'Un número relacionado con un metal precioso'),
('¿Cuál es la moneda oficial de Japón?', 'Geografía', 'Una moneda muy conocida en Asia'),
('¿Qué tipo de animal es el pulpo?', 'Ciencia', 'Un invertebrado marino'),
('¿Qué es el ADN?', 'Ciencia', 'Contiene la información genética'),
('¿En qué país se encuentra el Machu Picchu?', 'Geografía', 'En un país de Sudamérica'),
('¿Quién inventó el teléfono?', 'Ciencia', 'Un inventor que revolucionó las comunicaciones'),
('¿Qué océano está entre América y Europa?', 'Geografía', 'Un océano que une dos continentes'),
('¿Quién fue el primer presidente de los Estados Unidos?', 'Historia', 'Un líder militar y político'),
('¿Cómo se llama el satélite natural de la Tierra?', 'Ciencia', 'Nuestro satélite más cercano'),
('¿Cuál es la capital de Italia?', 'Geografía', 'Una ciudad con una rica historia'),
('¿Qué animal es conocido por su capacidad para volar en reversa?', 'Ciencia', 'Un insecto'),
('¿Cómo se llama la famosa teoría de la evolución?', 'Ciencia', 'Una teoría biológica'),
('¿Quién escribió "1984"?', 'Literatura', 'Un escritor británico'),
('¿Qué animal es conocido como el "rey de la selva"?', 'Ciencia', 'Un gran felino');

-- INSERTAR RESPUESTAS PARA LAS PREGUNTAS 31 a 40
INSERT INTO respuestaPreguntas(id, respuesta, correcta) VALUES
-- Pregunta 31: ¿Quién pintó la Capilla Sixtina?
(31, 'Miguel Ángel', 'True'),
(31, 'Leonardo da Vinci', 'False'),
(31, 'Raphael', 'False'),
(31, 'Donatello', 'False'),

-- Pregunta 32: ¿Cuál es el número atómico del oro?
(32, '77', 'False'),
(32, '79', 'True'),
(32, '75', 'False'),
(32, '80', 'False'),

-- Pregunta 33: ¿Cuál es la moneda oficial de Japón?
(33, 'Won', 'False'),
(33, 'Yen', 'True'),
(33, 'Peso', 'False'),
(33, 'Dólar', 'False'),

-- Pregunta 34: ¿Qué tipo de animal es el pulpo?
(34, 'Mamífero', 'False'),
(34, 'Reptil', 'False'),
(34, 'Peces', 'False'),
(34, 'Molusco', 'True'),

-- Pregunta 35: ¿Qué es el ADN?
(35, 'Ácido Desoxirribonucleico', 'True'),
(35, 'Ácido Ribonucleico', 'False'),
(35, 'Ácido Nucleico', 'False'),
(35, 'Ribonucleico', 'False'),

-- Pregunta 36: ¿En qué país se encuentra el Machu Picchu?
(36, 'México', 'False'),
(36, 'Perú', 'True'),
(36, 'Chile', 'False'),
(36, 'Argentina', 'False'),

-- Pregunta 37: ¿Quién inventó el teléfono?
(37, 'Nikola Tesla', 'False'),
(37, 'Thomas Edison', 'False'),
(37, 'Alexander Graham Bell', 'True'),
(37, 'Samuel Morse', 'False'),

-- Pregunta 38: ¿Qué océano está entre América y Europa?
(38, 'Atlántico', 'True'),
(38, 'Pacífico', 'False'),
(38, 'Índico', 'False'),
(38, 'Ártico', 'False'),

-- Pregunta 39: ¿Quién fue el primer presidente de los Estados Unidos?
(39, 'Abraham Lincoln', 'False'),
(39, 'George Washington', 'True'),
(39, 'Thomas Jefferson', 'False'),
(39, 'John Adams', 'False'),

-- Pregunta 40: ¿Cómo se llama el satélite natural de la Tierra?
(40, 'Marte', 'False'),
(40, 'La Luna', 'True'),
(40, 'Venus', 'False'),
(40, 'Jupiter', 'False');