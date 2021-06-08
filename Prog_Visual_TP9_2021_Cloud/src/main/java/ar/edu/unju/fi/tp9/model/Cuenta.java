package ar.edu.unju.fi.tp9.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import ar.edu.unju.fi.tp9.model.Cliente;

@Component
@Entity
@Table(name = "CUENTAS")
public class Cuenta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "Ingresar un saldo")
	@Min(value=1,message="El Valor minimo para el saldo es de 1")
	@Column(name = "cue_saldo", nullable = false)
	private double saldo;
	
	@NotNull(message = "Ingresar una fecha correcta")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "cue_Fecha_Creacion", nullable = false)
	private LocalDate fechaCreacion;
	
	@NotEmpty(message = "Ingresar una opcion")
	@Column(name = "cue_estado", nullable = false)
	private String estado;
	
	@OneToOne(mappedBy = "cuenta", fetch = FetchType.LAZY)
	private Cliente cliente;
	
	
	public Cuenta() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Cuenta [id=" + id + ", saldo=" + saldo + ", fechaCreacion=" + fechaCreacion + ", estado=" + estado
				+ ", cliente=" + cliente + "]";
	}
}

