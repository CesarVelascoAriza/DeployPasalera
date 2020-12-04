package co.edu.ucentral.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Transacciones")
public class Transaccion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String numeroCuentaOrigen;
	private String numeroCuentaDestino;
	private String descipcionPago;
	private double valorPago;
	private int banco;
	private long idTxBanco;
	private int idFactura;
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecharegistro;
	@JoinColumn(name = "cliente", referencedColumnName = "id")
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Cliente cliente;
	@JoinColumn(name = "comercios", referencedColumnName = "id")
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Comercio comercios;
	@JoinColumn(name = "estado", referencedColumnName = "id")
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Estado estado;
	
	public Transaccion() {
		
	}
	public Transaccion(String numeroCuentaOrigen, String numeroCuentaDestino, String descipcionPago, double valorPago,
			int banco, Cliente cliente, Comercio comercios, Estado estado) {
		super();
		this.numeroCuentaOrigen = numeroCuentaOrigen;
		this.numeroCuentaDestino = numeroCuentaDestino;
		this.descipcionPago = descipcionPago;
		this.valorPago = valorPago;
		this.banco = banco;
		this.fecharegistro = new Date();
		this.cliente = cliente;
		this.comercios = comercios;
		this.estado = estado;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNumeroCuentaOrigen() {
		return numeroCuentaOrigen;
	}
	public void setNumeroCuentaOrigen(String numeroCuentaOrigen) {
		this.numeroCuentaOrigen = numeroCuentaOrigen;
	}
	public String getNumeroCuentaDestino() {
		return numeroCuentaDestino;
	}
	public void setNumeroCuentaDestino(String numeroCuentaDestino) {
		this.numeroCuentaDestino = numeroCuentaDestino;
	}
	public String getDescipcionPago() {
		return descipcionPago;
	}
	public void setDescipcionPago(String descipcionPago) {
		this.descipcionPago = descipcionPago;
	}
	public double getValorPago() {
		return valorPago;
	}
	public void setValorPago(double valorPago) {
		this.valorPago = valorPago;
	}
	public Integer getBanco() {
		return banco;
	}
	public void setBanco(Integer banco) {
		this.banco = banco;
	}
	public Date getFecharegistro() {
		return fecharegistro;
	}
	public void setFecharegistro(Date fecharegistro) {
		this.fecharegistro = fecharegistro;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Comercio getComercios() {
		return comercios;
	}
	public void setComercios(Comercio comercios) {
		this.comercios = comercios;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	public long getIdTxBanco() {
		return idTxBanco;
	}
	public void setIdTxBanco(long idTxBanco) {
		this.idTxBanco = idTxBanco;
	}
	public void setBanco(int banco) {
		this.banco = banco;
	}
	public int getIdFactura() {
		return idFactura;
	}
	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}

	
	

}
