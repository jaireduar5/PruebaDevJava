import com.azurianTest.dao.ClienteDAO;
import com.azurianTest.model.Cliente;
import com.azurianTest.model.JPAUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

import static org.junit.Assert.*;

public class ClienteDAOTest {
    private EntityManagerFactory emf;
    private EntityManager em;
    private ClienteDAO clienteDAO;

    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("your_persistence_unit_name");
        em = emf.createEntityManager();
        clienteDAO = new ClienteDAO();
        clienteDAO.setEntity(em);
    }

    @After
    public void tearDown() {
        em.close();
        emf.close();
    }

    @Test
    public void testGuardarCliente() {
        // Crear un objeto Cliente para guardar en la base de datos
        Cliente cliente = new Cliente();
        // Establecer propiedades del cliente
        
        // Guardar el cliente utilizando el método de la clase ClienteDAO
        clienteDAO.guardarCliente(cliente);

        // Realizar las aserciones para verificar que el cliente se haya guardado correctamente
        Cliente clienteGuardado = em.find(Cliente.class, cliente.getIdClientes());
        assertNotNull(clienteGuardado);
        // Realizar más aserciones según las propiedades del cliente

        // Eliminar el cliente guardado para limpiar la base de datos
        em.getTransaction().begin();
        em.remove(clienteGuardado);
        em.getTransaction().commit();
    }

    @Test
    public void testObtenerClientes() {
        // Obtener la lista de clientes utilizando el método de la clase ClienteDAO
        List<Cliente> listaClientes = clienteDAO.obtenerClientes();

        // Realizar las aserciones para verificar la lista de clientes obtenida
        assertNotNull(listaClientes);
        // Realizar más aserciones según la lógica de obtención de clientes

        // Realizar más pruebas unitarias para otros métodos de la clase ClienteDAO si es necesario
    }

    @Test
    public void testBuscarCliente() {
        // Crear un objeto Cliente y guardarlo en la base de datos
        Cliente cliente = new Cliente();
        // Establecer propiedades del cliente
        em.getTransaction().begin();
        em.persist(cliente);
        em.getTransaction().commit();

        // Buscar el cliente utilizando el método de la clase ClienteDAO
        Cliente clienteEncontrado = clienteDAO.buscarCliente(cliente.getIdClientes());

        // Realizar las aserciones para verificar que el cliente se haya encontrado correctamente
        assertNotNull(clienteEncontrado);
        // Realizar más aserciones según las propiedades del cliente

        // Eliminar el cliente para limpiar la base de datos
        em.getTransaction().begin();
        em.remove(cliente);
        em.getTransaction().commit();
    }

    @Test
    public void testEliminar() {
        // Crear un objeto Cliente y guardarlo en la base de datos
        Cliente cliente = new Cliente();
        // Establecer propiedades del cliente
        em.getTransaction().begin();
        em.persist(cliente);
        em.getTransaction().commit();

        // Eliminar el cliente utilizando el método de la clase ClienteDAO
        clienteDAO.eliminar(cliente.getIdClientes());

        // Verificar que el cliente se haya eliminado correctamente
        Cliente clienteEliminado = em.find(Cliente.class, cliente.getIdClientes());
        assertNull(clienteEliminado);
    }

    @Test
    public void testEditar() {
        // Crear un objeto Cliente y guardarlo en la base de datos
        Cliente cliente = new Cliente();
        // Establecer propiedades del cliente
        em.getTransaction().begin();
        em.persist(cliente);
        em.getTransaction().commit();

        // Modificar propiedades del cliente
        // ...

        // Editar el cliente utilizando el método de la clase ClienteDAO
        clienteDAO.editar(cliente);

        // Verificar que el cliente se haya editado correctamente
        Cliente clienteEditado = em.find(Cliente.class, cliente.getIdClientes());
        // Realizar aserciones según las propiedades modificadas

        // Eliminar el cliente para limpiar la base de datos
        em.getTransaction().begin();
        em.remove(cliente);
        em.getTransaction().commit();
    }
}
