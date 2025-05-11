{\rtf1\ansi\ansicpg1252\cocoartf2822
\cocoatextscaling0\cocoaplatform0{\fonttbl\f0\fnil\fcharset0 Menlo-Regular;}
{\colortbl;\red255\green255\blue255;\red70\green137\blue204;\red24\green24\blue24;\red193\green193\blue193;
\red202\green202\blue202;}
{\*\expandedcolortbl;;\cssrgb\c33725\c61176\c83922;\cssrgb\c12157\c12157\c12157;\cssrgb\c80000\c80000\c80000;
\cssrgb\c83137\c83137\c83137;}
\paperw11900\paperh16840\margl1440\margr1440\vieww11520\viewh8400\viewkind0
\deftab720
\pard\pardeftab720\partightenfactor0

\f0\fs26 \cf2 \cb3 \expnd0\expndtw0\kerning0
\outl0\strokewidth0 \strokec2 SELECT\cf4 \cb1 \strokec4 \
\pard\pardeftab720\partightenfactor0
\cf4 \cb3 \strokec4     TAREA.TITULO \cf2 \strokec2 AS\cf4 \strokec4  TAREA,\cf4 \cb1 \strokec4 \
\cf4 \cb3 \strokec4     USUARIO.NOMBRE \cf2 \strokec2 AS\cf4 \strokec4  CREADOR,\cf4 \cb1 \strokec4 \
\cf4 \cb3 \strokec4     PROYECTO.NOMBRE \cf2 \strokec2 AS\cf4 \strokec4  PROYECTO\cf4 \cb1 \strokec4 \
\pard\pardeftab720\partightenfactor0
\cf2 \cb3 \strokec2 FROM\cf4 \cb1 \strokec4 \
\pard\pardeftab720\partightenfactor0
\cf4 \cb3 \strokec4     TAREA\cf4 \cb1 \strokec4 \
\pard\pardeftab720\partightenfactor0
\cf2 \cb3 \strokec2 JOIN\cf4 \strokec4  USUARIO \cf2 \strokec2 ON\cf4 \strokec4  TAREA.ID_USU_CREADOR \cf5 \strokec5 =\cf4 \strokec4  USUARIO.ID_USUARIO\cf4 \cb1 \strokec4 \
\cf2 \cb3 \strokec2 JOIN\cf4 \strokec4  PROYECTO \cf2 \strokec2 ON\cf4 \strokec4  TAREA.ID_PROYECTO \cf5 \strokec5 =\cf4 \strokec4  PROYECTO.ID_PROYECTO;\cf4 \cb1 \strokec4 \
}