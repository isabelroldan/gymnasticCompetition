package iesFranciscodelosRios.interfaces;

public interface iGUI {


    /*
mostrarInterfazprincipal()
1.Gestion de Gimnastas
2.Gestion de Competiciones
3. Save and exit
4.Salir
     */
    void mainMenu();
/*
opt 1:mostrarGestionGimnastas()
1.Federar Gimnasta
2.Buscar Gimnasta(DNI)
3.Modificar Gimnasta
4.Eliminar Gimnasta
5.Mostrar todas las gimnastas
6.atras
*/
    void crudGymnastic();
/*
opt3:mostrarModificaGimnasta()
1.Modificar Nombre
2.Modificar Telefono
3.Modificar Correo
4. Categoría
5. Club
6. Salir
* */
    void updateGymnast();
/*
opt 2:MostrarGestionCompeticiones()
1.Gestionar Competicion
2.Gestionar Participaciones
3.Gestionar Pruebas
4.Salir
* */
    void competitionManager();
/*
opt 1:mostrarGestionarCompeticion()
1.Crear Competicion
2.Modificar Competicion
3.Buscar Competicion
4.Borrar Competicion
5.insertar pruebas
6. Mostrar todas las competiciones
7.Salir
* */
    void crudCompetition();
/*
El update de competiciones
void changeCompetition();
1. Descripcion
2. Fecha de inicio
3. Salir
*/
    void updateCompetitions();
/*
opt 2:mostrarGestionarParticipantes()
1.Crear participacion
2.Modificar participacion
3.Buscar participacion
4.Borrar participacion
5.Poner Puntuacion
6.Salir
* */
    void crudPaticipations();
    /*
opt 2:modificar participacion()
1.cambiar dorsal
2.cambiar participacion
3.cambiar hora
4.cambiar puntos
5.salir
    * */

    void updateParticipation();
    /*
opt 3:mostrarGestionPruebas()
1.Crear Prueba
2.Modificar Prueba
3.Buscar Prueba
4.Borrar Prueba
5.insertar participacion
6. Mostrar todas las pruebas
7. Ver ganador
8.Salir
    * */
    void trial();

    void crudTrials();
    /*
    opt 2:modificaPrueba()
1.Cambiar tipo
2.Cambiar categoria
3.Cambiar aparato
4.salir
    * */
    void updateTrial();
    /*
void mainGroup();
1. Crear grupo
2. Mostrar grupo
3. Modificar grupo
4. Eliminar grupo
5. insertar gimnasta
6. eliminar gimnasta
7. Salir
    * */

    void crudGroup();
    /*
void changeGroup();
1. Club
2. Salir
*/
    void updateGroup();
}
