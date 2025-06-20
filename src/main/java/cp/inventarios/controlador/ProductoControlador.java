package cp.inventarios.controlador;

import cp.inventarios.modelo.Producto;
import cp.inventarios.servicio.ProductoServicio;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("inventario-app") //Nuestra aplicacion
@CrossOrigin(value = "http://localhost:4200") //Puerto por defecto de Angular, obligatorio para realizar peticiones http
public class ProductoControlador {
    private static final Logger logger = LoggerFactory.getLogger(ProductoControlador.class);

    @Autowired
    private ProductoServicio  productoServicio;

    @GetMapping("/productos") //Ruta donde se desplegaran los productos
    public List<Producto> obtenerProductos(){
        List<Producto> productos = this.productoServicio.listarProductos();
        logger.info("Listado de productos de la lista:");
        productos.forEach(producto -> logger.info(producto.toString()));
        return productos;
    }
}
