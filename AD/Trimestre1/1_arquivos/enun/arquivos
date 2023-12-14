Proxecto 'arquivos' 

NOTAS IMPORTANTES

Unha vez solucionado o exercicio debes enviar o proxecto completo comprimido co nome arquivos.zip

Tamen debes enviar o fonte ( ou fontes)  .java como arquivos separados.

nota : o  numero maximo de arquivos a subir e 4  e non deben totalizar en conxunto mais de 200 MB



ENUNCIADO

Introducion a arquivos e directorios

Java dispon da clase File (java.io.File) que permite realizar operacions relativas a directorios e arquivos (ou ficheiros).
clase java.io.File:

constuctor: File(StringPath)

metodos:
exists()
canRead()
canWrite()
isDirectory()
isFile()
getName()
getPath()
getAbsolutePath()
length()
lastModified()
listRoots()
listFiles()
list()
setReadOnly()
creatreNewFile()
setWritable(true)
delete()
etc ....


OBXECTIVO:  Desenvolver  un proxecto  chamado "arquivos"  que realize as tarefas especificadas a continuacion. 

Todas as tarefas deste exercicio deben desenvolverse utilizando a Clase File , o seu constructor e os seus métodos


1) metodo eDirectorio(cadea)
 que detecte se unha cadea dada corresponde a un directorio .
 cadea  debe ser un String que contena a ruta absoluta do directorio.
 imprimirase 'e un directorio' ou 'non e un directorio'  

2) metodo eFicheiro(cadea )
que comprobe se unha cadea  dada corresponde a  un ficheiro. 
cadea  debe ser un String que contena a ruta absoluta do directorio
 imprimirase 'e un ficheiro' ou 'non e un ficheiro'  

3) metodo creaDirectorio(String)
debe crear un  directorio  a partir da ruta absoluta do mesmo que se lle debe pasar coma un String . So debe crearse  dito directorio cando non exista previamente 

4) metodo  creaFicheiro(dirName, fileName);
debe crear un  ficheiro nunha ruta absoluta que exista previamente ,  estos dous valores deben pasarse ao metodo como valores String. So debe crearse  dito ficheiro en dita ruta  cando non exista previamente

5) metodo  modoAcceso (dirName, fileName);
dado a ruta absoluta  e nome dun archivo ,este metodo debe imprimir a palabra:
  "escritura si" se se pode escribir nel
  "escritura non" se non se pode escribir nel
  "lectura si" se se pode ler nel
 "lectura non" se non se pode ler nel

6) metodo   calculaLonxitude(dirName, fileName)
dado a ruta absoluta  e nome dun archivo ,este metodo  debe : imprimir a lonxitude en bytes do mesmo 

7) metodo  mLectura (dirName, fileName)
dado a ruta absoluta  e nome dun archivo ,este metodo  debe facer o arquivo de so lectura 
      
8) metodo  mEscritura (dirName, fileName)
dado a ruta e nome dun archivo ,este metodo debe facer posible escribir no arquivoo.
     
9) metodo  borraFicheiro(dirName, fileName)
dado a ruta e nome dun archivo debe eliminalo se e que existe senon lanzar a mensaxe ficheiro inexistente

10) metodo  borraDirectorio(dirName) 
dada una ruta debe eliminala se e que existe senon lanzar a mensaxe 'ruta inexistente ou con descencencia' 
  
11) metodo mContido(dirName) que amose arquivos e directorios de primeiro nivel dunha ruta absoluta dada 

12)(Opcional) metodo recur(File) que amose arquivos e subdirectorios do directorio que se lle pase como obxecto File.



**********

Usando os metodos que creache anteriormente :

 1) crear o directorio 'arquivosdir' na ruta '/home/postgres/NetBeansProjects/arquivos/' sempre e cando dito directorio non exista previamente .
Comprobar que se trata  dun directorio mediante o metodo eDirectorio que creache anteriormente 
(Comprobar que o directorio foi creado ou existe,  mediante os comandos do sistema operativo (modo texto) , ou mediante o entorno grafico) .
 
2) crear  o arquivo Products1.txt no directorio mencionado anteriormente (arquivosdir) sempre e cando dito arquivo non exista.
Comprobar que se trata  dun ficheiro mediante o metodo eFicheiro que creache anteriormente.
(Comprobar que o arquivo foi creado ou existe mediante comandos do sistema operativo (modo texto) ou mediante o entorno grafico.)
   
3)Crear o directorio 'subdir'  na ruta '/home/postgres/NetBeansProjects/arquivos/arquivosdir/' creada anteriormente
Crear o arquivo Products2.txt no directorio mencionado anteriormente (subdir)  

 4)Amosar arquivos e subdirectorios de primeiro nivel da ruta  '/home/postgres/NetBeansProjects/arquivos/arquivosdir/'
Debería amosarse o seguinte resultado:

		Products1.txt
		subdir
	 
5)amosar a seguinte informacion sobre o primeiro  arquivo (Products1.txt) creado:
	 si e posible ou non escribir nel
	 si e posible ou non ler del
	 a sua lonxitude en bytes 
	 (a continuacion debes editar manualmente  o arquivo co editor de texto e escribir un texto calquera, por exemplo a palabra  'ola', e volver a amosar a sua lonxitude en bytes (deberia ter cambiado))
 
6) Forzar a que o mesmo arquivo referido no apartado anterior   sexa de so lectura
(comprobar intentanto editar o arquivo manualmente  que no se pode escribir nada en dito arquivo)

7)forzar a que o arquivo referido no apartado anterior pase de novo a ser de novo de  escritura
(comprobar dendo o sistema operativo que se pode escribir de novo no  arquivo)

8)borrar o arquivo referido no apartado anterior
(comprobar manualmente dende o sistema operativo que o arquivo foi borrado)
	
9)borrar os o resto de arquivos e directorios creados anteriormente 

 10)(opcional) amosa usando o metodo recur(File) todos  os subdirectorios e arquivos que colgan do directorio '/home/postgres/NetBeansProjects/arquivos/arquivosdir/' 
