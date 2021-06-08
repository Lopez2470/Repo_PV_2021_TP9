package ar.edu.unju.fi.tp9.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "PRODUCTOS")
public class Producto {
	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long id;
	
	@Min(value=000001, message = "Ingresar nros. de codigo superiores o igual a 1")
	@Column(name = "pro_codigo")
	private int codigo;
	
	@NotEmpty(message = "Nombres de Productos permitidos entre 2 y 100 caracteres. No se permiten campos vacios")
	@Size(min = 2, max = 100)
	//@Size(min = 2, max = 100, message = "Nombres de Productos permitidos entre 2 y 100 caracteres")
	@Column(name = "pro_nombre", nullable = false, length = 100)
	private String nombre;
	
	@Min(value=100, message = "Valor minimo permitido es de 100")
	@Column(name = "pro_precio", nullable = false)
	private double precio;
	
	@NotEmpty(message = "Marcas de Productos permitidos entre 2 y 80 caracteres")
	//@NotBlank(message = "No se permiten nombres Marcas de Productos en blanco")
	//@Size(min = 2, max = 100, message = "Nombres de Productos permitidos entre 2 y 80 caracteres, no se permiten Marcas vacias")
	@Size(min = 2, max = 80)
	@Column(name = "pro_marca", nullable = false, length = 80)
	private String marca;
	
	@Min(value=0001, message = "Valor minimo permitido es de 1")
	@Column(name = "pro_stock", nullable = false)
	private int stock;
		
	/**/
	//@OneToMany(mappedBy = "producto")
	//private List<Producto> producto = new ArrayList<>();
	/**/
	
	/* Constructor por defecto*/
	public Producto() {
		// TODO Auto-generated constructor stub
	}
	
	public Producto(int codigo, String nombre, double precio, String marca, int stock) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
		this.marca = marca;
		this.stock = stock;
	}

	/*Getter y Setters de los atributos privados*/
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "Producto [id=" + id + ", codigo=" + codigo + ", nombre=" + nombre + ", precio=" + precio + ", marca="
				+ marca + ", stock=" + stock + "]";
	}
}
