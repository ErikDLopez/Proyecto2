/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.functionalities.utilities.files;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *  Clase que contiene los metodos necesarios para serializar y deserializar los diferentes objetos 
 *  necesarios para el manejo de archivos e informacion en el proyecto
 * @author erik-lopez
 */
public class Serialization {
    
    /**
     * Metodo que serializa y guarda un array de usuarios
     * @param users Ingreso del array que guarda a los usuarios
     * @param filePath Nombre del fichero .dat que almacenara a los jugadores
     */
    public void serializeUsers(ArrayList<User> users, String filePath){
        
        try (FileOutputStream file = new FileOutputStream(filePath);
                ObjectOutputStream object = new ObjectOutputStream(file)) {
            
            object.writeObject(users);
            
        } catch (FileNotFoundException e) {
            System.out.println("\nHubo un error, el Fichero no ha sido encontrado.");
        } catch (IOException e) {
            System.out.println("\nHubo un error, no se puede acceder al fichero.");
        }
    
    }
    
    /**
     * Metodo que permite deserializar y obtener el array de usuarios guardado
     * @param filePath Nombre del fichero que se utilizara
     * @return El array de usuarios guardado en el fichero para poder utilizarlo
     */
    public ArrayList<User> deserializeUsers(String filePath) {
        ArrayList<User> users = new ArrayList<>();
        
        try (FileInputStream file = new FileInputStream(filePath);
                ObjectInputStream object = new ObjectInputStream(file)) {
            
            users = (ArrayList<User>) object.readObject();
            
            System.out.println("\nSe ha cargado la informacion de los jugadores guardados");
            System.out.println("El tamaño del array es de "+users.size()+"\n");
             
        } catch (FileNotFoundException e) {
            System.out.println("\nERROR: Fichero no encontrado.");
        } catch (IOException e) {
            System.out.println("\nERROR: No se puede acceder al fichero.");
        }catch (ClassNotFoundException e) {
            System.out.println("\nERROR: No se encuentra la clase.");
        }
        return users;
    }
    
    /**
     * Metodo con el que se serializa y se guarda el array de juego guardados
     * @param gamesSaved Array de juegos guardados
     * @param filePath Direccion del fichero donde se guardara el array de juegos
     */
    public void serializeGames(ArrayList<SaveGame> gamesSaved, String filePath){
        
        try (FileOutputStream file = new FileOutputStream(filePath);
                ObjectOutputStream object = new ObjectOutputStream(file)) {
            
            object.writeObject(gamesSaved);
            
        } catch (FileNotFoundException e) {
            System.out.println("\nHubo un error, el Fichero no ha sido encontrado.");
        } catch (IOException e) {
            System.out.println("\nHubo un error, no se puede acceder al fichero.");
        }
    
    }
    
    /**
     * Metodo para deserializar y obtener el array de juego que fue guardado
     * @param filePath Direccion del fichero que contiene el array de juego guardados
     * @return El array de juego guardados
     */
    public ArrayList<SaveGame> deserializeGames(String filePath) {
        ArrayList<SaveGame> gamesSaved = new ArrayList<>();
        
        try (FileInputStream file = new FileInputStream(filePath);
                ObjectInputStream object = new ObjectInputStream(file)) {
            
            gamesSaved = (ArrayList<SaveGame>) object.readObject();
            
            System.out.println("\nSe ha cargado la informacion de las partidas guardadas");
            System.out.println("El tamaño del array es de "+gamesSaved.size()+"\n");
             
        } catch (FileNotFoundException e) {
            System.out.println("\nERROR: Fichero no encontrado.");
        } catch (IOException e) {
            System.out.println("\nERROR: No se puede acceder al fichero.");
        }catch (ClassNotFoundException e) {
            System.out.println("\nERROR: No se encuentra la clase.");
        }
        return gamesSaved;
    }
}
