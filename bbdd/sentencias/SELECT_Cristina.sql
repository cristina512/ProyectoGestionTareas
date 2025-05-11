/*Lista usuarios que están en un equipo, mostrando su nombre, correo
y nombre del equipo al que pertenecen*/

SELECT U.NOMBRE AS USUARIO, U.EMAIL, E.NOMBRE AS EQUIPO 
FROM USUARIO U JOIN USUARIO_EQUIPO UE 
ON U.ID_USUARIO = UE.ID_USUARIO 
JOIN EQUIPO E 
ON UE.ID_EQUIPO = E.ID_EQUIPO;