package ar.edu.unju.fi.tp9.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.edu.unju.fi.tp9.model.Producto;

@Component
@Entity
@Table(name = "COMPRAS")
public class Compra {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Min(value=1, message = "Ingresar valores superiores o igual a 1")
	@Column(name = "com_codigo", nullable = false)
	private int codigo;
	
	//@Valid
	@Autowired
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pro_id")
	private Producto producto;
	
	@Min(value=1, message = "Valor minimo permitido es 1")
	@Column(name = "com_cantidad", nullable = false)
	private int cantidad;
	
	@Column(name = "com_total", nullable = false)
	private double total;

	
	public Compra() {
		// TODO Auto-generated constructor stub
	}

	public Compra(int codigo, Producto producto, int cantidad, double total) {
		super();
		this.codigo = codigo;
		this.producto = producto;
		this.cantidad = cantidad;
		this.total = total;
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public Producto getProducto() {
		return producto;
	}


	public void setProducto(Producto producto) {
		this.producto = producto;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	public double getTotal() {
		this.total = this.producto.getPrecio() * this.cantidad;
		return this.total;
	}


	public void setTotal(double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Compra [id=" + id + ", codigo=" + codigo + ", producto=" + producto + ", cantidad=" + cantidad
				+ ", total=" + total + "]";
	}

	/*public double obtenerCalculoTotal() {
		double total = cantidad*producto.getPrecio();
		return total;
	}*/
}
