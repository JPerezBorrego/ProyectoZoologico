package com.zoologico.main.service;


import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;

import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
@Service
public class BBDDservicio{

    public void importarDatosCSV(){
        String rutaArchivoPersonal = "C:\\Users\\josea\\Desktop\\zoologico\\zoologico\\csv\\personal.csv";
        String rutaArchivoHabitat = "C:\\Users\\josea\\Desktop\\zoologico\\zoologico\\csv\\habitat.csv";
        String rutaArchivoZoo = "C:\\Users\\josea\\Desktop\\zoologico\\zoologico\\csv\\Zoo.csv";
        String rutaArchivoAnimales = "C:\\Users\\josea\\Desktop\\zoologico\\zoologico\\csv\\Animales.csv";
        String rutaArchivoVisitas = "C:\\Users\\josea\\Desktop\\zoologico\\zoologico\\csv\\visitas.csv";
        String rutaArchivoPrecios = "C:\\Users\\josea\\Desktop\\zoologico\\zoologico\\csv\\precios.csv";
        String db = "zoo";
        String login = "root";
        String password = "";
        String url = "jdbc:mysql://127.0.0.1/" + db;
        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, login, password);
            System.out.println("Conexión a " + db + " correcta");

            importarPersonal(connection, rutaArchivoPersonal);
            importarHabitat(connection, rutaArchivoHabitat);
            importarAnimales(connection, rutaArchivoAnimales);
            importarZoo(connection, rutaArchivoZoo); 
            importarVisitas(connection, rutaArchivoVisitas);
            importarPrecios(connection, rutaArchivoPrecios);
           

