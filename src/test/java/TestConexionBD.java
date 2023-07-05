import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConexionBD {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/mi_base_de_datos?useSSL=false&serverTimezone=America/Mexico_City";
        String usuario = "root";
        String contraseña = "Jair2609#";
        String sql = "SELECT * FROM clientes";
       

        try {
            Connection conexión = DriverManager.getConnection(jdbcUrl, usuario, contraseña);
            Statement statement = conexión.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            System.out.println("Conexión exitosa a la base de datos");
            // Realiza operaciones adicionales con la conexión aquí
            while (resultSet.next()) {
                int id = resultSet.getInt("idclientes");
                String nombre = resultSet.getString("nombres");
                String apellido = resultSet.getString("apellido");
                // Accede a otros campos de la tabla según sea necesario

                System.out.println("ID: " + id);
                System.out.println("Nombre: " + nombre);
                System.out.println("Apellido: " + apellido);
                System.out.println("---------------------");
            }

            resultSet.close();
            statement.close();
            conexión.close();

        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }
    }
}