            System.out.println("Importación completa.");

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
}

    // Resto de tus métodos de importación...


    // Métodos de importación...


    

   

    public static void importarPersonal(Connection connection, String rutaArchivoPersonal) {
        String sql = "INSERT INTO personal (nombre, apellido, telefono, correo, especialidad) VALUES (?, ?, ?, ?, ?)";
    
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivoPersonal));
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split(",");
                if (campos.length == 5) {
                    String nombre = campos[0];
                    String apellido = campos[1];
                    String telefono = campos[2].replaceAll("[^\\d]", ""); // Elimina caracteres no numéricos
                    String correo = campos[3];
                    String especialidad = campos[4];
    
                    preparedStatement.setString(1, nombre);
                    preparedStatement.setString(2, apellido);
                    preparedStatement.setString(3, telefono);
                    preparedStatement.setString(4, correo);
                    preparedStatement.setString(5, especialidad);
    
                    System.out.println("Insertando en personal: " + nombre + ", " + apellido + ", " + telefono + ", " + correo + ", " + especialidad);
                    preparedStatement.executeUpdate();
                }
            }
    
            System.out.println("Importación de personal completada.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    
    
    

    public static void importarHabitat(Connection connection, String rutaArchivoHabitat) {
        String sql = "INSERT INTO habitat (nombre, tipo) VALUES (?, ?)";

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivoHabitat));
                PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split(",");
                if (campos.length == 2) {
                    String nombre = campos[0];
                    String tipo = campos[1];

                    preparedStatement.setString(1, nombre);
                    preparedStatement.setString(2, tipo);
                     System.out.println("Insertando en personal: " + nombre + ", " + tipo );
                    preparedStatement.executeUpdate();
                }
            }

            System.out.println("Importación de hábitats completada.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void importarAnimales(Connection connection, String rutaArchivoanimales) {
        String sql = "INSERT INTO animales (nombre, nombre_cientifico, genero, especie, fecha_nacimiento, habitat_id, personal_id) VALUES (?, ?, ?, ?, STR_TO_DATE(?, '%d/%m/%Y'), ?, ?)";
    
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivoanimales));
                PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split(",");
                if (campos.length == 7) {
                    String nombre = campos[0];
                    String nombreCientifico = campos[1];
                    String genero = campos[2];
                    String especie = campos[3];
                    String fechaNacimiento = campos[4].isEmpty() ? null : campos[4]; // Manejo de fecha vacía
                    int habitatId = campos[5].isEmpty() ? 0 : Integer.parseInt(campos[5]); // Manejo de campo vacío
                    int personalId = campos[6].isEmpty() ? 0 : Integer.parseInt(campos[6]); // Manejo de campo vacío
                
                    preparedStatement.setString(1, nombre);
                    preparedStatement.setString(2, nombreCientifico);
                    preparedStatement.setString(3, genero);
                    preparedStatement.setString(4, especie);
                    preparedStatement.setString(5, fechaNacimiento);
                    preparedStatement.setInt(6, habitatId);
                    preparedStatement.setInt(7, personalId);
                    System.out.println("Insertando en personal: " + nombre + ", " + nombreCientifico + "," + genero + ", " + especie + "," + fechaNacimiento + "," + habitatId + "," + personalId );
                    preparedStatement.executeUpdate();
                }
            }
    
            System.out.println("Importación de animales completada.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    

    public static void importarZoo(Connection connection, String rutaArchivozoo) {
        String sql = "INSERT INTO zoo (nombre, direccion, ciudad, pais, telefono, correo) VALUES (?, ?, ?, ?, ?, ?)";
    
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivozoo));
                PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            String linea;
            while ((linea = br.readLine()) != null) {
                // Limpia los corchetes y comillas alrededor del contenido de la línea
                linea = linea.replaceAll("\\[|\\]|\\\"", "");
    
                String[] campos = linea.split(",");
                if (campos.length == 6) {
                    String nombre = campos[0];
                    String direccion = campos[1];
                    String ciudad = campos[2];
                    String pais = campos[3];
    
                    // Limpia el número de teléfono de espacios u otros caracteres no numéricos
                    String telefonoString = campos[4].replaceAll("[^0-9]", "");
                    int telefono = Integer.parseInt(telefonoString);
    
                    String correo = campos[5];
    
                    preparedStatement.setString(1, nombre);
                    preparedStatement.setString(2, direccion);
                    preparedStatement.setString(3, ciudad);
                    preparedStatement.setString(4, pais);
                    preparedStatement.setInt(5, telefono);
                    preparedStatement.setString(6, correo);
    
                    System.out.println("Insertando en zoo: " + nombre + ", " + direccion + "," + ciudad + "," + pais + "," + telefono + "," + correo);
                    preparedStatement.executeUpdate();
                } else {
                    System.out.println("Formato incorrecto en la línea del archivo CSV: " + Arrays.toString(campos));
                }
            }
    
            System.out.println("Importación de zoológicos completada.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    




// ...

public static void importarVisitas(Connection connection, String rutaArchivoVisitias) {
    String sql = "INSERT INTO visitas (fecha_visita, cantidad_personas, tipo, precio_id, zoo_id) VALUES (?, ?, ?, ?, ?)";

    try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivoVisitias));
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
        String linea;
        while ((linea = br.readLine()) != null) {
            String[] campos = linea.split(",");
            if (campos.length == 5) {
                String fechaVisitaStr = campos[0];
                int cantidadPersonas = Integer.parseInt(campos[1]);
                String tipo = campos[2];
                double precioId = Double.parseDouble(campos[3]);
                int zooId = Integer.parseInt(campos[4]);

                // Convertir la cadena de fecha al formato de MySQL
                SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
                java.util.Date date = sdf.parse(fechaVisitaStr);
                java.sql.Date fechaVisita = new java.sql.Date(date.getTime());

                preparedStatement.setDate(1, fechaVisita);
                preparedStatement.setInt(2, cantidadPersonas);
                preparedStatement.setString(3, tipo);
                preparedStatement.setDouble(4, precioId);
                preparedStatement.setInt(5, zooId);

                System.out.println("Insertando en visitas: " + fechaVisitaStr + ", " + cantidadPersonas + "," + tipo + "," + precioId + "," + zooId);
                preparedStatement.executeUpdate();
            }
        }
        System.out.println("Importación de visitas completada.");
    } catch (Exception e) {
        e.printStackTrace();
    }
}

    
    


     public static void importarPrecios(Connection connection, String rutaArchivoPrecios) {
        String sql = "INSERT INTO precio (categoria, cantidad, zoo_id) VALUES (?, ?, ?)";

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivoPrecios));
                PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split(",");
                if (campos.length == 3) {
                    String categoria = campos[0];
                    double cantidad = Double.parseDouble(campos[1]);
                    int zooId = Integer.parseInt(campos[2]);

                    preparedStatement.setString(1, categoria);
                    preparedStatement.setDouble(2, cantidad);
                    preparedStatement.setInt(3, zooId);
                    System.out.println("Insertando en visitas: " + categoria + ", " + cantidad + "," + zooId );
                    preparedStatement.executeUpdate();
                }
            }

            System.out.println("Importación de precios completada.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    } 
}
